package com.kairosds.prices.domain.service;

import com.kairosds.prices.domain.Brand;
import com.kairosds.prices.domain.repository.BrandRepository;

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
