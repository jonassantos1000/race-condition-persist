package com.conatus.customer.domain.vo.request;

public record CreateCustomerRequest(
		
		String cpf,
		String name,
		Integer age,
		Double peso,
		Double altura
		) {

}
