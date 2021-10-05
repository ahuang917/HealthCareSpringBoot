package com.example.demo.service;

import com.example.demo.dao.PatientDao;
import com.example.demo.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PatientService {
    private final PatientDao patientDao;

    @Autowired
    public PatientService(@Qualifier("postgres") PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    public int addPatient(Patient patient) {
        return patientDao.insertPatient(patient);
    }

    public List<Patient> getAllPatients() {
        return patientDao.selectAllPatients();
    }

    public Optional<Patient> getPatientByID(UUID id) {
        return patientDao.selectPersonById(id);
    }

    public int deletePatient(UUID id) {
        return patientDao.deletePatientById(id);
    }

    public int updatePatient(UUID id, Patient patient) {
        return patientDao.updatePatientById(id, patient);
    }
}
