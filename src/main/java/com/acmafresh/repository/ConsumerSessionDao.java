package com.acmafresh.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acmafresh.modelEntity.ConsumerSession;
import com.acmafresh.modelEntity.Consumers;

public interface ConsumerSessionDao extends JpaRepository<ConsumerSession, Integer>{

	Optional<ConsumerSession> findByUuid(String uuid);

	Optional<ConsumerSession> findByConsumerId(Integer consumerId);

}
