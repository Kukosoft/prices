package com.kairosds.prices.infrastructure.rest.endpoints;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.kairosds.prices.application.BrandUseCases;
import com.kairosds.prices.infrastructure.rest.dto.BrandDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/brands")
public class BrandEndPoint {

	private final BrandUseCases brandUseCases;

	@GetMapping("/brand/{id}")
	public ResponseEntity<BrandDto> getBrandById(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(brandUseCases.getBrandById(id), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Brand not found", e);
		}
	}

	@PostMapping
	public ResponseEntity<BrandDto> saveBrand(@RequestBody BrandDto brandDto) {
		return new ResponseEntity<>(brandUseCases.saveBrand(brandDto), HttpStatus.CREATED);
	}

}
