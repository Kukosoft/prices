package com.kairosds.prices.infrastructure.config.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kairosds.prices.application.repository.BrandRepository;
import com.kairosds.prices.application.repository.PriceRepository;
import com.kairosds.prices.application.service.BrandService;
import com.kairosds.prices.application.service.PriceService;
import com.kairosds.prices.application.service.PricesPriorityComparator;

@Configuration
public class SpringBootServiceConfig {

	@Bean
	public BrandService brandService(BrandRepository brandRepository) {
		return new BrandService(brandRepository);
	}

	@Bean
	public PriceService priceService(PriceRepository priceRepository) {
		return new PriceService(priceRepository, new PricesPriorityComparator());
	}

}