package com.kairosds.prices.application.repository;

import com.kairosds.prices.domain.Brand;

public interface BrandRepository {

	Brand findById(Long id);

	Brand save(Brand brand);

}
