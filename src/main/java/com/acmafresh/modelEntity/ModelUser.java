package com.acmafresh.modelEntity;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ModelUser {
	
	private String username;

	
	private String password;
	private String address;
	
	@Column(unique = true)
	private String mobile;
	
	@Column(unique = true)
	private String email;
	
	
	
}
