package com.shmonin.work2.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class PassportDto {

    private String series;
    private String number;
    private LocalDate dateOfIssue;
}
