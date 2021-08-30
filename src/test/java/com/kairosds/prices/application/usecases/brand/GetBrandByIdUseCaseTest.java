package com.kairosds.prices.application.usecases.brand;

import static com.kairosds.prices.test.CommonTestUtils.brandDomainToDto;
import static com.kairosds.prices.test.CommonTestUtils.createRandomBrand;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.kairosds.prices.application.dto.BrandDto;
import com.kairosds.prices.application.mapper.BrandMapper;
import com.kairosds.prices.application.mapper.BrandMapperImpl;
import com.kairosds.prices.domain.Brand;
import com.kairosds.prices.domain.repository.BrandRepository;
import com.kairosds.prices.domain.service.BrandService;

@ExtendWith(MockitoExtension.class)
public class GetBrandByIdUseCaseTest {

	@Mock
	private BrandRepository brandRepository;

	private BrandService brandService;

	private BrandMapper brandMapper;

	private GetBrandByIdUseCase getBrandByIdUseCase;

	@BeforeEach
	public void setup() {
		brandService = spy(new BrandService(brandRepository));
		brandMapper = spy(new BrandMapperImpl());
		getBrandByIdUseCase = new GetBrandByIdUseCase(brandService, brandMapper);
	}

	@Test
	void getBrandByIdTest() {
		Brand brand = createRandomBrand();
		BrandDto expected = brandDomainToDto(brand);
		when(brandRepository.findById(brand.getId())).thenReturn(brand);
		BrandDto actual = getBrandByIdUseCase.execute(brand.getId());
		assertEquals(expected, actual);
		verify(brandService).getBrand(brand.getId());
		verify(brandMapper).toDto(brand);
		verify(brandRepository).findById(expected.getId());
	}

}
