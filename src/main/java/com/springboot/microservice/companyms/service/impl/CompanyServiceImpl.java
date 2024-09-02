package com.springboot.microservice.companyms.service.impl;

import com.mongodb.client.result.UpdateResult;
import com.springboot.microservice.companyms.entity.Company;
import com.springboot.microservice.companyms.repository.CompanyRepository;
import com.springboot.microservice.companyms.service.CompanyService;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
public class CompanyServiceImpl implements CompanyService {

    // Mongo repository
    private CompanyRepository companyRepository;
    private MongoTemplate mongoTemplate;

    public CompanyServiceImpl(CompanyRepository companyRepository, MongoTemplate mongoTemplate){
        this.companyRepository = companyRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Optional<Company> getCompanyById(String companyId) {
        return companyRepository.findById(companyId);
    }

    @Override
    public boolean updateCompanyDetails(String companyId, Company companyDetails) {
        ObjectId _id = new ObjectId(companyId);
        Query query = new Query(where("_id").is(_id));
        Update update = new Update().set("name", companyDetails.getName())
                .set("description", companyDetails.getDescription())
                .set("jobs", companyDetails.getJobs())
                .set("reviews", companyDetails.getReviews());

        UpdateResult updateResult =  this.mongoTemplate.updateFirst(query, update, Company.class);
        return false;
    }

    @Override
    public boolean deleteCompany(String companyId) {
        companyRepository.deleteById(companyId);
        return false;
    }

    @Override
    public boolean createCompany(Company companyDetails) {
        companyRepository.save(companyDetails);
        return false;
    }
}
