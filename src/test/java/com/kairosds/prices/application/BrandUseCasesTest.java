package com.kairosds.prices.application;

import static com.kairosds.prices.test.CommonTestUtils.brandDomainToDto;
import static com.kairosds.prices.test.CommonTestUtils.brandDtoToDomain;
import static com.kairosds.prices.test.CommonTestUtils.createRandomBrand;
import static com.kairosds.prices.test.CommonTestUtils.createRandomBrandDto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.kairosds.prices.application.mapper.BrandMapper;
import com.kairosds.prices.domain.Brand;
import com.kairosds.prices.domain.service.BrandService;
import com.kairosds.prices.infrastructure.rest.dto.BrandDto;

@ExtendWith(MockitoExtension.class)
public class BrandUseCasesTest {

	@Mock
	private BrandService brandService;

	@Mock
	private BrandMapper brandMapper;

	@InjectMocks
	private BrandUseCasesImpl brandUseCases;

	@Test
	void getBrandByIdTest() {
		Brand brand = createRandomBrand();
		BrandDto expected = brandDomainToDto(brand);
		when(brandService.getBrand(brand.getId())).thenReturn(brand);
		when(brandMapper.toDto(brand)).thenReturn(expected);
		BrandDto actual = brandUseCases.getBrandById(brand.getId());
		assertEquals(expected, actual);
		verify(brandService).getBrand(brand.getId());
		verify(brandMapper).toDto(brand);
	}

	@Test
	void saveBrandSuccessTest() {
		BrandDto expected = createRandomBrandDto();
		Brand brand = brandDtoToDomain(expected);
		when(brandMapper.toDomain(expected)).thenReturn(brand);
		when(brandService.saveBrand(brand)).thenReturn(brand);
		when(brandMapper.toDto(brand)).thenReturn(expected);
		BrandDto actual = brandUseCases.saveBrand(expected);
		assertEquals(expected, actual);
		verify(brandMapper).toDomain(expected);
		verify(brandService).saveBrand(brand);
		verify(brandMapper).toDto(brand);
	}

}
