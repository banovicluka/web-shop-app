package com.luka.webshop.controllers;

import com.luka.webshop.models.dto.Attribute;
import com.luka.webshop.models.dto.Category;
import com.luka.webshop.services.AttributeService;
import com.luka.webshop.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/categories")
public class CategoryController {
    
    CategoryService service;
    AttributeService attributeService;

    public CategoryController(CategoryService service, AttributeService attributeService) {
        this.service = service;
        this.attributeService = attributeService;
    }

    @GetMapping
    public List<Category> findAll(){
        return service.findAll();
    }

    @GetMapping("/{categoryId}/attributes")
    public List<Attribute> getAllCategoryAttributes(@PathVariable Integer categoryId){
        return this.attributeService.getAllCategoryAttributes(categoryId);
    }
}
