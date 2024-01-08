package com.luka.webshop.services.impl;

import com.luka.webshop.models.dto.Category;
import com.luka.webshop.repositories.CategoryEntityRepository;
import com.luka.webshop.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    ModelMapper modelMapper;

    CategoryEntityRepository repository;

    public CategoryServiceImpl(ModelMapper modelMapper, CategoryEntityRepository repository) {
        this.modelMapper = modelMapper;
        this.repository = repository;
    }

    @Override
    public List<Category> findAll(){
        return repository.findAll().stream().map(l-> modelMapper.map(l,Category.class)).collect(Collectors.toList());
    }
}
