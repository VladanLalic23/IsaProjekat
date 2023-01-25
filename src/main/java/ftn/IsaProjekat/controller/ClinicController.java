package ftn.IsaProjekat.controller;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.IsaProjekat.dto.ClinicDTO;
import ftn.IsaProjekat.mappers.ClinicMapper;
import ftn.IsaProjekat.model.clinic.Clinic;
import ftn.IsaProjekat.service.interfaces.IClinicService;

@RestController
@RequestMapping(value = "/clinic")
@CrossOrigin(origins ="http://localhost:8080")
public class ClinicController {

    @Autowired
    private IClinicService clinicService;

    @GetMapping("/search/{input}")
    public ResponseEntity<Clinic> findByName(@PathVariable String input) {
        Clinic clinic = clinicService.findByName((input));
        if( clinic == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(clinic, HttpStatus.OK);
    }


	@GetMapping(value = "/all")
	public ResponseEntity<Set<ClinicDTO>> findAll(){
		List<Clinic> allClinics = clinicService.findAll();
		return new ResponseEntity<>(ClinicMapper.createClinicDTOSetfromClinicList(allClinics), HttpStatus.OK);
	}

    
}