/*
function declaration in object
*/

var user1={
uname:'remjith',
age:21,

displayUser:function(){
    console.log(this.uname+"-"+this.age);
}

};

var user2={
uname:'sreepad',
age:22,
displayUser:function(){
    console.log(this.uname+"-"+this.age);
}
};


var users=[];
users.push(user1,user2);

for (var i=0;i<users.length;i++ ){
    var user=users[i];
    user.displayUser();   
     
    
}
