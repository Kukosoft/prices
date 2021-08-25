package com.kairos.prices.domain.service;

import static com.kairos.prices.test.CommonTestUtils.createRandomPrice;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.kairosds.prices.domain.Price;
import com.kairosds.prices.domain.repository.PriceRepository;
import com.kairosds.prices.domain.service.PriceService;
import com.kairosds.prices.domain.service.PricesPriorityComparator;

@ExtendWith(MockitoExtension.class)
class PriceServiceTest {

	@Mock
	private PriceRepository priceRepository;
	@Spy
	private PricesPriorityComparator pricesPriorityComparator;

	@InjectMocks
	private PriceService priceService;

	@Test
	void getPriceByIdFoundTest() {
		Price expected = createRandomPrice();
		when(priceRepository.findById(expected.getId())).thenReturn(expected);
		Price actual = priceService.getPrice(expected.getId());
		assertEquals(expected, actual);
		verify(priceRepository).findById(expected.getId());
	}

	@Test
	void getPriceByIdNotFoundTest() {
		Price expected = createRandomPrice();
		when(priceRepository.findById(expected.getId())).thenThrow(NoSuchElementException.class);
		assertThrows(NoSuchElementException.class, () -> {
			priceService.getPrice(expected.getId());
		});
	}

	@Test
	void getPriceByDateProductIdAndBrandIdOneFoundTest() {
		Price expected = createRandomPrice();
		when(priceRepository.findByDateProductIdAndBrandId(LocalDateTime.of(2021, 8, 25, 18, 0),
				expected.getProductId(), expected.getBrand().getId())).thenReturn(Collections.singletonList(expected));
		Price actual = priceService.getPrice(LocalDateTime.of(2021, 8, 25, 18, 0), expected.getProductId(),
				expected.getBrand().getId());
		assertEquals(expected, actual);
		verify(priceRepository).findByDateProductIdAndBrandId(LocalDateTime.of(2021, 8, 25, 18, 0),
				expected.getProductId(), expected.getBrand().getId());
	}

	@Test
	void getPriceByDateProductIdAndBrandIdMultipleFoundTest() {
		Price price1 = createRandomPrice();
		price1.setPriority(1);
		Price price2 = createRandomPrice();
		price2.setPriority(2);
		Price expected = createRandomPrice();
		expected.setPriority(3);

		when(priceRepository.findByDateProductIdAndBrandId(LocalDateTime.of(2021, 8, 25, 18, 0),
				expected.getProductId(), expected.getBrand().getId())).thenReturn(List.of(price1, price2, expected));
		Price actual = priceService.getPrice(LocalDateTime.of(2021, 8, 25, 18, 0), expected.getProductId(),
				expected.getBrand().getId());
		assertEquals(expected, actual);
		verify(priceRepository).findByDateProductIdAndBrandId(LocalDateTime.of(2021, 8, 25, 18, 0),
				expected.getProductId(), expected.getBrand().getId());
	}

	@Test
	void getPriceByDateProductIdAndBrandIdNotFoundTest() {
		Price expected = createRandomPrice();
		when(priceRepository.findByDateProductIdAndBrandId(LocalDateTime.of(2021, 8, 25, 18, 0),
				expected.getProductId(), expected.getBrand().getId())).thenThrow(NoSuchElementException.class);
		assertThrows(NoSuchElementException.class, () -> {
			priceService.getPrice(LocalDateTime.of(2021, 8, 25, 18, 0), expected.getProductId(),
					expected.getBrand().getId());
		});
	}

	@Test
	void savePriceSuccessTest() {
		Price expected = createRandomPrice();
		when(priceRepository.save(expected)).thenReturn(expected);
		Price actual = priceService.savePrice(expected);
		assertEquals(expected, actual);
		verify(priceRepository).save(expected);
	}

}
