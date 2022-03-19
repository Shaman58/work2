package com.shmonin.work2.dto;

import com.shmonin.work2.model.Passport;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonDto {
    private String name;
    private String surname;
    private int age;
    private PassportDto passport;
}
