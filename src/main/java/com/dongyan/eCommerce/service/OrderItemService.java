package com.dongyan.eCommerce.service;

import com.dongyan.eCommerce.persistence.Orderitem;
import com.dongyan.eCommerce.persistence.OrderitemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderitemService {
    private OrderitemRepository orderitemRepository;

    public OrderitemService(OrderitemRepository orderitemRepository) {
        this.orderitemRepository = orderitemRepository;
    }
    public List<Orderitem> getAll(){
        return this.orderitemRepository.findAll();
    }

    public Orderitem getById(Long id){
        return this.orderitemRepository.findById(id).get();
    }

    public Orderitem add(Orderitem orderitem){
        return this.orderitemRepository.save(orderitem);
    }

    public Orderitem update(Long id,Orderitem orderitem){
        Optional<Orderitem> item = this.orderitemRepository.findById(id);
        if(item.isPresent()){
            item.get().setOdid(orderitem.getOdid());
            item.get().setPid(orderitem.getPid());
            item.get().setQuantity(orderitem.getQuantity());

            return this.orderitemRepository.save(item.get());
        }
        throw new RuntimeException();
    }

    public void delete(Long id){
        this.orderitemRepository.deleteById(id);
    }
}
