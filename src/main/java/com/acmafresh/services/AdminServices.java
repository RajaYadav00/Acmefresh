package com.acmafresh.services;


import com.acmafresh.modelEntity.Admin;
import com.acmafresh.modelEntity.Products;

public interface AdminServices {
		
	public  Admin registerAdmin(Admin admin);

	public Admin addAmin(Admin admin);
	public String removeAdmin(Admin admin);
	public Admin updateAdmin(Admin admin);
	public Products addproducts(Products products);
}
