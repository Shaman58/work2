package com.shmonin.work2.controller;

import com.shmonin.work2.dto.DepartmentDto;
import com.shmonin.work2.model.Department;
import com.shmonin.work2.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping("/departments")
    public List<DepartmentDto> findAll() {
        return departmentService.findAll();
    }

    @PostMapping("/department")
    public DepartmentDto save(@RequestBody Department department) {
        return departmentService.save(department);
    }

    @DeleteMapping("/department/{id}")
    public void remove(@PathVariable Long id) {
        departmentService.remove(id);
    }

    @PostMapping("/department/{departmentId}/add/{employeeId}")
    public DepartmentDto addEmployeeToDepartment(@PathVariable Long departmentId, @PathVariable Long employeeId) {
        return departmentService.addEmployeeToDepartment(departmentId, employeeId);
    }

    @PostMapping("/department/{departmentId}/delete/{employeeId}")
    public DepartmentDto deleteEmployeeFromDepartment(@PathVariable Long departmentId, @PathVariable Long employeeId) {
        return departmentService.deleteEmployeeToDepartment(departmentId, employeeId);
    }
}
