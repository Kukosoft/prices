package com.kairosds.prices.application.service;

import com.kairosds.prices.application.repository.BrandRepository;
import com.kairosds.prices.domain.Brand;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BrandService {

	private final BrandRepository brandRepository;

	public Brand getBrand(Long id) {
		return brandRepository.findById(id);
	}

	public Brand saveBrand(Brand brand) {
		return brandRepository.save(brand);
	}

}
