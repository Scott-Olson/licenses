package com.scott.license.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.scott.license.models.License;
import com.scott.license.models.Person;
import com.scott.license.repositories.LicenseRepo;
import com.scott.license.repositories.PersonRepo;

@Service
public class MainService {
	private final PersonRepo personRepo;
	private final LicenseRepo licenseRepo;
	
	public MainService(PersonRepo personRepo, LicenseRepo licenseRepo) {
		this.personRepo = personRepo;
		this.licenseRepo = licenseRepo;
	}
	
	public List<Person> allPeople(){
		return personRepo.findAll();
	}
	public Person getPerson(Long id) {
		Optional<Person> optionalPerson = personRepo.findById(id);
		if(optionalPerson.isPresent()) {
			return optionalPerson.get();
		}else {
			return null;
		}
	}
	
	public Person createPerson( Person p) {
		return personRepo.save(p);
	}
	
	public License createLicense( License l) {
		return licenseRepo.save(l);
	}
	
	public void assignLicense(Person p, License l) {
		p.setLicense(l);
	}
	
}
