package com.kairosds.prices.application.usecases.brand;

import com.kairosds.prices.application.dto.BrandDto;

public interface SaveBrandUseCase {

	BrandDto execute(BrandDto brandDto);

}
