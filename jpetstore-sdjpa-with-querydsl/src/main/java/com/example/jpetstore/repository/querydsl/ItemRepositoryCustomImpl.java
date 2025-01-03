package com.example.jpetstore.repository.querydsl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.jpetstore.domain.Item;
import com.example.jpetstore.domain.QItem;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class ItemRepositoryCustomImpl implements ItemRepositoryCustom {
	
	@Autowired
	JPAQueryFactory jpaQueryFactory;

	@Override
	public List<Item> findFemaleItemsWithPriceInRange(int minVal, int maxVal) {
		QItem qItem = QItem.item;

		List<Item> itemList = jpaQueryFactory.selectFrom(qItem)
				.where(qItem.attribute1.containsIgnoreCase("female")
						.and(qItem.listPrice.between(minVal, maxVal)))
				.orderBy(qItem.listPrice.asc())
				.fetch();

		return itemList;
	}
	
	@Override
	public List<Item> search(List<String> keywords) {		
		List<Item> itemList = null;		
		// ...
		
		return itemList;
	}

}
