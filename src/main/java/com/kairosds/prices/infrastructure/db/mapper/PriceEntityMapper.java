package com.kairosds.prices.infrastructure.db.mapper;

import org.mapstruct.Mapper;

import com.kairosds.prices.domain.Price;
import com.kairosds.prices.infrastructure.db.dbo.PriceEntity;

@Mapper(componentModel = "spring")
public interface PriceEntityMapper {

	Price toDomain(PriceEntity priceEntity);

	PriceEntity toDbo(Price price);

}
