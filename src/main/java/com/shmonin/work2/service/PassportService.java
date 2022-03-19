package com.shmonin.work2.service;

import com.shmonin.work2.dto.PassportDto;
import com.shmonin.work2.model.Passport;
import org.springframework.stereotype.Service;

@Service
public class PassportService {

    public PassportDto toDto(Passport passport) {
        var passportDto = new PassportDto();
        passportDto.setSeries(passport.getSeries());
        passportDto.setNumber(passport.getNumber());
        passportDto.setDateOfIssue(passport.getDateOfIssue());
        return passportDto;
    }
}
