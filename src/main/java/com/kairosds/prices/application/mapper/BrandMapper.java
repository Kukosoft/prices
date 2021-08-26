package com.kairosds.prices.application.mapper;

import org.mapstruct.Mapper;

import com.kairosds.prices.application.dto.BrandDto;
import com.kairosds.prices.domain.Brand;

@Mapper
public interface BrandMapper {

	BrandDto toDto(Brand brand);

	Brand toDomain(BrandDto brandDto);

}
