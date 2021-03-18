package com.sha.unittest1.unittest1.bussines;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sha.unittest1.unittest1.data.ItemRepository;
import com.sha.unittest1.unittest1.model.Item;

@Component
public class ItemBussinesService {

	@Autowired
	ItemRepository repository;
	
	public Item retreiveHardcodedItem(){
		return new Item(20,"skateboard", 200, 1);
		
	}
	
	
	public List<Item> retereiveAll(){
		
		List<Item> items =repository.findAll();
		
		for(Item item:items) {
			item.setValue(item.getPrice()*item.getQuantity());
		}
		
		return items;
		
	}
	
}
