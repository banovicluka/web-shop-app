package com.luka.webshop.repositories;

import com.luka.webshop.models.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryEntityRepository extends JpaRepository<CategoryEntity,Integer> {
}
