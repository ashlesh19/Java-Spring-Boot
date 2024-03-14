package com.ashlesh.jobfinder.service;

import com.ashlesh.jobfinder.model.Company;

import java.util.List;


public interface CompanyService {

    List<Company> getAllCompanies();

    boolean updateCompany(Company company, Long id);

    void createCompany(Company company);

    boolean deleteCompanyById(Long id);

    Company getCompanyById(Long id);

}
