package com.springboot.microservice.companyms.repository;


import com.springboot.microservice.companyms.entity.Company;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyRepository extends MongoRepository<Company, String> {
}
