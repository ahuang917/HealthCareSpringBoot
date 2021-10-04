package com.example.demo;

import com.example.demo.api.PatientController;
import com.example.demo.model.Patient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private PatientController controller;

	String sID = "10bafbec-0031-4f0f-8729-1310e92e95ea";
	UUID id = UUID.fromString(sID);

	Patient ahuang = new Patient(id, "Alan Huang");
	@Test
	void contextLoads() {

		assertThat(controller).isNotNull();
	}

	@Test
	void testAddPatient() {
		controller.addPatient(ahuang);
		assertThat(controller.getAllPatients().size()).isEqualTo(1);

	}

	@Test
	void testGetById() {
		controller.addPatient(ahuang);
		assertThat(controller.getPatientByID(id).equals(ahuang));
	}

	@Test
	void testDeletePatient() {

		controller.deletePersonById(id);
		assertThat(controller.getAllPatients().size()).isEqualTo(0);
	}

	@Test
	void testUpdatePatient() {
		UUID rID = UUID.randomUUID();
		Patient alexH = new Patient(rID,"Alex Huang");
		controller.updatePatientById(id, alexH);

		assertThat(controller.getPatientByID(id).getName()).isEqualTo("Alex Huang");
		assertThat(controller.getAllPatients().size()).isEqualTo(1);
	}
}
