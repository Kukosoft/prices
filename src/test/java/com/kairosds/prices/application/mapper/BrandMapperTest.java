package com.kairosds.prices.application.mapper;

import static com.kairosds.prices.test.CommonTestUtils.createRandomBrand;
import static com.kairosds.prices.test.CommonTestUtils.createRandomBrandDto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.kairosds.prices.application.dto.BrandDto;
import com.kairosds.prices.domain.Brand;

public class BrandMapperTest {

	private BrandMapper brandMapper;

	@BeforeEach
	void init() {
		brandMapper = new BrandMapperImpl();
	}

	@Test
	void domainToDtoTest() {
		Brand brand = createRandomBrand();
		BrandDto brandDto = brandMapper.toDto(brand);
		assertEquals(brandDto.getId(), brand.getId());
		assertEquals(brandDto.getName(), brand.getName());
	}

	@Test
	void domainToDtoNullBrandTest() {
		BrandDto brandDto = brandMapper.toDto(null);
		assertNull(brandDto);
	}

	@Test
	void dtoToDomainTest() {
		BrandDto brandDto = createRandomBrandDto();
		Brand brand = brandMapper.toDomain(brandDto);
		assertEquals(brand.getId(), brandDto.getId());
		assertEquals(brand.getName(), brandDto.getName());
	}

	@Test
	void dtoToDomainNullBrandDtoTest() {
		Brand brand = brandMapper.toDomain(null);
		assertNull(brand);
	}

}
