package com.acmafresh.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acmafresh.modelEntity.InfraStructures;
import com.acmafresh.services.InfraStructureServices;

@RestController
@RequestMapping(value="/infrastructure")
public class InfrastructController {
		
	@Autowired
	InfraStructureServices  infraStructureServices ;
	
	
	@PostMapping(value = "/addnew")
	public  ResponseEntity<InfraStructures> addInfratype(@RequestBody InfraStructures infra ) {
		
		InfraStructures  addInfra=infraStructureServices.addNewInfrastructure(infra);
		ResponseEntity<InfraStructures> newInfra=new ResponseEntity<InfraStructures>( addInfra,HttpStatus.ACCEPTED);
		return  newInfra;
	}
}
