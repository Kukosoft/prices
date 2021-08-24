package com.kairosds.prices.infrastructure.db.mapper;

import org.mapstruct.Mapper;

import com.kairosds.prices.domain.Brand;
import com.kairosds.prices.infrastructure.db.dbo.BrandEntity;

@Mapper(componentModel = "spring")
public interface BrandEntityMapper {

	Brand toDomain(BrandEntity brandEntity);

	BrandEntity toDbo(Brand brand);

}
