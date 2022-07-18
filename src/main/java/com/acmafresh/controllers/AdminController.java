package com.acmafresh.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acmafresh.DTO.LoginDTO;
import com.acmafresh.exceptions.LoginException;
import com.acmafresh.modelEntity.Admin;
import com.acmafresh.modelEntity.AdminSession;
import com.acmafresh.modelEntity.Products;
import com.acmafresh.services.AdminServices;
import com.acmafresh.services.LoginServices;

@RestController
@RequestMapping(value="/admin")
public class AdminController {
	
	@Autowired
	AdminServices adminservices;
	@Autowired
	LoginServices loginServices;
	
	@PostMapping("/register")
	public Admin registerAdmin(@RequestBody Admin admin) {
		return adminservices.registerAdmin(admin);

	}
	
	@PostMapping("/login")
	public ResponseEntity<AdminSession> loginAdmin(@RequestBody LoginDTO dto) throws LoginException {
		return new ResponseEntity<>(loginServices.loginAdmin(dto), HttpStatus.ACCEPTED);
	}
	
	
	@PostMapping(value = "/add")
	public Admin addAdmin(@RequestBody Admin admin) {
		
		return adminservices.addAmin(admin);
	}
	@DeleteMapping(value = "/delete")
	public String removeAdmin(Admin admin) {
		
		return adminservices.removeAdmin(admin);
	}
	
	@PostMapping(value = "/update")
	public Admin updateadmin(@RequestBody Admin admin) {
		
		return adminservices.updateAdmin(admin);
	}
	@PostMapping(value = "/produncts")
	public Products addProducts(@RequestBody Products products) {
		
		return adminservices.addproducts(products);
	}
}
