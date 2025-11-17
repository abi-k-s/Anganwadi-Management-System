package com.anganwadi.service;

import java.util.List;

import com.anganwadi.model.PregnantWomen;

public interface PregnantWomanService {
	List<PregnantWomen> getAll();
    PregnantWomen getById(Long id);
    void save(PregnantWomen woman);
    void delete(Long id);
}
