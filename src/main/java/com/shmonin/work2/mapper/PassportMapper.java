package com.shmonin.work2.mapper;

import com.shmonin.work2.dto.PassportDto;
import com.shmonin.work2.model.Passport;
import org.springframework.stereotype.Component;

@Component
public class PassportMapper {

    public PassportDto toDto(Passport passport) {
        var passportDto = new PassportDto();
        passportDto.setSeries(passport.getSeries());
        passportDto.setNumber(passport.getNumber());
        passportDto.setDateOfIssue(passport.getDateOfIssue());
        return passportDto;
    }
}