package com.sha.unittest1.unittest1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sha.unittest1.unittest1.bussines.ItemBussinesService;
import com.sha.unittest1.unittest1.model.Item;

@RestController
public class ItemController {
	
	
	@Autowired
	 private ItemBussinesService bussinesService;
	
	@GetMapping("/items")
	public Item order() {
		return new Item(1,"shoe", 200, 2);
	}
	
	
	@GetMapping("/bussinesitem")
	public Item myOrder() {
		return  bussinesService.retreiveHardcodedItem();
	}
	

	@GetMapping("/allitems")
	public List<Item> reteriveAllItems() {
		return  bussinesService.retereiveAll();
	}
	

}
