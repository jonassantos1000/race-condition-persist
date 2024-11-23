package com.conatus.customer.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.conatus.customer.domain.vo.request.CreateCustomerRequest;
import com.conatus.customer.service.CustomerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
	
	private final CustomerService customerService;
	
	@PostMapping
	public void saveCustomer(@RequestBody CreateCustomerRequest customerVO) {
		customerService.saveCustomer(customerVO);
	}
}
