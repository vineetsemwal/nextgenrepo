/**
 * spread operator with object
 */
let user1={id:1, username:'aditya', age:21};
let user2={...user1,id:2};

console.log("user2=",user2.id,user2.username, user2.age);