package com.brasil.transparente.processor.repository;

import com.brasil.transparente.processor.entity.GastoTotal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GastoTotalRepository extends JpaRepository<GastoTotal, String> {
}
