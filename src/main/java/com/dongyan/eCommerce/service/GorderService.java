package com.dongyan.eCommerce.service;

import com.dongyan.eCommerce.persistence.Gorder;
import com.dongyan.eCommerce.persistence.GorderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GorderService {
    private GorderRepository gorderRepository;

    public GorderService(GorderRepository orderRepository) {
        this.gorderRepository = orderRepository;
    }

    public List<Gorder> getAll(){
        return this.gorderRepository.findAll();
    }

    public Gorder getById(Long id){
        return this.gorderRepository.findById(id).get();
    }

    public Gorder add(Gorder order){
        return this.gorderRepository.save(order);
    }

    public void delete(long id){
        this.gorderRepository.deleteById(id);
    }

}
