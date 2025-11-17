package com.anganwadi.service;

import java.util.List;

import com.anganwadi.model.Item;

public interface ItemService {
	List<Item> getAll();

	Item getById(Long id);

	void save(Item item);

	void delete(Long id);
}
