package com.acmafresh.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acmafresh.modelEntity.Admin;

@Repository
public interface AdminDao extends JpaRepository<Admin, Integer>{

	public Optional<Admin> findByUserMobile(String mobile);

}
