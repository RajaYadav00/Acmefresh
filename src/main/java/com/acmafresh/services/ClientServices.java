package com.acmafresh.services;


import java.util.List;

import com.acmafresh.modelEntity.Client;
import com.acmafresh.modelEntity.InfraStructures;
import com.acmafresh.modelEntity.Products;

public interface ClientServices {
	
	public Client addClient(Client client);
	public String removeClient(Client client);
	public Client updateClient(Client client);
	public List<InfraStructures> getListOfIfrastructure();
	public Products addlproducts(Products products);
	public Client clientRegister(Client client);
}
