***Spring Spring Boot, microservices (use discovery server) , Spring DataJpa***


**Student module**

Student{

id: long

name: String

field: String

 projects: List<Long>

}


IStudentRepository{

......

}



IStudentService{

add(AddStudentRequest requestData) : StudentDetails

/** find student in the store by id **/ 

findStudentDetailsById(long id) :StudentDetails

/** find students by field **/ 

List< StudentDetails > findByField(String field)

void assignProject(AssignProjectRequest request) 

void unAssignProject(UnAssignProject request)

}



**Validations**

name, field, device, language can't be empty or null  

name: min 2 letters, max 10 letters

field : 3 letters only

id, age can't be negative, age sgould be between 17 and 22

device: min 3 letters, max 10 



  **Project module**

  
  Project{
  
  id:long
  
  projectName:String
    
  }

 IProjectRepository{
 
 ...
 }
 
 IProjectService{
 
  add(AddProjectRequest request):ProjectDetails
 
  findProjectDetailsById(long id): ProjectDetails
 
 }
   
  
**Usecases**

1)Add Project

2)find project by id

3)Add Student

4) find student by id

5)Assign Project to Student

6)UnAssign project from Student
  
  
  



