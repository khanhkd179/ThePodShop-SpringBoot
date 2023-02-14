package com.ecommercetest.service;

import com.ecommercetest.entity.Category;
import org.hibernate.sql.Update;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category save(Category category);
    Category findById(Long id);
    Category update(Category category);

}
