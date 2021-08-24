package com.kairosds.prices.infrastructure.rest.mapper;

import org.mapstruct.Mapper;

import com.kairosds.prices.domain.Brand;
import com.kairosds.prices.infrastructure.rest.dto.BrandDto;

@Mapper(componentModel = "spring")
public interface BrandMapper {

	BrandDto toDto(Brand user);

	Brand toDomain(BrandDto userDto);

}
