package com.shmonin.work2.service;

import com.shmonin.work2.dto.DepartmentDto;
import com.shmonin.work2.exception.EntityNotFoundException;
import com.shmonin.work2.model.Department;
import com.shmonin.work2.repository.DepartmentRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.lang.String.format;
import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final PersonService personService;

    public List<DepartmentDto> findAll() {
        return toDto(departmentRepository.findAll());
    }

    public DepartmentDto save(Department department) {
        var savedDepartment = departmentRepository.save(department);
        return toDto(savedDepartment);
    }

    public void remove(Long id) {
        findById(id);
        departmentRepository.deleteById(id);
    }

    public Department findById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(format("There is no person with id=%d in database", id)));
    }

    public DepartmentDto addEmployeeToDepartment(Long departmentId, Long employeeId) {
        var department = findById(departmentId);
        var employers = new HashSet<>(department.getEmployees());
        employers.add(personService.findById(employeeId));
        department.setEmployees(new ArrayList<>(employers));
        return toDto(departmentRepository.save(department));

    }

    public DepartmentDto deleteEmployeeToDepartment(Long departmentId, Long employeeId) {
        var department = findById(departmentId);
        var employers = new HashSet<>(department.getEmployees());
        employers.remove(personService.findById(employeeId));
        department.setEmployees(new ArrayList<>(employers));
        return toDto(departmentRepository.save(department));
    }

    public DepartmentDto toDto(Department department) {
        var departmentDto = new DepartmentDto();
        departmentDto.setName(department.getName());
        departmentDto.setEmployees(personService.toDto(department.getEmployees()));
        return departmentDto;
    }

    public List<DepartmentDto> toDto(List<Department> departments) {
        return departments.stream().map(this::toDto).collect(toList());
    }
}
