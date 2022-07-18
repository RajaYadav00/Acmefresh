package com.acmafresh.modelEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InfraStructures {
	
	   @Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
		Integer StructureId;
	   String structureType;
	   double structureArea;
	   String location;
	   
}