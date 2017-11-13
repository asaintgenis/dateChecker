package com.asaintgenis.DateChecker.controller;

import com.asaintgenis.DateChecker.model.DateRequest;
import com.asaintgenis.DateChecker.model.DateResponse;
import com.asaintgenis.DateChecker.service.LegacyDateService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Calendar;

@RestController
public class LegacyDateController {

    private LegacyDateService legacyDateService;

    LegacyDateController(LegacyDateService legacyDateService) {
        this.legacyDateService = legacyDateService;
    }

    @PostMapping("/legacyDate")
    public DateResponse getLegacyDate(@RequestBody DateRequest dateRequest) throws ParseException {
        Calendar date = legacyDateService.checkAndParseDate(dateRequest.getPattern(),dateRequest.getDateToParse());
        return new DateResponse(String.valueOf(date.get(Calendar.YEAR)),String.valueOf(date.get(Calendar.MONTH)),String.valueOf(date.get(Calendar.DAY_OF_MONTH)));
    }
}
