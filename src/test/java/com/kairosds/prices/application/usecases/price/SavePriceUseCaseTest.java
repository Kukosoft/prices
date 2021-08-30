package com.kairosds.prices.application.usecases.price;

import static com.kairosds.prices.test.CommonTestUtils.createRandomPriceDto;
import static com.kairosds.prices.test.CommonTestUtils.priceDtoToDomain;
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
public class SavePriceUseCaseTest {

	@Mock
	private PriceRepository priceRepository;

	private PricesPriorityComparator pricesPriorityComparator;

	private PriceService priceService;

	private PriceMapper priceMapper;

	private SavePriceUseCase savePriceUseCase;

	@BeforeEach
	public void setup() {
		pricesPriorityComparator = spy(new PricesPriorityComparator());
		priceService = spy(new PriceService(priceRepository, pricesPriorityComparator));
		priceMapper = spy(new PriceMapperImpl());
		savePriceUseCase = new SavePriceUseCase(priceService, priceMapper);
	}

	@Test
	void savePriceSuccessTest() {
		PriceDto expected = createRandomPriceDto();
		Price price = priceDtoToDomain(expected);
		when(priceRepository.save(price)).thenReturn(price);
		PriceDto actual = savePriceUseCase.execute(expected);
		assertEquals(expected, actual);
		verify(priceMapper).toDomain(expected);
		verify(priceService).savePrice(price);
		verify(priceMapper).toDto(price);
		verify(priceRepository).save(price);
	}

}
