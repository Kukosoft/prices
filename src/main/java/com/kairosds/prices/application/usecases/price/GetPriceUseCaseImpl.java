package com.kairosds.prices.application.usecases.price;

import java.time.LocalDateTime;

import com.kairosds.prices.application.dto.PriceDto;
import com.kairosds.prices.application.mapper.PriceMapper;
import com.kairosds.prices.domain.service.PriceService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetPriceUseCaseImpl implements GetPriceUseCase {

	private final PriceService priceService;

	private final PriceMapper priceMapper;

	@Override
	public PriceDto execute(LocalDateTime date, Long productId, Long brandId) {
		return priceMapper.toDto(priceService.getPrice(date, productId, brandId));
	}

}
