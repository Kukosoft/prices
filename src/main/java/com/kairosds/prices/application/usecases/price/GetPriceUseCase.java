package com.kairosds.prices.application.usecases.price;

import java.time.LocalDateTime;

import com.kairosds.prices.application.dto.PriceDto;

public interface GetPriceUseCase {

	PriceDto execute(LocalDateTime date, Long productId, Long brandId);

}
