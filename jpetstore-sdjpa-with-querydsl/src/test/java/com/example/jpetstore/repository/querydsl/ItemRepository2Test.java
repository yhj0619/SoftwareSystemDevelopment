package com.example.jpetstore.repository.querydsl;

import com.example.jpetstore.domain.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ItemRepository2Test {

    @Autowired
    ItemRepository2 itemRepository;

    @Test
    public void queryDSLTest() {
    	System.out.println("queryDSLTest(): find female items with a price in range (10, 99)");
    	
        Iterable<Item> itemList = itemRepository.findFemaleItemsWithPriceInRange(10, 99);        

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