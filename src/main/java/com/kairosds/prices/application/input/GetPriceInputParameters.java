package com.kairosds.prices.application.input;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetPriceInputParameters {

	private LocalDateTime date;
	private Long productId;
	private Long brandId;

}
