package com.kairosds.prices.application.usecases.brand;

import com.kairosds.prices.application.dto.BrandDto;
import com.kairosds.prices.application.mapper.BrandMapper;
import com.kairosds.prices.domain.service.BrandService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SaveBrandUseCaseImpl implements SaveBrandUseCase {

	private final BrandService brandService;

	private final BrandMapper brandMapper;

	@Override
	public BrandDto execute(BrandDto brandDto) {
		return brandMapper.toDto(brandService.saveBrand(brandMapper.toDomain(brandDto)));
	}

}
