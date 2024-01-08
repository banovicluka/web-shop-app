package com.luka.webshop.controllers;

import com.luka.webshop.exceptions.NotFoundException;
import com.luka.webshop.models.dto.AttributeValue;
import com.luka.webshop.services.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/attributes")
public class AttributeController {

    @Autowired
    private AttributeService attributeService;

    @PostMapping("/values")
    @ResponseStatus(HttpStatus.CREATED)
    public AttributeValue insertAttributeValue(@RequestBody AttributeValue attributeValue) throws NotFoundException {
        return this.attributeService.insertValue(attributeValue);

    }
}
