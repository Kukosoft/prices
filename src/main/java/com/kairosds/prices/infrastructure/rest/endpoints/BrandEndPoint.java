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

import com.kairosds.prices.domain.service.BrandService;
import com.kairosds.prices.infrastructure.rest.dto.BrandDto;
import com.kairosds.prices.infrastructure.rest.mapper.BrandMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/brands")
public class BrandEndPoint {

	private final BrandService brandService;

	private final BrandMapper brandMapper;

	@GetMapping("/brand/{id}")
	public ResponseEntity<BrandDto> getBrandById(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(brandMapper.toDto(brandService.getBrand(id)), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Brand not found", e);
		}
	}

	@PostMapping
	public ResponseEntity<BrandDto> saveBrand(@RequestBody BrandDto brandDto) {
		return new ResponseEntity<>(brandMapper.toDto(brandService.saveBrand(brandMapper.toDomain(brandDto))),
				HttpStatus.CREATED);
	}

}
