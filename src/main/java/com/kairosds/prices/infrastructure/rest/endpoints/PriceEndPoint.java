package com.kairosds.prices.infrastructure.rest.endpoints;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.kairosds.prices.application.InputParameters;
import com.kairosds.prices.application.dto.PriceDto;
import com.kairosds.prices.application.usecases.UseCase;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/prices")
public class PriceEndPoint {

	private final UseCase<Long, PriceDto> getPriceByIdUseCase;

	private final UseCase<InputParameters, PriceDto> getPriceUseCase;

	private final UseCase<PriceDto, PriceDto> savePriceUseCase;

	@GetMapping("price/{id}")
	public ResponseEntity<PriceDto> getPriceById(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(getPriceByIdUseCase.execute(id), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Price not found", e);
		}
	}

	@GetMapping("price")
	public ResponseEntity<PriceDto> getPrice(
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
			@RequestParam Long productId, @RequestParam Long brandId) {
		try {
			return new ResponseEntity<>(getPriceUseCase.execute(new InputParameters(date, productId, brandId)),
					HttpStatus.OK);
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Price not found", e);
		}
	}

	@PostMapping
	public ResponseEntity<PriceDto> savePrice(@RequestBody PriceDto priceDto) {
		return new ResponseEntity<>(savePriceUseCase.execute(priceDto), HttpStatus.CREATED);
	}

}
