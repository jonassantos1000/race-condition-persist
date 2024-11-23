package com.conatus.customer.domain.mapper;

import org.mapstruct.Mapper;

import com.conatus.customer.domain.entity.CustomerEntity;
import com.conatus.customer.domain.vo.request.CreateCustomerRequest;
import com.conatus.customer.domain.vo.response.CreateCustomerResponse;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

	CustomerEntity toEntity(CreateCustomerRequest source);

	CreateCustomerResponse toVO(CustomerEntity entity);
}
