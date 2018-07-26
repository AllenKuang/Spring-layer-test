package com.springboot.employeeapiboot.one_to_one.controllers;

import com.springboot.employeeapiboot.one_to_one.entities.Klass;
import com.springboot.employeeapiboot.one_to_one.respositories.KlassRespository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/klasses")
public class KlassController {
    private KlassRespository klassRespository;

    public KlassController(KlassRespository klassRespository){
        this.klassRespository=klassRespository;
    }

    @GetMapping(path="")
    public List<Klass> getAllKlass(){
        return klassRespository.findAll();
    }
    @PostMapping(path="")
    public Klass addKlass(@RequestBody Klass klass){
        klass.getLeader().setKlass(klass);
        return klassRespository.save(klass);
    }
}
