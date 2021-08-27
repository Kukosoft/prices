package com.kairosds.prices.application.usecases.price;

import com.kairosds.prices.application.dto.PriceDto;
import com.kairosds.prices.application.mapper.PriceMapper;
import com.kairosds.prices.domain.service.PriceService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetPriceByIdUseCaseImpl implements GetPriceByIdUseCase {

	private final PriceService priceService;

	private final PriceMapper priceMapper;

	@Override
	public PriceDto execute(Long id) {
		return priceMapper.toDto(priceService.getPrice(id));
	}

}
