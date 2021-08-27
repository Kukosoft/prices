package com.kairosds.prices.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kairosds.prices.application.InputParameters;
import com.kairosds.prices.application.dto.BrandDto;
import com.kairosds.prices.application.dto.PriceDto;
import com.kairosds.prices.application.mapper.BrandMapper;
import com.kairosds.prices.application.mapper.BrandMapperImpl;
import com.kairosds.prices.application.mapper.PriceMapper;
import com.kairosds.prices.application.mapper.PriceMapperImpl;
import com.kairosds.prices.application.usecases.UseCase;
import com.kairosds.prices.application.usecases.brand.GetBrandByIdUseCase;
import com.kairosds.prices.application.usecases.brand.SaveBrandUseCase;
import com.kairosds.prices.application.usecases.price.GetPriceByIdUseCase;
import com.kairosds.prices.application.usecases.price.GetPriceUseCaseImpl;
import com.kairosds.prices.application.usecases.price.SavePriceUseCaseImpl;
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
	public UseCase<Long, BrandDto> getBrandByIdUseCase(BrandService brandService, BrandMapper brandMapper) {
		return new GetBrandByIdUseCase(brandService, brandMapper);
	}

	@Bean
	public UseCase<BrandDto, BrandDto> saveBrandUseCase(BrandService brandService, BrandMapper brandMapper) {
		return new SaveBrandUseCase(brandService, brandMapper);
	}

	@Bean
	public UseCase<Long, PriceDto> getPriceByIdUseCase(PriceService priceService, PriceMapper priceMapper) {
		return new GetPriceByIdUseCase(priceService, priceMapper);
	}

	@Bean
	public UseCase<InputParameters, PriceDto> getPriceUseCase(PriceService priceService, PriceMapper priceMapper) {
		return new GetPriceUseCaseImpl(priceService, priceMapper);
	}

	@Bean
	public UseCase<PriceDto, PriceDto> savePriceUseCase(PriceService priceService, PriceMapper priceMapper) {
		return new SavePriceUseCaseImpl(priceService, priceMapper);
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