package com.kairosds.prices.application;

import static com.kairosds.prices.test.CommonTestUtils.priceDomainToDto;
import static com.kairosds.prices.test.CommonTestUtils.priceDtoToDomain;
import static com.kairosds.prices.test.CommonTestUtils.createRandomPrice;
import static com.kairosds.prices.test.CommonTestUtils.createRandomPriceDto;
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
public class PriceUseCasesTest {

	@Mock
	private PriceService priceService;

	@Mock
	private PriceMapper priceMapper;

	@InjectMocks
	private PriceUseCasesImpl priceUseCases;

	@Test
	void getPriceByIdTest() {
		Price price = createRandomPrice();
		PriceDto expected = priceDomainToDto(price);
		when(priceService.getPrice(price.getId())).thenReturn(price);
		when(priceMapper.toDto(price)).thenReturn(expected);
		PriceDto actual = priceUseCases.getPriceById(price.getId());
		assertEquals(expected, actual);
		verify(priceService).getPrice(price.getId());
		verify(priceMapper).toDto(price);
	}

	@Test
	void savePriceSuccessTest() {
		PriceDto expected = createRandomPriceDto();
		Price price = priceDtoToDomain(expected);
		when(priceMapper.toDomain(expected)).thenReturn(price);
		when(priceService.savePrice(price)).thenReturn(price);
		when(priceMapper.toDto(price)).thenReturn(expected);
		PriceDto actual = priceUseCases.savePrice(expected);
		assertEquals(expected, actual);
		verify(priceMapper).toDomain(expected);
		verify(priceService).savePrice(price);
		verify(priceMapper).toDto(price);
	}

}
