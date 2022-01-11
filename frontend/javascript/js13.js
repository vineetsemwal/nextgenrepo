let product={pname:'samsung', pid:1};

let productName=product['pname'];
let id=product['pid'];
console.log("product name",productName+" id",id);

function getValue(obj, fieldName){
    let fieldValue= obj[fieldName];
    return fieldValue;
}

let pName=getValue(product,'pname');

console.log("product name",pName);
