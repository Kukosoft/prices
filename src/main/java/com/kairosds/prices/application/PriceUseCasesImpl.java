package com.kairosds.prices.application;

import java.time.LocalDateTime;

import com.kairosds.prices.application.mapper.PriceMapper;
import com.kairosds.prices.domain.service.PriceService;
import com.kairosds.prices.infrastructure.rest.dto.PriceDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PriceUseCasesImpl implements PriceUseCases{

	private final PriceService priceService;

	private final PriceMapper priceMapper;

	public PriceDto getPriceById(Long id) {
		return priceMapper.toDto(priceService.getPrice(id));
	}

	public PriceDto getPrice(LocalDateTime date, Long productId, Long brandId) {
		return priceMapper.toDto(priceService.getPrice(date, productId, brandId));
	}

	public PriceDto savePrice(PriceDto priceDto) {
		return priceMapper.toDto(priceService.savePrice(priceMapper.toDomain(priceDto)));
	}

}
