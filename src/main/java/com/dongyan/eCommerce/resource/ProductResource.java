package com.dongyan.eCommerce.resource;

import com.dongyan.eCommerce.persistence.Product;
import com.dongyan.eCommerce.service.ProductService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "{Product}")
public class ProductResource {
    private ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping(value = "/products")
    public List<Product> getAll(){
        return this.productService.getAll();
    }

    @GetMapping(value = "/products/{id}")
    public Product getbyId(@PathVariable Long id){
        return this.productService.getById(id);
    }

    @PostMapping(value = "/products", consumes = "application/json")
    public Product add(@RequestBody Product product){
        return this.productService.add(product);
    }

    @PutMapping(value = "/products/{id}")
    public Product update( @PathVariable Long id, @RequestBody Product product){
        return this.productService.update(id,product);
    }

    @DeleteMapping(value = "/products/{id}")
    public void delete(@PathVariable Long id){
        this.productService.delete(id);
    }
}
