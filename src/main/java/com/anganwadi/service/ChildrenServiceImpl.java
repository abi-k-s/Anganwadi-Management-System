package com.anganwadi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anganwadi.model.Children;
import com.anganwadi.repository.ChildrenRepository;
@Service
public class ChildrenServiceImpl implements ChildrenService {

    @Autowired
    private ChildrenRepository childrenRepository;

    @Override
    public List<Children> getAllChildren() {
        return childrenRepository.findAll();
    }

    @Override
    public void saveChild(Children child) {
        childrenRepository.save(child);
    }
    
    @Override
    public Children getChildById(Long id) {
    	Optional<Children> optional= childrenRepository.findById(id);
    	Children children=null;
    	if(optional.isPresent()) {
    		children=optional.get();
    	}else {
    		throw new RuntimeException("Child not found for id : "+id);
    	}
        return children;
    }


    @Override
    public void deleteChild(Long id) {
        childrenRepository.deleteById(id);
    }
}