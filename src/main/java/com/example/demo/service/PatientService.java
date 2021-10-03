package com.example.demo.service;

import com.example.demo.dao.PatientDao;
import com.example.demo.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    private final PatientDao patientDao;

    @Autowired
    public PatientService(@Qualifier("fakeDao") PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    public int addPatient(Patient patient) {
        return patientDao.insertPatient(patient);
    }


}
