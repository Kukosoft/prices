package com.kairosds.prices.application;

import com.kairosds.prices.application.dto.BrandDto;
import com.kairosds.prices.application.mapper.BrandMapper;
import com.kairosds.prices.domain.service.BrandService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BrandUseCasesImpl implements BrandUseCases {

	private final BrandService brandService;

	private final BrandMapper brandMapper;

	public BrandDto getBrandById(Long id) {
		return brandMapper.toDto(brandService.getBrand(id));
	}

	public BrandDto saveBrand(BrandDto brandDto) {
		return brandMapper.toDto(brandService.saveBrand(brandMapper.toDomain(brandDto)));
	}

}
