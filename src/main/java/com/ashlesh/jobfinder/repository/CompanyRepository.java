package com.ashlesh.jobfinder.repository;

import com.ashlesh.jobfinder.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  CompanyRepository  extends JpaRepository<Company, Long> {
}
