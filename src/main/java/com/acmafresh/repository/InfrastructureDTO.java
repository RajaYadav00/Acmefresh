package com.acmafresh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acmafresh.modelEntity.InfraStructures;
@Repository
public interface InfrastructureDTO extends JpaRepository<InfraStructures, Integer>{

}
