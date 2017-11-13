package com.asaintgenis.DateChecker.controller;

import com.asaintgenis.DateChecker.model.DateRequest;
import com.asaintgenis.DateChecker.model.DateResponse;
import com.asaintgenis.DateChecker.service.DateService;
import com.asaintgenis.DateChecker.service.LegacyDateService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Calendar;

@RestController("/api")
public class DateController {

    private DateService dateService;
    private LegacyDateService legacyDateService;

    DateController(DateService dateService, LegacyDateService legacyDateService) {
        this.dateService = dateService;
        this.legacyDateService = legacyDateService;
    }

    @PostMapping("/date")
    public DateResponse getDate(@RequestBody DateRequest dateRequest) throws ParseException {
        LocalDate localDate = dateService.checkAndParseDate(dateRequest.getPattern(), dateRequest.getDateToParse());
        return new DateResponse(String.valueOf(localDate.getYear()),String.valueOf(localDate.getMonth()),String.valueOf(localDate.getDayOfMonth()));
    }

    @PostMapping("/legacyDate")
    public DateResponse getLegacyDate(@RequestBody DateRequest dateRequest) throws ParseException {
        Calendar date = legacyDateService.checkAndParseDate(dateRequest.getPattern(),dateRequest.getDateToParse());
        return new DateResponse(String.valueOf(date.get(Calendar.YEAR)),String.valueOf(date.get(Calendar.MONTH)),String.valueOf(date.get(Calendar.DAY_OF_MONTH)));
    }
}
