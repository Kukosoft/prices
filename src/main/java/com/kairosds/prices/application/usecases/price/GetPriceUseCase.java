package com.kairosds.prices.application.usecases.price;

import com.kairosds.prices.application.dto.PriceDto;
import com.kairosds.prices.application.input.GetPriceInputParameters;
import com.kairosds.prices.application.mapper.PriceMapper;
import com.kairosds.prices.application.usecases.UseCase;
import com.kairosds.prices.domain.service.PriceService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetPriceUseCase implements UseCase<GetPriceInputParameters, PriceDto> {

	private final PriceService priceService;

	private final PriceMapper priceMapper;

	@Override
	public PriceDto execute(GetPriceInputParameters inputParameters) {
		return priceMapper.toDto(priceService.getPrice(inputParameters.getDate(), inputParameters.getProductId(),
				inputParameters.getBrandId()));
	}

}
