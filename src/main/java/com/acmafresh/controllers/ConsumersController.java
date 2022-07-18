package com.acmafresh.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acmafresh.DTO.LoginDTO;
import com.acmafresh.exceptions.LoginException;
import com.acmafresh.modelEntity.AdminSession;
import com.acmafresh.modelEntity.Client;
import com.acmafresh.modelEntity.ClientSession;
import com.acmafresh.modelEntity.Consumers;
import com.acmafresh.modelEntity.Products;
import com.acmafresh.services.ConsumersServices;
import com.acmafresh.services.LoginServices;

@RestController
@RequestMapping(value = "/consumers")
public class ConsumersController {

//	  private static final Logger LOGGER = LogManager.addLogger(UserController.class);
//	private static final Logger logger = (Logger) LogManager.getLogger(UserController.class);
	@Autowired
	ConsumersServices consumersServices;
	
	@Autowired
	LoginServices loginServices;
	
	@PostMapping("/register")
	public Consumers registerClient(@RequestBody Consumers consumer) {
		return consumersServices.consumerRegister(consumer);

	}
	@PostMapping("/login")
	public ResponseEntity<ClientSession> loginClient(@RequestBody LoginDTO dto) throws LoginException {
		return new ResponseEntity<>(loginServices.loginClient(dto), HttpStatus.ACCEPTED);
	}

	@GetMapping
	public List<Products> getlistOfItems() {

		List<Products> itemsList = consumersServices.getListOfItems();

		return itemsList;

	}
	
	@PostMapping(value = "/add")
	public Consumers addConsumers(@RequestBody Consumers consumer) {
		
		return consumersServices.addConsumer(consumer);
	}
	
	
	
	@DeleteMapping(value = "/remove/{id}")
	public String remoneConsumerById(@PathVariable("?") Integer id ) {
		
		return consumersServices.removeConsumer(id);
	}
	@PostMapping(value = "/update")
	public Consumers updateConsumers(@RequestBody Consumers consumer) {
		
		return consumersServices.updateConsumer(consumer);
	}

}
