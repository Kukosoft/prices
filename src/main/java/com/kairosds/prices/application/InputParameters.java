package com.kairosds.prices.application;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InputParameters {

	private LocalDateTime date;
	private Long productId;
	private Long brandId;

}
