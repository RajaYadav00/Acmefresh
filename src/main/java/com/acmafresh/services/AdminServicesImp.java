package com.acmafresh.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acmafresh.modelEntity.Admin;
import com.acmafresh.modelEntity.Products;
import com.acmafresh.repository.AdminDao;
import com.acmafresh.repository.ProductsDAO;

@Service
public class AdminServicesImp implements AdminServices{
	
	@Autowired
	AdminDao admindao;
	
	@Autowired
	ProductsDAO productsdao;

	@Override
	public Admin addAmin(Admin admin) {
		
		
		return admindao.save(admin);
	}

	@Override
	public String removeAdmin(Admin admin) {
		admindao.delete(admin);
		return "Admin delete";
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		
		
		return admindao.save(admin) ;
	}

	@Override
	public Products addproducts(Products products) {
		
		return productsdao.save(products);
	}

	@Override
	public Admin registerAdmin(Admin admin) {
		
		Admin admic=admindao.save(admin);
		return admic;
	}

}
