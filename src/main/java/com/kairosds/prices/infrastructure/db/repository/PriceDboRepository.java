package com.kairosds.prices.infrastructure.db.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kairosds.prices.application.repository.PriceRepository;
import com.kairosds.prices.domain.Price;
import com.kairosds.prices.infrastructure.db.dbo.PriceEntity;
import com.kairosds.prices.infrastructure.db.mapper.PriceEntityMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PriceDboRepository implements PriceRepository {

	private final SpringDataPriceRepository priceRepository;

	private final PriceEntityMapper priceMapper;

	@Override
	public Price findById(Long id) {
		return priceMapper.toDomain(priceRepository.findById(id).orElseThrow());
	}

	@Override
	public List<Price> findByDateProductIdAndBrandId(LocalDateTime date, Long productId, Long brandId) {
		List<PriceEntity> prices = priceRepository.findByDateProductIdAndBrandId(date, productId, brandId);
		if (prices.isEmpty()) {
			throw new NoSuchElementException("No value present");
		}
		return prices.stream().map(p -> priceMapper.toDomain(p)).collect(Collectors.toList());
	}

	@Override
	public Price save(Price price) {
		return priceMapper.toDomain(priceRepository.save(priceMapper.toDbo(price)));
	}

}
