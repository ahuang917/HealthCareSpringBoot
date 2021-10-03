package com.example.demo.dao;

import com.example.demo.model.Patient;

import javax.swing.text.html.Option;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PatientDao {

    int insertPatient(UUID id, Patient patient);
    default int insertPatient(Patient patient) {
        UUID id = UUID.randomUUID();
        return insertPatient(id, patient);
    }

    List<Patient> selectAllPatients();

    Optional<Patient> selectPersonById(UUID id);

    int deletePatientById(UUID id);

    int updatePatientById(UUID id, Patient patient);
}
