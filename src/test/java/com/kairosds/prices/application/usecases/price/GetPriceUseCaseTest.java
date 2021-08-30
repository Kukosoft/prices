package com.kairosds.prices.application.usecases.price;

import static com.kairosds.prices.test.CommonTestUtils.createRandomPrice;
import static com.kairosds.prices.test.CommonTestUtils.priceDomainToDto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.kairosds.prices.application.dto.PriceDto;
import com.kairosds.prices.application.input.GetPriceInputParameters;
import com.kairosds.prices.application.mapper.PriceMapper;
import com.kairosds.prices.application.mapper.PriceMapperImpl;
import com.kairosds.prices.domain.Price;
import com.kairosds.prices.domain.repository.PriceRepository;
import com.kairosds.prices.domain.service.PriceService;
import com.kairosds.prices.domain.service.PricesPriorityComparator;

@ExtendWith(MockitoExtension.class)
public class GetPriceUseCaseTest {

	@Mock
	private PriceRepository priceRepository;

	private PricesPriorityComparator pricesPriorityComparator;

	private PriceService priceService;

	private PriceMapper priceMapper;

	private GetPriceUseCase getPriceUseCase;

	@BeforeEach
	public void setup() {
		pricesPriorityComparator = spy(new PricesPriorityComparator());
		priceService = spy(new PriceService(priceRepository, pricesPriorityComparator));
		priceMapper = spy(new PriceMapperImpl());
		getPriceUseCase = new GetPriceUseCase(priceService, priceMapper);
	}

	@Test
	void getPriceByDateProductIdAndBrandIdOneFoundTest() {
		Price price = createRandomPrice();
		PriceDto expected = priceDomainToDto(price);
		LocalDateTime localDateTimeInput = LocalDateTime.of(2021, 8, 25, 18, 0);
		when(priceRepository.findByDateProductIdAndBrandId(localDateTimeInput, price.getProductId(),
				price.getBrand().getId())).thenReturn(Collections.singletonList(price));
		PriceDto actual = getPriceUseCase
				.execute(new GetPriceInputParameters(localDateTimeInput, expected.getProductId(), expected.getBrandId()));
		assertEquals(expected, actual);
		verify(priceService).getPrice(localDateTimeInput, expected.getProductId(), expected.getBrandId());
		verify(priceMapper).toDto(price);
		verify(priceRepository).findByDateProductIdAndBrandId(localDateTimeInput, price.getProductId(),
				price.getBrand().getId());
	}

	@Test
	void getPriceByDateProductIdAndBrandIdMultipleFoundTest() {
		Price price1 = createRandomPrice();
		price1.setPriority(1);
		Price price2 = createRandomPrice();
		price2.setPriority(2);
		Price price3 = createRandomPrice();
		price3.setPriority(3);
		PriceDto expected = priceDomainToDto(price3);
		LocalDateTime localDateTimeInput = LocalDateTime.of(2021, 8, 25, 18, 0);
		when(priceRepository.findByDateProductIdAndBrandId(localDateTimeInput, price3.getProductId(),
				price3.getBrand().getId())).thenReturn(List.of(price1, price2, price3));
		PriceDto actual = getPriceUseCase
				.execute(new GetPriceInputParameters(localDateTimeInput, expected.getProductId(), expected.getBrandId()));
		assertEquals(expected, actual);
		verify(priceService).getPrice(localDateTimeInput, expected.getProductId(), expected.getBrandId());
		verify(priceMapper).toDto(price3);
		verify(priceRepository).findByDateProductIdAndBrandId(localDateTimeInput, price3.getProductId(),
				price3.getBrand().getId());
	}

	@Test
	void getPriceByDateProductIdAndBrandIdNotFoundTest() {
		Price expected = createRandomPrice();
		LocalDateTime localDateTimeInput = LocalDateTime.of(2021, 8, 25, 18, 0);
		when(priceRepository.findByDateProductIdAndBrandId(localDateTimeInput, expected.getProductId(),
				expected.getBrand().getId())).thenThrow(NoSuchElementException.class);
		assertThrows(NoSuchElementException.class, () -> {
			priceService.getPrice(localDateTimeInput, expected.getProductId(), expected.getBrand().getId());
		});
	}

}
