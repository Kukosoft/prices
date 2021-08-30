package com.kairosds.prices.test;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import java.time.LocalDateTime;
import java.util.Currency;
import java.util.List;
import java.util.Random;

import org.apache.commons.math3.random.RandomDataGenerator;

import com.kairosds.prices.application.dto.BrandDto;
import com.kairosds.prices.application.dto.PriceDto;
import com.kairosds.prices.domain.Brand;
import com.kairosds.prices.domain.Price;

public class CommonTestUtils {

	private static RandomDataGenerator randomDataGenerator;

	static {
		randomDataGenerator = new RandomDataGenerator();
	}

	public static Brand createRandomBrand() {
		Brand brand = new Brand();
		brand.setId(randomDataGenerator.nextLong(1, 100));
		brand.setName(randomAlphabetic(20));
		return brand;
	}

	public static BrandDto createRandomBrandDto() {
		BrandDto brandDto = new BrandDto();
		brandDto.setId(randomDataGenerator.nextLong(1, 100));
		brandDto.setName(randomAlphabetic(20));
		return brandDto;
	}

	public static Price createRandomPrice() {
		Price price = new Price();
		price.setId(randomDataGenerator.nextLong(1, 100));
		price.setStartDate(LocalDateTime.of(2021, 8, 25, 12, 0));
		price.setEndDate(LocalDateTime.of(2021, 8, 26, 18, 30));
		price.setPriceList(randomDataGenerator.nextLong(1, 100));
		price.setProductId(randomDataGenerator.nextLong(1, 100));
		price.setPriority(randomDataGenerator.nextInt(1, 10));
		price.setPrice(nextFloat(1, 100));
		price.setCurr(nextCurrency());
		price.setBrand(createRandomBrand());
		return price;
	}

	public static PriceDto createRandomPriceDto() {
		PriceDto priceDto = new PriceDto();
		priceDto.setProductId(randomDataGenerator.nextLong(1, 100));
		priceDto.setBrandId(randomDataGenerator.nextLong(1, 100));
		priceDto.setPriceList(randomDataGenerator.nextLong(1, 100));
		priceDto.setStartDate(LocalDateTime.of(2021, 8, 25, 12, 0));
		priceDto.setEndDate(LocalDateTime.of(2021, 8, 26, 18, 30));
		priceDto.setPrice(nextFloat(1, 100));
		priceDto.setCurr(nextCurrency());
		return priceDto;
	}

	public static Brand brandDtoToDomain(BrandDto brandDto) {
		Brand brand = new Brand();
		brand.setId(brandDto.getId());
		brand.setName(brandDto.getName());
		return brand;
	}

	public static BrandDto brandDomainToDto(Brand brand) {
		BrandDto brandDto = new BrandDto();
		brandDto.setId(brand.getId());
		brandDto.setName(brand.getName());
		return brandDto;
	}

	public static Price priceDtoToDomain(PriceDto priceDto) {
		Price price = new Price();
		price.setStartDate(priceDto.getStartDate());
		price.setEndDate(priceDto.getEndDate());
		price.setPriceList(priceDto.getPriceList());
		price.setProductId(priceDto.getProductId());
		price.setPrice(priceDto.getPrice());
		price.setCurr(priceDto.getCurr());

		Brand brand = new Brand();
		brand.setId(priceDto.getBrandId());

		price.setBrand(brand);
		return price;
	}

	public static PriceDto priceDomainToDto(Price price) {
		PriceDto priceDto = new PriceDto();
		priceDto.setProductId(price.getProductId());
		priceDto.setBrandId(price.getBrand().getId());
		priceDto.setPriceList(price.getPriceList());
		priceDto.setStartDate(price.getStartDate());
		priceDto.setEndDate(price.getEndDate());
		priceDto.setPrice(price.getPrice());
		priceDto.setCurr(price.getCurr());
		return priceDto;
	}

	private static float nextFloat(float lower, float upper) {
		float randomFloat = randomDataGenerator.getRandomGenerator().nextFloat();
		return lower + randomFloat * (upper - lower);
	}

	private static Currency nextCurrency() {
		List<Currency> currencies = List.copyOf(Currency.getAvailableCurrencies());
		Random rand = new Random();
		return currencies.get(rand.nextInt(currencies.size()));
	}

}
