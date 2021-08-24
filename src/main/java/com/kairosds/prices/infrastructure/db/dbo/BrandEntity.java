package com.kairosds.prices.infrastructure.db.dbo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Table(name = "BRANDS")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class BrandEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@NonNull
	private Long id;

	@NonNull
	private String name;

}
