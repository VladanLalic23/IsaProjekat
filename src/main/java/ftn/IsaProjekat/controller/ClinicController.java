package ftn.IsaProjekat.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.googlejavaformat.Input;

import ftn.IsaProjekat.model.clinic.Clinic;
import ftn.IsaProjekat.service.interfaces.IClinicService;

@RestController
@RequestMapping(value = "/clinic")
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

    
}