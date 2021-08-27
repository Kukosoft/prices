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

import com.kairosds.prices.application.dto.BrandDto;
import com.kairosds.prices.application.usecases.UseCase;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/brands")
public class BrandEndPoint {

	private final UseCase<Long, BrandDto> getBrandByIdUseCase;

	private final UseCase<BrandDto, BrandDto> saveBrandUseCase;

	@GetMapping("/brand/{id}")
	public ResponseEntity<BrandDto> getBrandById(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(getBrandByIdUseCase.execute(id), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Brand not found", e);
		}
	}

	@PostMapping
	public ResponseEntity<BrandDto> saveBrand(@RequestBody BrandDto brandDto) {
		return new ResponseEntity<>(saveBrandUseCase.execute(brandDto), HttpStatus.CREATED);
	}

}
