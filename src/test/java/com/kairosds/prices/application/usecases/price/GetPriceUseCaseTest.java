package com.kairosds.prices.application.usecases.price;

import static com.kairosds.prices.test.CommonTestUtils.createRandomPrice;
import static com.kairosds.prices.test.CommonTestUtils.priceDomainToDto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.kairosds.prices.application.InputParameters;
import com.kairosds.prices.application.dto.PriceDto;
import com.kairosds.prices.application.mapper.PriceMapper;
import com.kairosds.prices.domain.Price;
import com.kairosds.prices.domain.service.PriceService;

@ExtendWith(MockitoExtension.class)
public class GetPriceUseCaseTest {

	@Mock
	private PriceService priceService;

	@Mock
	private PriceMapper priceMapper;

	@InjectMocks
	private GetPriceUseCaseImpl getPriceUseCase;

	@Test
	void getPriceTest() {
		Price price = createRandomPrice();
		PriceDto expected = priceDomainToDto(price);
		when(priceService.getPrice(price.getStartDate(), price.getProductId(), price.getBrand().getId()))
				.thenReturn(price);
		when(priceMapper.toDto(price)).thenReturn(expected);
		PriceDto actual = getPriceUseCase
				.execute(new InputParameters(expected.getStartDate(), expected.getProductId(), expected.getBrandId()));
		assertEquals(expected, actual);
		verify(priceService).getPrice(expected.getStartDate(), expected.getProductId(), expected.getBrandId());
		verify(priceMapper).toDto(price);
	}

}
