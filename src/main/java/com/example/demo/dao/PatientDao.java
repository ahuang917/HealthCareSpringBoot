package com.example.demo.dao;

import com.example.demo.model.Patient;

import java.util.UUID;

public interface PatientDao {

    int insertPatient(UUID id, Patient patient);
    default int insertPatient(Patient patient) {
        UUID id = UUID.randomUUID();
        return insertPatient(id, patient);
    }
}
