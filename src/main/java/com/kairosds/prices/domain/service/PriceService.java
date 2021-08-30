package com.kairosds.prices.domain.service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import com.kairosds.prices.domain.Price;
import com.kairosds.prices.domain.repository.PriceRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PriceService {

	private final PriceRepository priceRepository;

	private final PricesPriorityComparator pricesPriorityComparator;

	public Price getPrice(Long id) {
		return priceRepository.findById(id);
	}

	public Price getPrice(LocalDateTime date, Long productId, Long brandId) {
		List<Price> prices = priceRepository.findByDateProductIdAndBrandId(date, productId, brandId);
		return Collections.max(prices, pricesPriorityComparator);
	}

	public Price savePrice(Price price) {
		return priceRepository.save(price);
	}

}
