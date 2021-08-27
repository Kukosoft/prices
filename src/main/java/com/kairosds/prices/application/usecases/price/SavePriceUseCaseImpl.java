package com.kairosds.prices.application.usecases.price;

import com.kairosds.prices.application.dto.PriceDto;
import com.kairosds.prices.application.mapper.PriceMapper;
import com.kairosds.prices.domain.service.PriceService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SavePriceUseCaseImpl implements SavePriceUseCase {

	private final PriceService priceService;

	private final PriceMapper priceMapper;

	@Override
	public PriceDto execute(PriceDto priceDto) {
		return priceMapper.toDto(priceService.savePrice(priceMapper.toDomain(priceDto)));
	}

}
