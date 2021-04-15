### Domain classes
* Member { _id_, name, type }
* ExamDay { _id_, date }

### Associations between Member and ExamDay
* coordinator : one_to_one
* examinators : many-to-many
* students : many-to-many

### Endpoints

* GET http://localhost:8080/members
* GET http://localhost:8080/examdays
* POST http://localhost:8080/members - payload {"name":"Danielle"}
* POST http://localhost:8080/examdays - payload {"date":"2021-05-15 12:00"}
* POST http://localhost:8080/examdays/1/coordinator - payload {"member_id":1}
* POST http://localhost:8080/examdays/1/examinators - payload {"member_id":1}
* POST http://localhost:8080/examdays/1/students - payload {"member_id":1}

