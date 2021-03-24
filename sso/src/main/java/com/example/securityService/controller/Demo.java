package com.example.securityService.controller;

import com.example.securityService.entity.Animal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/animal/acl/list")
public class Demo {
    @PostMapping
    public Animal creatAnimal(@Valid @RequestBody Animal animal){
          return animal;
    }
}
