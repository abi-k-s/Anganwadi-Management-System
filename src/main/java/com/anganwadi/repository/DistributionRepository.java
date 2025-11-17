package com.anganwadi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anganwadi.model.Distribution;

@Repository
public interface DistributionRepository extends JpaRepository<Distribution, Long> {
	
	boolean existsByWomanIdAndMonthAndItem_ItemNameAndYear(Long womanId,String month,String itemName,Integer year);
}