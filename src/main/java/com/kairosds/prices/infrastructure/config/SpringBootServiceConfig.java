package com.kairosds.prices.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kairosds.prices.application.mapper.BrandMapper;
import com.kairosds.prices.application.mapper.BrandMapperImpl;
import com.kairosds.prices.application.mapper.PriceMapper;
import com.kairosds.prices.application.mapper.PriceMapperImpl;
import com.kairosds.prices.application.usecases.brand.GetBrandByIdUseCase;
import com.kairosds.prices.application.usecases.brand.SaveBrandUseCase;
import com.kairosds.prices.application.usecases.price.GetPriceByIdUseCase;
import com.kairosds.prices.application.usecases.price.GetPriceUseCase;
import com.kairosds.prices.application.usecases.price.SavePriceUseCase;
import com.kairosds.prices.domain.repository.BrandRepository;
import com.kairosds.prices.domain.repository.PriceRepository;
import com.kairosds.prices.domain.service.BrandService;
import com.kairosds.prices.domain.service.PriceService;
import com.kairosds.prices.domain.service.PricesPriorityComparator;

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

	@Bean
	public GetBrandByIdUseCase getBrandByIdUseCase(BrandService brandService, BrandMapper brandMapper) {
		return new GetBrandByIdUseCase(brandService, brandMapper);
	}

	@Bean
	public SaveBrandUseCase saveBrandUseCase(BrandService brandService, BrandMapper brandMapper) {
		return new SaveBrandUseCase(brandService, brandMapper);
	}

	@Bean
	public GetPriceByIdUseCase getPriceByIdUseCase(PriceService priceService, PriceMapper priceMapper) {
		return new GetPriceByIdUseCase(priceService, priceMapper);
	}

	@Bean
	public GetPriceUseCase getPriceUseCase(PriceService priceService, PriceMapper priceMapper) {
		return new GetPriceUseCase(priceService, priceMapper);
	}

	@Bean
	public SavePriceUseCase savePriceUseCase(PriceService priceService, PriceMapper priceMapper) {
		return new SavePriceUseCase(priceService, priceMapper);
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