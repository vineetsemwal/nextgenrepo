
Practice task till Inheritance, Exception Handling

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

ProjectService{

store:Map<Long,Student>

  generateId(): long
    

  /**
  add electronics student in the store and return created student object
  **/
  
  addElectronicsStudent(String name, String field, String device) : ElectronicsStudent 
  
  
  /**
  add computer student in the store and return created student object
  **/
  
  addComputerScienceStudent(String name, String field, String language) : ComputerScienceStudent
  
  
  /**
  find student in the store by id
  **/
  findById(long id) :Student
  
  /**
  find students by field
  **/
  List<Student>findByField(String field)
  
  
  

}


ProjectMain{


main(){

   
// use project service

}

}


