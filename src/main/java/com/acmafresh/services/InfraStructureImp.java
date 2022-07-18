package com.acmafresh.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acmafresh.modelEntity.InfraStructures;
import com.acmafresh.repository.InfrastructureDTO;

@Service
public class InfraStructureImp implements InfraStructureServices {
      
		@Autowired
		InfrastructureDTO infradto;
	@Override
	public InfraStructures addNewInfrastructure(InfraStructures infra) {
		     
		
		return  infradto.save(infra);
	}

}
