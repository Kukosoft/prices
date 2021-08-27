package com.kairosds.prices.application.usecases.price;

import com.kairosds.prices.application.dto.PriceDto;

public interface GetPriceByIdUseCase {

	PriceDto execute(Long id);

}
