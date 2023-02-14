package com.ecommercetest.controller.admin;

import com.ecommercetest.entity.Category;
import com.ecommercetest.repository.CategoryRepository;
import com.ecommercetest.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    CategoryServiceImpl categoryService;

    @GetMapping()
    public String showHomePage() {
        return "admin/admin";
    }


}
