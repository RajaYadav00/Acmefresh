package com.acmafresh.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acmafresh.DTO.LoginDTO;
import com.acmafresh.exceptions.LoginException;
import com.acmafresh.modelEntity.AdminSession;
import com.acmafresh.modelEntity.Client;
import com.acmafresh.modelEntity.InfraStructures;
import com.acmafresh.modelEntity.Products;
import com.acmafresh.services.ClientServices;
import com.acmafresh.services.LoginServices;


@RestController
@RequestMapping(value = "/client")
public class ClientController {
 
	        @Autowired
	        ClientServices clientServices;
	        @Autowired
	        LoginServices loginServices;
	        
	        
	        
	        @PostMapping("/register")
	    	public Client registerAdmin(@RequestBody Client admin) {
	    		return clientServices.clientRegister(admin);

	    	}
	        
	        @PostMapping("/login")
	    	public ResponseEntity<AdminSession> loginAdmin(@RequestBody LoginDTO dto) throws LoginException {
	    		return new ResponseEntity<>(loginServices.loginAdmin(dto), HttpStatus.ACCEPTED);
	    	}
	        
	         @GetMapping(value = "/listOfInfrastructure")
	        public  List<InfraStructures> getlistOfInfrastructures() {
	        	
	        return	clientServices.getListOfIfrastructure();
	        }
	         @PostMapping(value = "/products")
	         public String addproducts(@RequestBody Products products) {
	        	 
	        	 Products addedItem=clientServices.addlproducts(products);
	        	 return addedItem+"-added into th list of Items";
	         }
	         
	         @PostMapping(value = "/add")
	         public  Client addClient(@RequestBody Client client) {
	        	 
	        	 return clientServices.addClient(client);
	         }
	         @DeleteMapping
	         public String removeClient(@RequestBody Client client) {
	        	 
	        	 return clientServices.removeClient(client);
	         }
	         @PostMapping(value = "/update")
	         public Client updateClient(@RequestBody Client client) {
	        	 
	        	 return clientServices.updateClient(client);
	         }
}
