package com.dongyan.eCommerce.resource;

import com.dongyan.eCommerce.persistence.Customer;
import com.dongyan.eCommerce.persistence.Product;
import com.dongyan.eCommerce.service.CustomerService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "{Customer}")
public class CustomerResource {
    private CustomerService customerService;

    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping(value = "/customers")
    public List<Customer> getAll(){
        return this.customerService.getAll();
    }

    @GetMapping(value = "/customers/{id}")
    public Customer getbyId(@PathVariable Long id){
        return this.customerService.getById(id);
    }

    @PostMapping(value = "/customers", consumes = "application/json")
    public Customer add(@RequestBody Customer customer){
        return this.customerService.add(customer);
    }

    @PutMapping(value = "/customers/{id}")
    public Customer update(@PathVariable Long id, @RequestBody Customer customer){
        return this.customerService.update(id,customer);
    }

    @DeleteMapping(value = "/customers/{id}")
    public void delete(@PathVariable Long id){
        this.customerService.delete(id);
    }
}
