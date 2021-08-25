package com.kairos.prices.domain.service;

import static com.kairos.prices.test.CommonTestUtils.createRandomBrand;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.kairosds.prices.domain.Brand;
import com.kairosds.prices.domain.repository.BrandRepository;
import com.kairosds.prices.domain.service.BrandService;

@ExtendWith(MockitoExtension.class)
class BrandServiceTest {

	@Mock
	private BrandRepository brandRepository;

	@InjectMocks
	private BrandService brandService;

	@Test
	void getBrandByIdFoundTest() {
		Brand expected = createRandomBrand();
		when(brandRepository.findById(expected.getId())).thenReturn(expected);
		Brand actual = brandService.getBrand(expected.getId());
		assertEquals(expected, actual);
		verify(brandRepository).findById(expected.getId());
	}

	@Test
	void getBrandByIdNotFoundTest() {
		Brand expected = createRandomBrand();
		when(brandRepository.findById(expected.getId())).thenThrow(NoSuchElementException.class);
		assertThrows(NoSuchElementException.class, () -> {
			brandService.getBrand(expected.getId());
		});
	}

	@Test
	void saveBrandSuccessTest() {
		Brand expected = createRandomBrand();
		when(brandRepository.save(expected)).thenReturn(expected);
		Brand actual = brandService.saveBrand(expected);
		assertEquals(expected, actual);
		verify(brandRepository).save(expected);
	}

}
