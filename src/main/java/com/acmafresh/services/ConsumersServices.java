package com.acmafresh.services;


import java.util.List;

import com.acmafresh.modelEntity.Client;
import com.acmafresh.modelEntity.Consumers;
import com.acmafresh.modelEntity.Products;

public interface ConsumersServices {
			
	public Consumers addConsumer(Consumers consumer);
	public String removeConsumer(Integer id);
	public Consumers updateConsumer(Consumers consumer);
	public List<Products> getListOfItems();
	public String addListOfItems(Products item);
	public Consumers consumerRegister(Consumers consumer);
}
