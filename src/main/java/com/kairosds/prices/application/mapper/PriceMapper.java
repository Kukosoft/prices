package com.kairosds.prices.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import com.kairosds.prices.application.dto.PriceDto;
import com.kairosds.prices.domain.Price;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PriceMapper {

	@Mappings({ @Mapping(target = "brandId", source = "price.brand.id") })
	PriceDto toDto(Price price);

	@Mappings({ @Mapping(target = "brand.id", source = "priceDto.brandId") })
	Price toDomain(PriceDto priceDto);

}
