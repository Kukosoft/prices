package com.kairosds.prices.application;

import java.time.LocalDateTime;

import com.kairosds.prices.application.dto.PriceDto;

public interface PriceUseCases {

	PriceDto getPriceById(Long id);

	PriceDto getPrice(LocalDateTime date, Long productId, Long brandId);

	PriceDto savePrice(PriceDto priceDto);

}
