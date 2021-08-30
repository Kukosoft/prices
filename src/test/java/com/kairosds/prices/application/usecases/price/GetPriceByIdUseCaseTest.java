package com.kairosds.prices.application.usecases.price;

import static com.kairosds.prices.test.CommonTestUtils.createRandomPrice;
import static com.kairosds.prices.test.CommonTestUtils.priceDomainToDto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.kairosds.prices.application.dto.PriceDto;
import com.kairosds.prices.application.mapper.PriceMapper;
import com.kairosds.prices.application.mapper.PriceMapperImpl;
import com.kairosds.prices.domain.Price;
import com.kairosds.prices.domain.repository.PriceRepository;
import com.kairosds.prices.domain.service.PriceService;
import com.kairosds.prices.domain.service.PricesPriorityComparator;

@ExtendWith(MockitoExtension.class)
public class GetPriceByIdUseCaseTest {

	@Mock
	private PriceRepository priceRepository;

	private PricesPriorityComparator pricesPriorityComparator;

	private PriceService priceService;

	private PriceMapper priceMapper;

	private GetPriceByIdUseCase getPriceByIdUseCase;

	@BeforeEach
	public void setup() {
		pricesPriorityComparator = spy(new PricesPriorityComparator());
		priceService = spy(new PriceService(priceRepository, pricesPriorityComparator));
		priceMapper = spy(new PriceMapperImpl());
		getPriceByIdUseCase = new GetPriceByIdUseCase(priceService, priceMapper);
	}

	@Test
	void getPriceByIdTest() {
		Price price = createRandomPrice();
		PriceDto expected = priceDomainToDto(price);
		when(priceRepository.findById(price.getId())).thenReturn(price);
		PriceDto actual = getPriceByIdUseCase.execute(price.getId());
		assertEquals(expected, actual);
		verify(priceService).getPrice(price.getId());
		verify(priceMapper).toDto(price);
		verify(priceRepository).findById(price.getId());
	}

}
