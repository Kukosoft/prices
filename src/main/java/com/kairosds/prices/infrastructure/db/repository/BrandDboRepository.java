package com.kairosds.prices.infrastructure.db.repository;

import org.springframework.stereotype.Service;

import com.kairosds.prices.domain.Brand;
import com.kairosds.prices.domain.repository.BrandRepository;
import com.kairosds.prices.infrastructure.db.mapper.BrandEntityMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BrandDboRepository implements BrandRepository {

	private final SpringDataBrandRepository brandRepository;

	private final BrandEntityMapper brandMapper;

	@Override
	public Brand findById(Long id) {
		return brandMapper.toDomain(brandRepository.findById(id).orElseThrow());
	}

	@Override
	public Brand save(Brand brand) {
		return brandMapper.toDomain(brandRepository.save(brandMapper.toDbo(brand)));
	}

}
