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

import com.kairosds.prices.application.service.PriceService;
import com.kairosds.prices.infrastructure.rest.dto.PriceDto;
import com.kairosds.prices.infrastructure.rest.mapper.PriceMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/prices")
public class PriceEndPoint {

	private final PriceService priceService;

	private final PriceMapper priceMapper;

	@GetMapping("price/{id}")
	public ResponseEntity<PriceDto> getPriceById(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(priceMapper.toDto(priceService.getPrice(id)), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Price not found", e);
		}
	}

	@GetMapping("price")
	public ResponseEntity<PriceDto> getPrice(
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
			@RequestParam Long productId, @RequestParam Long brandId) {
		try {
			return new ResponseEntity<>(priceMapper.toDto(priceService.getPrice(date, productId, brandId)),
					HttpStatus.OK);
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Price not found", e);
		}
	}

	@PostMapping
	public ResponseEntity<PriceDto> savePrice(@RequestBody PriceDto priceDto) {
		return new ResponseEntity<>(priceMapper.toDto(priceService.savePrice(priceMapper.toDomain(priceDto))),
				HttpStatus.CREATED);
	}

}
