package com.dongyan.eCommerce.resource;

import com.dongyan.eCommerce.persistence.Orderitem;
import com.dongyan.eCommerce.service.OrderitemService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "{Orderitem}")
public class OrderitemResource {
    private OrderitemService orderitemService;

    public OrderitemResource(OrderitemService orderitemService) {
        this.orderitemService = orderitemService;
    }
    @GetMapping(value = "/orderitems")
    public List<Orderitem> getAll(){
        return this.orderitemService.getAll();
    }

    @GetMapping(value = "/orderitems/{id}")
    public Orderitem getbyId(@PathVariable Long id){
        return this.orderitemService.getById(id);
    }

    @PostMapping(value = "/orderitems", consumes = "application/json")
    public Orderitem add(@RequestBody Orderitem orderitem){
        return this.orderitemService.add(orderitem);
    }

    @PutMapping(value = "/orderitems/{id}")
    public Orderitem update( @PathVariable Long id, @RequestBody Orderitem orderitem){
        return this.orderitemService.update(id,orderitem);
    }

    @DeleteMapping(value = "/orderitems/{id}")
    public void delete(@PathVariable Long id){
        this.orderitemService.delete(id);
    }
}
