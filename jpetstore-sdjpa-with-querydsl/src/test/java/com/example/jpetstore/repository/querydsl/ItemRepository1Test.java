package com.example.jpetstore.repository.querydsl;

import com.example.jpetstore.domain.Item;
import com.example.jpetstore.domain.QItem;
import com.querydsl.core.types.Predicate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ItemRepository1Test {

    @Autowired
    ItemRepository1 itemRepository;
/*
    @Test
    public void queryDSLTest1() {
    	System.out.println("queryDSLTest1():");
    			
        Predicate predicate = QItem.item.attribute1.containsIgnoreCase("female")
            .and(QItem.item.listPrice.between(10, 99));

        Optional<Item> foundItem = ItemRepository1.findOne(predicate);

        if(foundItem.isPresent()){
            Item item = foundItem.get();
            System.out.println(item.getItemId());
            System.out.println(item.getProductId());
            System.out.println(item.getListPrice());
            System.out.println(item.getUnitCost());
            System.out.println("------------------");
        }
    }
*/
    @Test
    public void queryDSLTest() {
    	System.out.println("queryDSLTest(): find female items with a price in range (10, 99)");
    	
        QItem qItem = QItem.item;

        Predicate predicate = qItem.attribute1.containsIgnoreCase("female")
                .and(qItem.listPrice.between(10, 99));

        Iterable<Item> itemList = itemRepository.findAll(predicate);

        for (Item item : itemList) {        	
        	System.out.println(item.getItemId());
        	System.out.println(item.getAttribute1());
            System.out.println(item.getProductId()  + " " + item.getProduct().getName());
            System.out.println("$" + item.getListPrice());
            System.out.println(item.getUnitCost());
            System.out.println("------------------");
        }        
    }

}