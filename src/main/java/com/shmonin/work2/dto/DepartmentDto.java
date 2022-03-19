package com.shmonin.work2.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class DepartmentDto {
    private String name;
    private List<PersonDto> employees;
}
