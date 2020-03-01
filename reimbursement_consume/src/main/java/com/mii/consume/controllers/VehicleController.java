/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.consume.controllers;

import com.mii.consume.entities.Vehicle;
import com.mii.consume.services.VehicleService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author FIKRI-PC
 */
@RequestMapping(value="vehicle")
@Controller
public class VehicleController {
     @Autowired
    VehicleService service;
    
    @GetMapping("")
    public String getAll(Model model){
        model.addAttribute("vehicles",service.getAll()) ;
          return "vehicle";
    }
//    @RequestMapping
    @PostMapping("save")
    public String save(@Valid Vehicle vehicle){
    
        service.save(vehicle);
        return("redirect:/");
    }
    @GetMapping("/{id}")
    public String getById(Model model, @PathVariable("id") String id){
    
        model.addAttribute("vehicle",service.getById(id));
        model.addAttribute("vehicles",service.getAll());
        return "vehicle";
    }
  
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id){
    
        service.delete(id);
        return("redirect:/");
    }
  
}
