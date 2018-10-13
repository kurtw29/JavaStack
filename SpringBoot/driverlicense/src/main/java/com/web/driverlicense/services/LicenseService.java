package com.web.driverlicense.services;

import org.springframework.stereotype.Service;

import com.web.driverlicense.models.License;
import com.web.driverlicense.repositories.LicenseRepository;

@Service
public class LicenseService {
	private final LicenseRepository licenseRepo;
	public LicenseService(LicenseRepository licenseRepo) {
		this.licenseRepo = licenseRepo;
	}
	
	public License addLicense(License license) {
		return licenseRepo.save(license);
	}
}
