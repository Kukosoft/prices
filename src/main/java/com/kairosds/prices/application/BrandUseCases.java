package com.kairosds.prices.application;

import com.kairosds.prices.application.dto.BrandDto;

public interface BrandUseCases {

	BrandDto getBrandById(Long id);

	BrandDto saveBrand(BrandDto brandDto);

}
