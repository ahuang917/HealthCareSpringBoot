package com.example.demo.dao;

import com.example.demo.model.Patient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class FakePatientDataAccessService implements PatientDao {

    private static List<Patient> DB = new ArrayList<>();

    @Override
    public int insertPatient(UUID id, Patient patient) {
        DB.add(new Patient(id, patient.getName()));
        return 0;
    }
}
