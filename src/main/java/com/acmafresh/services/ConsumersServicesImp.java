package com.acmafresh.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acmafresh.modelEntity.Client;
import com.acmafresh.modelEntity.Consumers;
import com.acmafresh.modelEntity.Products;
import com.acmafresh.repository.ConsumersDao;
import com.acmafresh.repository.ProductsDAO;

@Service
public class ConsumersServicesImp implements ConsumersServices {

	@Autowired
	ConsumersDao consumerdao;

	@Autowired
	ProductsDAO productsdao;

	@Override
	public List<Products> getListOfItems() {

		List<Products> itemsList = productsdao.findAll();
		return itemsList;
	}

	@Override
	public String addListOfItems(Products item) {
		productsdao.save(item);
		return "Item added successfully";
	}

	@Override
	public Consumers addConsumer(Consumers consumer) {
		
		return consumerdao.save(consumer);
	}

	@Override
	public String removeConsumer(Integer id) {
		Consumers consumerToDlete=consumerdao.getReferenceById(id);
		consumerdao.delete(consumerToDlete);
		return "consumer deleted with Id"+id;
	}

	@Override
	public Consumers updateConsumer(Consumers consumer) {
		
		
		return consumerdao.save(consumer);
	}

	@Override
	public Consumers consumerRegister(Consumers consumer) {
		
		return  consumerdao.save(consumer);
	}

}
