package com.dongyan.eCommerce.service;

import com.dongyan.eCommerce.persistence.Product;
import com.dongyan.eCommerce.persistence.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> getAll(){
        return this.productRepository.findAll();
    }

    public Product getById(Long id){
        return this.productRepository.findById(id).get();
    }

    public Product add(Product product){
        return this.productRepository.save(product);
    }

    public Product update(Long id,Product product){
        Optional<Product> prod = this.productRepository.findById(id);
        if(prod.isPresent()){
            prod.get().setName(product.getName());
            prod.get().setPrice(product.getPrice());

            return this.productRepository.save(prod.get());
        }
        throw new RuntimeException();
    }

    public void delete(Long id){
        this.productRepository.deleteById(id);
    }
}
