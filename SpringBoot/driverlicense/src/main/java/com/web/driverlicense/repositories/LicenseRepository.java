package com.web.driverlicense.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.web.driverlicense.models.License;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long>{

}
