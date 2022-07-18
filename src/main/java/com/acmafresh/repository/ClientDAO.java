package com.acmafresh.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acmafresh.modelEntity.Client;

@Repository
public interface ClientDAO extends JpaRepository<com.acmafresh.modelEntity.Client, Integer>{

	Optional<Client> findByUserMobile(String mobile);

}
