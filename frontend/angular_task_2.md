

Product{

  id: number
  name: string
  
  price : number

}


  ProductService{
   store:Product[]

   add(product:Product):Product // generate product id in this method (just increment a counter)

   findById(id:number):Product
   
   fetchAllProducts(): Product[] 
  

  }
  
  
  


Component to be created 

1) home component

    

    render all products link 
    
    fetch products from service  use ngFor structural directive to render link for different products
       
       Foreg. 
           
     /product/1
     
      /product/2
     
      /product/3

2) add-product
      
      Use Reactive Forms 
      
       name : min 3 letters, name should be of max 10 letters 
 
       price: should be greater than zero
      
      register products in store:Product[]


3) product-details
   
   
       Display details of product based on id in path/route  
       

