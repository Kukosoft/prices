package com.kairosds.prices.application.dto;

import java.time.LocalDateTime;
import java.util.Currency;

import lombok.Data;

@Data
public class PriceDto {

	private Long productId;

	private Long brandId;

	private Long priceList;

	private LocalDateTime startDate;

	private LocalDateTime endDate;

	private Float price;

	private Currency curr;

}