package com.ecommercetest.controller.admin;

import com.ecommercetest.entity.Category;
import com.ecommercetest.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class CategoryAdminController {
    @Autowired
    CategoryServiceImpl categoryService;
    @GetMapping("/categories")
    public String showCategories(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("newCategory", new Category());
        return "admin/categories";
    }

    @PostMapping("/add-category")
    public String add(@ModelAttribute("newCategory") Category category, RedirectAttributes redirectAttributes) {
        try {
            categoryService.save(category);
            redirectAttributes.addFlashAttribute("success","Added Successfully");
        } catch (Exception e){
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error","Add Unsuccessfully");
        }

        return "redirect:/admin/categories";
    }
    @GetMapping("/categories/{id}")
    public String editCategoryForm(@PathVariable("id") Long id, Model model){
        Category category=categoryService.findById(id);
        model.addAttribute("category",category);
        return "admin/category-form";
    }
    @PostMapping("/categories/save")
    public String saveEdit(Category category,RedirectAttributes redirectAttributes){
        try {
            categoryService.save(category);
            redirectAttributes.addFlashAttribute("success","Edit Successfully");
        } catch (Exception e){
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error","Edit Unsuccessfully");
        }

        return "redirect:/admin/categories";
    }
}
