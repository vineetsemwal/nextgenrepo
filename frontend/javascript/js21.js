class Product{

    constructor(id,name){
        this.id=id;
        this.name=name;
    }

}


class Service{
    products=[new Product(1,'samsung'), new Product(2,'moto'),new Product(3,'lg')];

    fetchAllProducts(){
    let copy=[...this.products];
    return copy;     
}

}

class Frontend{

    service=new Service();

    displayTwoProducts(){
    let products= this.service.fetchAllProducts();
     products.splice(2,1);
     for(let product of products){
         console.log(product.id+"-"+product.name);
     }    
}

displayAllProducts(){
    let products= this.service.fetchAllProducts();
     for(let product of products){
         console.log(product.id+"-"+product.name);
     }    
}

}
const frontend=new Frontend();
console.log("***displaying only two ***")

frontend.displayTwoProducts();
console.log("***displaying all ***")
frontend.displayAllProducts();



