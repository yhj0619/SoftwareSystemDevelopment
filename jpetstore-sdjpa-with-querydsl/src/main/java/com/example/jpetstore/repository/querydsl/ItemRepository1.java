package com.example.jpetstore.repository.querydsl;

//import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.example.jpetstore.domain.Item;

import java.util.List;

public interface ItemRepository1
        extends JpaRepository<Item, String>, 
        		QuerydslPredicateExecutor<Item> {
	
}
