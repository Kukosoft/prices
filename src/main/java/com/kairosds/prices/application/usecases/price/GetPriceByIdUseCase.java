package com.kairosds.prices.application.usecases.price;

import com.kairosds.prices.application.dto.PriceDto;
import com.kairosds.prices.application.mapper.PriceMapper;
import com.kairosds.prices.application.usecases.UseCase;
import com.kairosds.prices.domain.service.PriceService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetPriceByIdUseCase implements UseCase<Long, PriceDto> {

	private final PriceService priceService;

	private final PriceMapper priceMapper;

	@Override
	public PriceDto execute(Long id) {
		return priceMapper.toDto(priceService.getPrice(id));
	}

}
