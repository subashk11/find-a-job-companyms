package com.springboot.microservice.companyms.service;


import com.springboot.microservice.companyms.entity.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    List<Company> getAllCompanies();
    Optional<Company> getCompanyById(String companyId);
    boolean updateCompanyDetails(String companyId, Company companyDetails);
    boolean deleteCompany(String companyId);
    boolean createCompany(Company companyDetails);
}
