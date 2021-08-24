package com.kairosds.prices.infrastructure.db.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kairosds.prices.infrastructure.db.dbo.BrandEntity;

@Repository
public interface SpringDataBrandRepository extends JpaRepository<BrandEntity, Long> {

}
