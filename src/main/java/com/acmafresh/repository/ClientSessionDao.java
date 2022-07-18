package com.acmafresh.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acmafresh.modelEntity.Client;
import com.acmafresh.modelEntity.ClientSession;

public interface ClientSessionDao extends JpaRepository<ClientSession, Integer> {


	public Optional<ClientSession> findByClientId(Integer clientId);

}
