package com.scott.license.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.scott.license.models.License;
import com.scott.license.models.Person;

@Repository
public interface LicenseRepo extends CrudRepository<License, Long> {
	
	List<License> findAll();
	
	Optional<License> findByPerson(Person p);
}
