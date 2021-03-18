package com.sha.unittest1.unittest1.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sha.unittest1.unittest1.bussines.ItemBussinesService;
import com.sha.unittest1.unittest1.model.Item;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;

import javax.net.ssl.SSLEngineResult.Status;



@RunWith(SpringRunner.class)
@WebMvcTest
class ItemControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	ItemBussinesService bussinesService;
	
	
	@Test
	void ItemControllerTest_simple() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/items").accept(MediaType.APPLICATION_JSON);
		
		MvcResult mvcResult = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json(("{id:1,name:shoe,price:200,quantity:2}")))
				.andReturn();
	}
	@Test
	void ItemControllerTest_BusinessService_mock() throws Exception {
		when(bussinesService.retreiveHardcodedItem()).thenReturn(new Item(1,"shoe",200,2));
		
		RequestBuilder request = MockMvcRequestBuilders.get("/bussinesitem").accept(MediaType.APPLICATION_JSON);
		
		MvcResult mvcResult = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json(("{id:1,name:shoe,price:200,quantity:2}")))
				.andReturn();
	}
	
	@Test 
	void retreiveAllItems_basic()throws Exception{
		when ( bussinesService.retereiveAll()).thenReturn(
				Arrays.asList(new Item(1,"skate",100,2),
				new Item(2,"rollerblade",100,2))
				);
		
		RequestBuilder request = MockMvcRequestBuilders.get("/allitems").accept(MediaType.APPLICATION_JSON);

		

		MvcResult mvcResult = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json(("[{id:1,name:skate,price:100,quantity:2},{id:2,name:rollerblade,price:100,quantity:2}]")))
				.andReturn();
	}

}
