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

import com.kairosds.prices.application.dto.PriceDto;
import com.kairosds.prices.application.mapper.PriceMapper;
import com.kairosds.prices.domain.Price;
import com.kairosds.prices.domain.service.PriceService;

@ExtendWith(MockitoExtension.class)
public class GetPriceByIdUseCaseTest {

	@Mock
	private PriceService priceService;

	@Mock
	private PriceMapper priceMapper;

	@InjectMocks
	private GetPriceByIdUseCase getPriceByIdUseCase;

	@Test
	void getPriceByIdTest() {
		Price price = createRandomPrice();
		PriceDto expected = priceDomainToDto(price);
		when(priceService.getPrice(price.getId())).thenReturn(price);
		when(priceMapper.toDto(price)).thenReturn(expected);
		PriceDto actual = getPriceByIdUseCase.execute(price.getId());
		assertEquals(expected, actual);
		verify(priceService).getPrice(price.getId());
		verify(priceMapper).toDto(price);
	}

}
