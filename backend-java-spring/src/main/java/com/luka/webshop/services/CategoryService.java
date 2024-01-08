package com.luka.webshop.services;

import com.luka.webshop.models.dto.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
}
