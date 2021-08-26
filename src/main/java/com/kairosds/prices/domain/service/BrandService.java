package com.kairosds.prices.domain.service;

import com.kairosds.prices.domain.Brand;

public interface BrandService {

	Brand getBrand(Long id);

	Brand saveBrand(Brand brand);

}
