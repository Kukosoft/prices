package com.kairosds.prices.application.usecases.brand;

import static com.kairosds.prices.test.CommonTestUtils.brandDtoToDomain;
import static com.kairosds.prices.test.CommonTestUtils.createRandomBrandDto;
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
public class SaveBrandUseCaseTest {

	@Mock
	private BrandRepository brandRepository;

	private BrandService brandService;

	private BrandMapper brandMapper;

	private SaveBrandUseCase saveBrandUseCase;

	@BeforeEach
	public void setup() {
		brandService = spy(new BrandService(brandRepository));
		brandMapper = spy(new BrandMapperImpl());
		saveBrandUseCase = new SaveBrandUseCase(brandService, brandMapper);
	}

	@Test
	void saveBrandSuccessTest() {
		BrandDto expected = createRandomBrandDto();
		Brand brand = brandDtoToDomain(expected);
		when(brandRepository.save(brand)).thenReturn(brand);
		BrandDto actual = saveBrandUseCase.execute(expected);
		assertEquals(expected, actual);
		verify(brandMapper).toDomain(expected);
		verify(brandService).saveBrand(brand);
		verify(brandMapper).toDto(brand);
		verify(brandRepository).save(brand);
	}

}
