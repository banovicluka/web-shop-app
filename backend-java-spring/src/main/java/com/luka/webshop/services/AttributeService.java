package com.luka.webshop.services;

import com.luka.webshop.exceptions.NotFoundException;
import com.luka.webshop.models.dto.Attribute;
import com.luka.webshop.models.dto.AttributeValue;

import java.util.List;

public interface AttributeService {

    List<Attribute> getAllCategoryAttributes(Integer categoryId);

    AttributeValue insertValue(AttributeValue attributeValue) throws NotFoundException;

    AttributeValue findAttributeValueById(Integer id) throws NotFoundException;
}
