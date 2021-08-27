package com.kairosds.prices.application.usecases.brand;

import com.kairosds.prices.application.dto.BrandDto;
import com.kairosds.prices.application.mapper.BrandMapper;
import com.kairosds.prices.domain.service.BrandService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetBrandByIdUseCaseImpl implements GetBrandByIdUseCase {

	private final BrandService brandService;

	private final BrandMapper brandMapper;

	@Override
	public BrandDto execute(Long id) {
		return brandMapper.toDto(brandService.getBrand(id));
	}

}
