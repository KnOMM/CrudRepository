package com.example.crudrepository.service;

import com.example.crudrepository.entity.Department;
import com.example.crudrepository.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;


    // save operation
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return (List<Department>) departmentRepository.findAll();
    }

    @Override
    public Department updateDepartment(Department department, Long departmentId) {

        if (departmentRepository.findById(departmentId).isPresent()) {
            Department depDB = departmentRepository.findById(departmentId).get();

            if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
                depDB.setDepartmentName(department.getDepartmentName());
            }

            if (Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
                depDB.setDepartmentAddress(department.getDepartmentAddress());
            }

            if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
                depDB.setDepartmentCode(department.getDepartmentCode());
            }
            return departmentRepository.save(depDB);
        }
        return null;
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }
}
