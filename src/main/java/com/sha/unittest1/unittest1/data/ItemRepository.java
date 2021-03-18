package com.sha.unittest1.unittest1.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sha.unittest1.unittest1.model.Item;

public interface ItemRepository extends JpaRepository<Item,Integer> {

}
