package com.kairosds.prices.application.mapper;

import org.mapstruct.Mapper;

import com.kairosds.prices.domain.Brand;
import com.kairosds.prices.infrastructure.rest.dto.BrandDto;

@Mapper
public interface BrandMapper {

	BrandDto toDto(Brand brand);

	Brand toDomain(BrandDto brandDto);

}
