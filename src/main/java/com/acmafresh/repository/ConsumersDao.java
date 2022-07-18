package com.acmafresh.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acmafresh.modelEntity.Consumers;
@Repository
public interface ConsumersDao extends JpaRepository<Consumers,Integer>{

	Optional<Consumers> findByUserMobile(String mobile);

}
