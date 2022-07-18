package com.acmafresh.modelEntity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Products {
	@Id
		Integer itemId;
		String nameOfItem;
		double quantity;
		double ratePerKg;
}
