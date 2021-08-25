package com.kairosds.prices.domain.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.kairosds.prices.domain.Price;

public interface PriceRepository {

	Price findById(Long id);

	List<Price> findByDateProductIdAndBrandId(LocalDateTime date, Long productId, Long brandId);

	Price save(Price price);

}
