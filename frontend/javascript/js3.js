/*
array example
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

var users=[];
users.push(user1,user2);

for (var i=0;i<users.length;i++ ){
    var user=users[i];
    displayUser(user);
}
