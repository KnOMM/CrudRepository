package com.example.crudrepository.controller;

import com.example.crudrepository.entity.Department;
import com.example.crudrepository.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
//@Controller
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired private DepartmentService departmentService;

    @PostMapping()
    public Department saveDepartment(@Valid @RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }


// with thymeleaf
//    @GetMapping
//    public String fetchDepartmentList(Model model) {
//        model.addAttribute("listOfEntries", departmentService.fetchDepartmentList());
//        return "index";
//    }

    @GetMapping
    public List<Department> fetchDepartmentList() {
        return departmentService.fetchDepartmentList();
    }

    @PutMapping("/update/{id}")
    public Department updateDepartmentById(@RequestBody Department department, @PathVariable Long id){
        return departmentService.updateDepartment(department, id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable Long id){
        departmentService.deleteDepartmentById(id);
        return "Deleted successfully!";
    }
}
