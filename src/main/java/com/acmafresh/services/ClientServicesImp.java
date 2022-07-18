package com.acmafresh.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acmafresh.modelEntity.Client;
import com.acmafresh.modelEntity.InfraStructures;
import com.acmafresh.modelEntity.Products;
import com.acmafresh.repository.ClientDAO;
import com.acmafresh.repository.InfrastructureDTO;
import com.acmafresh.repository.ProductsDAO;

@Service
public class ClientServicesImp implements ClientServices{

	@Autowired
	ClientDAO clientdao;
	@Autowired
	InfrastructureDTO infradao;
	@Autowired
	ProductsDAO productsdao;
	
	@Override
	public List<InfraStructures> getListOfIfrastructure() {
		
		List<InfraStructures> infraList=infradao.findAll();
		return  infraList;
	}

	@Override
	public Products addlproducts(Products products) {
		 
		Products newItem=productsdao.save(products);
		return newItem;
	}

	@Override
	public Client addClient(Client client) {
		
		return clientdao.save(null);
	}

	@Override
	public String removeClient(Client client) {
		clientdao.delete(client);
		return "client deleted";
	}

	@Override
	public Client updateClient(Client client) {
		
		return clientdao.save(client);
	}

	@Override
	public Client clientRegister(Client client) {
		
		return clientdao.save(client);
	}

}
