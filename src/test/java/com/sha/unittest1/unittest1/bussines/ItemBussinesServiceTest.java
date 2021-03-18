package com.sha.unittest1.unittest1.bussines;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.sha.unittest1.unittest1.data.ItemRepository;
import com.sha.unittest1.unittest1.model.Item;




@RunWith(MockitoJUnitRunner.class)
class ItemBussinesServiceTest {

	

	@InjectMocks
	private ItemBussinesService bussines;
	
	
	@Mock
    private ItemRepository repository;
	
	@Test
	void calculateSumUseingDataService_basic() throws Exception {
		when(repository.findAll()).thenReturn(
				Arrays.asList(new Item(2,"Item2",100,1),
				new Item(3,"item3",20,20)));
		
		
		List<Item> items = bussines.retereiveAll();
		
		assertEquals(200, items.get(0).getValue());
		assertEquals(400, items.get(1).getValue());

	}

}
