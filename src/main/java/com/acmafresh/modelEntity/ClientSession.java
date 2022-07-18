package com.acmafresh.modelEntity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


import lombok.Data;
@Data
@Entity
public class ClientSession {
	@Id
	@SequenceGenerator(name="adminSession_generator", sequenceName = "adminSession_seq", allocationSize=50)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adminSession_generator")
	private Integer sessionId;
	private Integer clientId;
	private String uuid;
	private String userType;
	private LocalDateTime sessionStartTime;
	private LocalDateTime sessionEndTime;
}
