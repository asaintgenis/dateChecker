package com.asaintgenis.DateChecker.service;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class DateService {

    public LocalDate checkAndParseDate(String pattern, String dateToParse) throws ParseException {
        return LocalDate.parse(dateToParse, DateTimeFormatter.ofPattern(pattern));
    }
}
