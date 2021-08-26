package com.kairosds.prices.domain.service;

import com.kairosds.prices.domain.Brand;
import com.kairosds.prices.domain.repository.BrandRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {

	private final BrandRepository brandRepository;

	@Override
	public Brand getBrand(Long id) {
		return brandRepository.findById(id);
	}

	@Override
	public Brand saveBrand(Brand brand) {
		return brandRepository.save(brand);
	}

}
