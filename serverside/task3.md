****Spring DI Use Java based configuration for DI  - Layered Architecture task, Use HashMap for storage****

Student{

id: long

name: String

field: String

}

ElectronicsStudent extends Student{

device: String

}

ComputerScienceStudent extends Student{

language: String

}

IStudentDao{

void add(Student student)

Student update(Student student)

Optional< Student >  findById(long id)

List<Student>findAll()

}



IStudentService{

/** add electronics student in the store and return created student object **/

addElectronicsStudent(String name, String field, String device) : ElectronicsStudent

/** add computer student in the store and return created student object **/

addComputerScienceStudent(String name, String field, String language) : ComputerScienceStudent

/** find student in the store by id **/ 

findById(long id) :Student

/** find students by field **/ 

List<Student> findByField(String field)

}

/**
presentation class
**/

FrontEndClient{


}


**Validations**

name, field, device, language can't be empty or null

id, age can't be negative


