package com.kairosds.prices.infrastructure.db.dbo;

import java.time.LocalDateTime;
import java.util.Currency;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Table(name = "PRICES")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class PriceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@NonNull
	private Long id;

	@Column(nullable = false)
	@NonNull
	private LocalDateTime startDate;

	@Column(nullable = false)
	@NonNull
	private LocalDateTime endDate;

	@Column(nullable = false)
	@NonNull
	private Long priceList;

	@Column(nullable = false)
	@NonNull
	private Long productId;

	@Column(nullable = false)
	@NonNull
	private Integer priority;

	@Column(nullable = false)
	@NonNull
	private Float price;

	@Column(nullable = false)
	@NonNull
	private Currency curr;

	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@NonNull
	private BrandEntity brand;

}
