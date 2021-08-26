package com.kairosds.prices.domain.service;

import java.time.LocalDateTime;

import com.kairosds.prices.domain.Price;

public interface PriceService {

	Price getPrice(Long id);

	Price getPrice(LocalDateTime date, Long productId, Long brandId);

	Price savePrice(Price price);

}
