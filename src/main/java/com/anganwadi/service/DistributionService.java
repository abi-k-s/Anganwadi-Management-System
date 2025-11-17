package com.anganwadi.service;

import java.util.List;

import com.anganwadi.model.Distribution;

public interface DistributionService {
	List<Distribution> getAll();

	Distribution getById(Long id);

	void save(Distribution distribution);

	void delete(Long id);

	boolean isItemAlreadyDistributed(Long womanid,String month, String itemName,Integer year);
	 
}
