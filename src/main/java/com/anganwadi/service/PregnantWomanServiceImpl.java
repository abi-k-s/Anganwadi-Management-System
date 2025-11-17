package com.anganwadi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anganwadi.model.PregnantWomen;
import com.anganwadi.repository.PregnantWomanRepository;

@Service
public class PregnantWomanServiceImpl implements PregnantWomanService {

	@Autowired
	private PregnantWomanRepository womanRepository;

	@Override
	public List<PregnantWomen> getAll() {
		return womanRepository.findAll();
	}

	@Override
	public PregnantWomen getById(Long id) {
		// return womanRepository.findById(id).orElse(null);
		Optional<PregnantWomen> optional = womanRepository.findById(id);
		PregnantWomen pregnantWomen = null;
		if (optional.isPresent()) {
			pregnantWomen = optional.get();
		} else {
			throw new RuntimeException("Woman not found for id : " + id);
		}
		return pregnantWomen;
	}

	@Override
	public void save(PregnantWomen woman) {
		womanRepository.save(woman);
	}

	@Override
	public void delete(Long id) {
		womanRepository.deleteById(id);
	}
}
