package com.kairosds.prices.application.usecases.brand;

import static com.kairosds.prices.test.CommonTestUtils.brandDomainToDto;
import static com.kairosds.prices.test.CommonTestUtils.createRandomBrand;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.kairosds.prices.application.dto.BrandDto;
import com.kairosds.prices.application.mapper.BrandMapper;
import com.kairosds.prices.domain.Brand;
import com.kairosds.prices.domain.service.BrandService;

@ExtendWith(MockitoExtension.class)
public class GetBrandByIdUseCaseTest {

	@Mock
	private BrandService brandService;

	@Mock
	private BrandMapper brandMapper;

	@InjectMocks
	private GetBrandByIdUseCaseImpl getByIdUseCase;

	@Test
	void getBrandByIdTest() {
		Brand brand = createRandomBrand();
		BrandDto expected = brandDomainToDto(brand);
		when(brandService.getBrand(brand.getId())).thenReturn(brand);
		when(brandMapper.toDto(brand)).thenReturn(expected);
		BrandDto actual = getByIdUseCase.execute(brand.getId());
		assertEquals(expected, actual);
		verify(brandService).getBrand(brand.getId());
		verify(brandMapper).toDto(brand);
	}

}
