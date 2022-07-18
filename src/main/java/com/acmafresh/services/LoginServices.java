package com.acmafresh.services;

import com.acmafresh.DTO.LoginDTO;
import com.acmafresh.exceptions.LoginException;
import com.acmafresh.modelEntity.AdminSession;
import com.acmafresh.modelEntity.ClientSession;
import com.acmafresh.modelEntity.ConsumerSession;

public interface LoginServices {
	public AdminSession loginAdmin(LoginDTO dto)throws LoginException;

	public ClientSession loginClient(LoginDTO Client)throws LoginException;
	
	public ConsumerSession loginConsumer(LoginDTO dto)throws LoginException;
}
