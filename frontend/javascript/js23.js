class Employee{

    constructor(id){
        this.getId=()=>id ;

    }

}

const emp1=new Employee(20);
const id=emp1.getId();
console.log("id="+id);