package com.anganwadi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anganwadi.model.PregnantWomen;

@Repository
public interface PregnantWomanRepository extends JpaRepository<PregnantWomen, Long> {
}
