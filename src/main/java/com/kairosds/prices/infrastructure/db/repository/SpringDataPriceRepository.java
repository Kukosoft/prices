package com.kairosds.prices.infrastructure.db.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kairosds.prices.infrastructure.db.dbo.PriceEntity;

@Repository
public interface SpringDataPriceRepository extends JpaRepository<PriceEntity, Long> {

	@Query("SELECT p FROM PriceEntity p WHERE p.productId = :productId AND p.brand.id = :brandId AND :date BETWEEN p.startDate AND p.endDate")
	List<PriceEntity> findByDateProductIdAndBrandId(@Param("date") LocalDateTime date,
			@Param("productId") Long productId, @Param("brandId") Long brandId);

}
