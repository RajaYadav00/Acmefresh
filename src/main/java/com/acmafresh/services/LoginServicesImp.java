package com.acmafresh.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acmafresh.DTO.LoginDTO;
import com.acmafresh.exceptions.AdminException;
import com.acmafresh.exceptions.ClientsException;
import com.acmafresh.exceptions.ConsumersException;
import com.acmafresh.exceptions.LoginException;
import com.acmafresh.modelEntity.Admin;
import com.acmafresh.modelEntity.AdminSession;
import com.acmafresh.modelEntity.Client;
import com.acmafresh.modelEntity.ClientSession;
import com.acmafresh.modelEntity.ConsumerSession;
import com.acmafresh.modelEntity.Consumers;
import com.acmafresh.repository.AdminDao;
import com.acmafresh.repository.AdminSessionDao;
import com.acmafresh.repository.ClientDAO;
import com.acmafresh.repository.ClientSessionDao;
import com.acmafresh.repository.ConsumerSessionDao;
import com.acmafresh.repository.ConsumersDao;

@Service
public class LoginServicesImp implements LoginServices {

	@Autowired
	AdminSessionDao adminSessionDao;
	@Autowired
	ClientSessionDao clientSessionDao;
	@Autowired
	ConsumerSessionDao consumerSessionDao;
	
	@Autowired
	private AdminDao adminDao;
	@Autowired
	ConsumersDao consumerDao;
	@Autowired
	ClientDAO clientDao;
	
	@Override
	public AdminSession loginAdmin(LoginDTO dto) throws LoginException {
		Optional<Admin> res = adminDao.findByUserMobile(dto.getMobile());

		if (res.isEmpty()) {
			System.out.println("No Admin exist");
			throw new AdminException("Admin was not there in the data base");
		}

		Admin existingAdmin = res.get();
		Optional<AdminSession> opt = adminSessionDao.findByAdminId(existingAdmin.getAdminId());

		if (opt.isPresent())
			throw new LoginException("admin already logged in");

		if (existingAdmin.getUser().getPassword().equals(dto.getPassword())) {

			AdminSession newSession = new AdminSession();

			newSession.setAdminId(existingAdmin.getAdminId());
			newSession.setUserType("Customer");
			newSession.setSessionStartTime(LocalDateTime.now());
			newSession.setSessionEndTime(LocalDateTime.now().plusHours(1));

			UUID uuid = UUID.randomUUID();
			String token = uuid.toString().split("-")[0];

			newSession.setUuid(token);

			return adminSessionDao.save(newSession);
		} else {
			throw new LoginException("Password Incorrect. Try again.");
		}
	
	}

	@Override
	public ClientSession loginClient(LoginDTO client) throws LoginException {
		Optional<Client> res = clientDao.findByUserMobile(client.getMobile());

		if (!res.isPresent()) {
			System.out.println(res + " Data is empty");
			throw new ClientsException("Clientdoes not exist with the given mobile number");
		}

		Client existingCustomer = res.get();
		Optional<ClientSession> opt = clientSessionDao.findByClientId(existingCustomer.getClientId());

		if (opt.isPresent())
			throw new LoginException("client already logged in");

		if (existingCustomer.getUser().getPassword().equals(client.getPassword())) {

			ClientSession newSession = new ClientSession();

			newSession.setClientId(existingCustomer.getClientId());
			newSession.setUserType("Customer");
			newSession.setSessionStartTime(LocalDateTime.now());
			newSession.setSessionEndTime(LocalDateTime.now().plusHours(1));

			UUID uuid = UUID.randomUUID();
			String token = uuid.toString().split("-")[0];

			newSession.setUuid(token);

			return clientSessionDao.save(newSession);
		} else {
			throw new LoginException("Password Incorrect. Try again.");
		}

	}

	@Override
	public ConsumerSession loginConsumer(LoginDTO dto) throws LoginException {
		Optional<Consumers> res = consumerDao.findByUserMobile(dto.getMobile());

		if (!res.isPresent()) {
			System.out.println(res + " Data is empty");
			throw new ConsumersException("Driver does not exist with the given mobile number");
		}
		Consumers existingConsumer = res.get();
		Optional<ConsumerSession> opt = consumerSessionDao.findByConsumerId(existingConsumer.getConsumerId());

		if (opt.isPresent())
			throw new LoginException("User already logged in");

		if (existingConsumer.getUser().getPassword().equals(dto.getPassword())) {

			ConsumerSession newSession = new ConsumerSession();

			newSession.setConsumerId(existingConsumer.getConsumerId());
			newSession.setUserType("Consumer");
			newSession.setSessionStartTime(LocalDateTime.now());
			newSession.setSessionEndTime(LocalDateTime.now().plusHours(1));

			UUID uuid = UUID.randomUUID();
			String token = uuid.toString().split("-")[0];

			newSession.setUuid(token);

			return consumerSessionDao.save(newSession);
		} 
		else {
			throw new LoginException("Password Incorrect. Try again.");
		}
		
	}

}
