package com.conatus.customer.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.conatus.customer.annotations.LockTable;
import com.conatus.customer.domain.mapper.CustomerMapper;
import com.conatus.customer.domain.vo.request.CreateCustomerRequest;
import com.conatus.customer.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {
	
	private final CustomerRepository customerRepository;

	private final CustomerMapper mapper;

	@Transactional
	@LockTable("tb_customer")
	public void saveCustomer(CreateCustomerRequest customerVO) {
		
		boolean isExiste = customerRepository.existsByCpf(customerVO.cpf());
		
		if (!isExiste) {
			customerRepository.save(mapper.toEntity(customerVO));
		}
	}

}
