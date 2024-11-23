package com.conatus.customer.domain.entity;

import java.io.Serializable;
import java.util.UUID;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "tb_customer")
@NoArgsConstructor @AllArgsConstructor
@Setter @Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CustomerEntity implements Serializable {
	private static final long serialVersionUID = -6594403951832851902L;

	@Id
	@Include
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	private String cpf;
	
	private String name;
	
	private Integer age;
	
	private Double peso;
	
	private Double altura;
}
