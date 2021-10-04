# HealthCareSpringBoot
Application developed using Java Spring Boot framework. Will include a REST web API, unit tests, and front end application. Will allow users to retrieve and modify patient data. Current project is a work in progress.

Current endpoints include:

## GET
localhost:8080/api/v1/patient/ retrieves all patients
localhost:8080/api/v1/patient/{PatientID} retrieve patient by ID

## POST 
localhost:8080/api/v1/patient to add new Patient
### Example payload / body
```
{
	"name": "Alan H"
}
```

## DELETE
localhost:8080/api/v1/patient/{PatientID} deletes patient by ID

## PUT
localhost:8080/api/v1/patient/{PatientID} updates patient by ID with new payload
### Example payload / body
```
{
	"name": "Allen G"
}
```
