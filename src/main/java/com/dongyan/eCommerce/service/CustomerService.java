package com.dongyan.eCommerce.service;

import com.dongyan.eCommerce.persistence.Customer;
import com.dongyan.eCommerce.persistence.CustomerRepository;
import com.dongyan.eCommerce.persistence.Product;
import com.dongyan.eCommerce.persistence.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAll(){
        return this.customerRepository.findAll();
    }

    public Customer getById(Long id){
        return this.customerRepository.findById(id).get();
    }

    public Customer add(Customer customer){
        return this.customerRepository.save(customer);
    }

    public Customer update(Long id,Customer customer){
        Optional<Customer> cust = this.customerRepository.findById(id);
        if(cust.isPresent()){
            cust.get().setName(customer.getName());
            cust.get().setEmail(customer.getEmail());

            return this.customerRepository.save(cust.get());
        }
        throw new RuntimeException();
    }

    public void delete(Long id){
        this.customerRepository.deleteById(id);
    }
}
