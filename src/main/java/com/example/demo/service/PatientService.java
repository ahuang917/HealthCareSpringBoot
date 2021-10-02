package com.example.demo.service;

import com.example.demo.dao.PatientDao;
import com.example.demo.model.Patient;

public class PatientService {
    private final PatientDao patientDao;

    public PatientService(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    public int addPatient(Patient patient) {
        return patientDao.insertPatient(patient);
    }


}
