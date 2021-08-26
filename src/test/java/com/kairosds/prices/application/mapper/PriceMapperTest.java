package com.kairosds.prices.application.mapper;

import static com.kairosds.prices.test.CommonTestUtils.createRandomPrice;
import static com.kairosds.prices.test.CommonTestUtils.createRandomPriceDto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.kairosds.prices.application.dto.PriceDto;
import com.kairosds.prices.domain.Price;

public class PriceMapperTest {

	private PriceMapper priceMapper;

	@BeforeEach
	void init() {
		priceMapper = new PriceMapperImpl();
	}

	@Test
	void domainToDtoTest() {
		Price price = createRandomPrice();
		PriceDto priceDto = priceMapper.toDto(price);
		assertEquals(priceDto.getProductId(), price.getProductId());
		assertEquals(priceDto.getBrandId(), price.getBrand().getId());
		assertEquals(priceDto.getPriceList(), price.getPriceList());
		assertEquals(priceDto.getStartDate(), price.getStartDate());
		assertEquals(priceDto.getEndDate(), price.getEndDate());
		assertEquals(priceDto.getPrice(), price.getPrice());
		assertEquals(priceDto.getCurr(), price.getCurr());
	}

	@Test
	void domainToDtoNullPriceTest() {
		PriceDto priceDto = priceMapper.toDto(null);
		assertNull(priceDto);
	}

	@Test
	void dtoToDomainTest() {
		PriceDto priceDto = createRandomPriceDto();
		Price price = priceMapper.toDomain(priceDto);
		assertEquals(price.getProductId(), priceDto.getProductId());
		assertEquals(price.getBrand().getId(), priceDto.getBrandId());
		assertEquals(price.getPriceList(), priceDto.getPriceList());
		assertEquals(price.getStartDate(), priceDto.getStartDate());
		assertEquals(price.getEndDate(), priceDto.getEndDate());
		assertEquals(price.getPrice(), priceDto.getPrice());
		assertEquals(price.getCurr(), priceDto.getCurr());
	}

	@Test
	void dtoToDomainNullPriceDtoTest() {
		Price price = priceMapper.toDomain(null);
		assertNull(price);
	}

}
