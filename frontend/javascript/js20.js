class User{
  
    constructor(id,uname){
        this.userid=id;
        this.username=uname;
    }

    displayDetails(){
        console.log(this.userid+"-"+this.username);
    }

}

class Customer extends User {
  
    constructor(id,uname){
      super(id,uname);
      this.discount=20;
     }


     displayDetails(){
         super.displayDetails();
         console.log("customer discount="+this.discount);
      
        }

}


let user1=new User(11,'aditya');
let user2=new User(12,'venkat');

user1.displayDetails();

user2.displayDetails();

let customer1=new Customer(13,'remjith',20);
customer1.displayDetails();
let customer2=new Customer(12,'sripad',20);

