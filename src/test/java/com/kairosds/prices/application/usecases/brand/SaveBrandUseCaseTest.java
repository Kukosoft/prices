package com.kairosds.prices.application.usecases.brand;

import static com.kairosds.prices.test.CommonTestUtils.brandDtoToDomain;
import static com.kairosds.prices.test.CommonTestUtils.createRandomBrandDto;
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
public class SaveBrandUseCaseTest {

	@Mock
	private BrandService brandService;

	@Mock
	private BrandMapper brandMapper;

	@InjectMocks
	private SaveBrandUseCase saveBrandUseCase;

	@Test
	void saveBrandSuccessTest() {
		BrandDto expected = createRandomBrandDto();
		Brand brand = brandDtoToDomain(expected);
		when(brandMapper.toDomain(expected)).thenReturn(brand);
		when(brandService.saveBrand(brand)).thenReturn(brand);
		when(brandMapper.toDto(brand)).thenReturn(expected);
		BrandDto actual = saveBrandUseCase.execute(expected);
		assertEquals(expected, actual);
		verify(brandMapper).toDomain(expected);
		verify(brandService).saveBrand(brand);
		verify(brandMapper).toDto(brand);
	}

}
