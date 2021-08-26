package com.kairosds.prices.test;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import java.time.LocalDateTime;
import java.util.Currency;
import java.util.List;
import java.util.Random;

import org.apache.commons.math3.random.RandomDataGenerator;

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
