package com.chainsys.mavenlessons.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.chainsys.mavenlessons.entity.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor,Integer>{
	Doctor findById(int id);
	List <Doctor> findAll();
	Doctor save(Doctor dr);
	void deleteById(int id);

}