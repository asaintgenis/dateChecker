package com.asaintgenis.DateChecker.controller;

import com.asaintgenis.DateChecker.model.DateRequest;
import com.asaintgenis.DateChecker.model.DateResponse;
import com.asaintgenis.DateChecker.service.DateService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.time.LocalDate;

@RestController
public class DateController {

    private DateService dateService;

    DateController(DateService dateService) {
        this.dateService = dateService;
    }

    @PostMapping("/date")
    public DateResponse getLegacyDate(@RequestBody DateRequest dateRequest) throws ParseException {
        LocalDate localDate = dateService.checkAndParseDate(dateRequest.getPattern(), dateRequest.getDateToParse());
        return new DateResponse(String.valueOf(localDate.getYear()),String.valueOf(localDate.getMonth()),String.valueOf(localDate.getDayOfMonth()));
    }
}
