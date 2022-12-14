package com.dongyan.eCommerce.resource;

import com.dongyan.eCommerce.persistence.Gorder;
import com.dongyan.eCommerce.service.GorderService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "{Order}")
public class GorderResource {
    private GorderService gorderService;

    public GorderResource(GorderService gorderService) {
        this.gorderService = gorderService;
    }
    @GetMapping(value = "/orders")
    public List<Gorder> getAll(){
        return this.gorderService.getAll();
    }
    @GetMapping(value = "/orders/{id}")
    public Gorder getbyId(@PathVariable Long id){
        return this.gorderService.getById(id);
    }
    @PostMapping(value = "/orders", consumes = "application/json")
    public Gorder add(@RequestBody Gorder gorder){
        return this.gorderService.add(gorder);
    }

    @DeleteMapping(value = "/orders/{id}")
    public void delete(@PathVariable Long id){
        this.gorderService.delete(id);
    }
}
