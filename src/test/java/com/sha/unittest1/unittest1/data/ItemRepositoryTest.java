package com.sha.unittest1.unittest1.data;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sha.unittest1.unittest1.model.Item;


@RunWith(SpringRunner.class)
@DataJpaTest
class ItemRepositoryTest {

	@Autowired
	 private ItemRepository repository;
	
	
	@Test
	void testFindAll() {
		List<Item> items = repository.findAll();
		
		
		assertEquals(1, items.size());
	}

}
