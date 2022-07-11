package com.chainsys.mavenlessons.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import com.chainsys.mavenlessons.entity.Appointment;
import com.chainsys.mavenlessons.entity.Doctor;
import com.chainsys.mavenlessons.repository.DoctorRepository;

@RestController
public class DoctorControl {
	@Autowired
	private DoctorRepository repo;

	@GetMapping(value = "/getdoctor")
	public Doctor getDoctor(int id) {
		return repo.findById(id);
	}
//	---------------------------------------------
//	@GetMapping(value = "/getdoctor")
//	public String getDoctor(int id) {
//		return repo.findById(id).toString();
//	}
	
	@GetMapping(value = "/getdoctorappointments")
	public List<Appointment> getAppointments(int id) {
		Doctor doc = repo.findById(id);
		List<Appointment> appointments = doc.getAppointments(); 
		return appointments; 
	}
//------------------------------------
	@GetMapping(value = "/getalldoctors")
	public List<Doctor> getDoctors() {
		return repo.findAll();
	}

	@PostMapping(value = "/newdoctor", consumes = "application/json")
	public RedirectView addDoctor(@RequestBody Doctor dr) {
		repo.save(dr);
		return new RedirectView("/getalldoctors");

	}

	@PostMapping(value = "/modifydoctor", consumes = "application/json")
	public RedirectView modifyDoctor(@RequestBody Doctor dr) {
		repo.save(dr);
		return new RedirectView("/getalldoctors");

	}

	@DeleteMapping(value = "/deletedoctor")
	public RedirectView deleteDoctor(int id) {
		repo.deleteById(id);
		return new RedirectView("/getalldoctors");
	}
}