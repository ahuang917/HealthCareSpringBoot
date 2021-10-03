package com.example.demo.dao;

import com.example.demo.model.Patient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePatientDataAccessService implements PatientDao {

    private static List<Patient> DB = new ArrayList<>();

    @Override
    public int insertPatient(UUID id, Patient patient) {
        DB.add(new Patient(id, patient.getName()));
        return 0;
    }

    @Override
    public List<Patient> selectAllPatients() {
        return DB;
    }

    @Override
    public Optional<Patient> selectPersonById(UUID id) {
        return DB.stream()
                .filter(patient -> patient.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePatientById(UUID id) {
        Optional<Patient> potentialPatient = selectPersonById(id);

        if(potentialPatient.isEmpty()){
            return 0;
        }
        DB.remove(potentialPatient.get());

        return 1;
    }

    @Override
    public int updatePatientById(UUID id, Patient patient) {
        Optional<Patient> potentialPatient = selectPersonById(id);
        if(potentialPatient.isEmpty()) {
            return 0;
        }

        DB.set(DB.indexOf(potentialPatient.get()), new Patient(id, patient.getName()));
        return 1;
    }
}
