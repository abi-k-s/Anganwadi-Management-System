package com.anganwadi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anganwadi.model.Children;
@Repository
public interface ChildrenRepository  extends JpaRepository<Children, Long>  {

}
