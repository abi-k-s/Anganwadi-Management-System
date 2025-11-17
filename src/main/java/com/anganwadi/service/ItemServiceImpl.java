package com.anganwadi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anganwadi.model.Item;
import com.anganwadi.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public Item getById(Long id) {
        //return itemRepository.findById(id).orElse(null);
        Optional<Item> optional= itemRepository.findById(id);
        Item item=null;
    	if(optional.isPresent()) {
    		item=optional.get();
    	}else {
    		throw new RuntimeException("Item not found for id : "+id);
    	}
        return item;
    }

    @Override
    public void save(Item item) {
        itemRepository.save(item);
    }

    @Override
    public void delete(Long id) {
        itemRepository.deleteById(id);
    }
}
