package com.kairosds.prices.domain;

import java.time.LocalDateTime;
import java.util.Currency;

import lombok.Data;

@Data
public class Price {

	private Long id;

	private LocalDateTime startDate;

	private LocalDateTime endDate;

	private Long priceList;

	private Long productId;

	private Integer priority;

	private Float price;

	private Currency curr;

	private Brand brand;

}
