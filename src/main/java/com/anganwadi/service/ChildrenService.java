package com.anganwadi.service;

import java.util.List;

import com.anganwadi.model.Children;

public interface ChildrenService {
	List<Children> getAllChildren();
    Children getChildById(Long id);
    void saveChild(Children children);
    void deleteChild(Long id);
	
}
