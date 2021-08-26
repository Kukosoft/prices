package com.kairosds.prices.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kairosds.prices.application.BrandUseCases;
import com.kairosds.prices.application.BrandUseCasesImpl;
import com.kairosds.prices.application.PriceUseCases;
import com.kairosds.prices.application.PriceUseCasesImpl;
import com.kairosds.prices.application.mapper.BrandMapper;
import com.kairosds.prices.application.mapper.BrandMapperImpl;
import com.kairosds.prices.application.mapper.PriceMapper;
import com.kairosds.prices.application.mapper.PriceMapperImpl;
import com.kairosds.prices.domain.repository.BrandRepository;
import com.kairosds.prices.domain.repository.PriceRepository;
import com.kairosds.prices.domain.service.BrandService;
import com.kairosds.prices.domain.service.BrandServiceImpl;
import com.kairosds.prices.domain.service.PriceService;
import com.kairosds.prices.domain.service.PriceServiceImpl;
import com.kairosds.prices.domain.service.PricesPriorityComparator;

@Configuration
public class SpringBootServiceConfig {

	@Bean
	public BrandService brandService(BrandRepository brandRepository) {
		return new BrandServiceImpl(brandRepository);
	}

	@Bean
	public PriceService priceService(PriceRepository priceRepository) {
		return new PriceServiceImpl(priceRepository, new PricesPriorityComparator());
	}

	@Bean
	public BrandUseCases brandUseCases(BrandService brandService, BrandMapper brandMapper) {
		return new BrandUseCasesImpl(brandService, brandMapper);
	}

	@Bean
	public PriceUseCases priceUseCases(PriceService priceService, PriceMapper priceMapper) {
		return new PriceUseCasesImpl(priceService, priceMapper);
	}

	@Bean
	public BrandMapper brandMapper() {
		return new BrandMapperImpl();
	}

	@Bean
	public PriceMapper priceMapper() {
		return new PriceMapperImpl();
	}

}