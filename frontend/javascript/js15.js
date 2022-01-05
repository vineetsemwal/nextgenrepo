/**
 * object destructuring
 */

let user={username:'karthik', age:22};

let username1=user.username;
let age1=user.age;

console.log("username",username1,"age1",age1);

let {username:username2,age:age2}=user;

let {username,age,id}=user;

console.log("username="+username+" age="+age);
console.log("username="+username2+" age2="+age2);