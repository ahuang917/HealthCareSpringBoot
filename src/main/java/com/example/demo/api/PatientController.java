package com.example.demo.api;

import com.example.demo.model.Patient;
import com.example.demo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/patient")
@RestController
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public void addPatient(@Valid @NonNull @RequestBody Patient patient){
        patientService.addPatient(patient);
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping(path = "{id}")
    public Patient getPatientByID (@PathVariable("id") UUID id) {
        return patientService.getPatientByID(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id) {
        patientService.deletePatient(id);
    }

    @PutMapping(path ="{id}")
    public void updatePatientById(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody Patient patient) {
        patientService.updatePatient(id, patient);
    }
}
