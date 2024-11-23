package com.conatus.customer.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.conatus.customer.domain.entity.CustomerEntity;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, UUID> {
	
//    @Transactional
//    @Modifying
//	@Query(value = "begin; LOCK TABLE tb_customer IN ACCESS EXCLUSIVE MODE;", nativeQuery = true)
//    void lockTabela(); 
	
	boolean existsByCpf(String cpf);
}
