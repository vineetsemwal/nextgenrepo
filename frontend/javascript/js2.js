/*
object example
*/
var user1={
uname:'remjith',
age:21
};

var user2={
uname:'sreepad',
age:22
};

function displayUser(user){

    console.log(user.uname +"-"+user.age);
}

displayUser(user1);
displayUser(user2);
