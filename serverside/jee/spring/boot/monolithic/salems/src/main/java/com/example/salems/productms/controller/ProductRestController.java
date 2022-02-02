package com.example.salems.productms.controller;

import com.example.salems.productms.dto.AddProductRequest;
import com.example.salems.productms.dto.BoughtProductDetails;
import com.example.salems.productms.dto.BuyProductRequest;
import com.example.salems.productms.dto.ProductDetails;
import com.example.salems.productms.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/products")
@RestController
public class ProductRestController {

    @Autowired
    private IProductService productService;

    @PostMapping("/add")
    public ProductDetails add(@RequestBody AddProductRequest request){
        return productService.add(request);
    }

    @GetMapping("/byid/{id}")
    public ProductDetails fetchProductById(@PathVariable long id) throws Exception{
        return productService.findProductDetailsById(id);
    }

    @PutMapping("/buy")
    public BoughtProductDetails buyProduct(@RequestBody BuyProductRequest request) throws Exception{
        return productService.buyProduct(request);
    }

}
