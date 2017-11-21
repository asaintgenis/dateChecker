package com.asaintgenis.DateChecker.controller;

import com.asaintgenis.DateChecker.model.DateRequest;
import com.asaintgenis.DateChecker.model.DateResponse;
import com.asaintgenis.DateChecker.service.DateService;
import com.asaintgenis.DateChecker.service.LegacyDateService;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Calendar;

@RestController
@RequestMapping("/api")
public class DateController {

    private DateService dateService;
    private LegacyDateService legacyDateService;

    DateController(DateService dateService, LegacyDateService legacyDateService) {
        this.dateService = dateService;
        this.legacyDateService = legacyDateService;
    }

    @PostMapping("/date")
    public Resource<DateResponse> getDate(@Valid @RequestBody DateRequest dateRequest) throws ParseException {
        LocalDate localDate = dateService.checkAndParseDate(dateRequest.getPattern(), dateRequest.getDateToParse());
        DateResponse dateResponse = new DateResponse(String.valueOf(localDate.getYear()),String.valueOf(localDate.getMonth()),String.valueOf(localDate.getDayOfMonth()));

        Resource<DateResponse> resource = new Resource<>(dateResponse);
        ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getLegacyDate(dateRequest));
        resource.add(linkTo.withRel("legacy-date"));

        return resource;
    }

    @PostMapping("/legacyDate")
    public Resource<DateResponse> getLegacyDate(@Valid @RequestBody DateRequest dateRequest) throws ParseException {
        Calendar date = legacyDateService.checkAndParseDate(dateRequest.getPattern(),dateRequest.getDateToParse());
        DateResponse dateResponse = new DateResponse(String.valueOf(date.get(Calendar.YEAR)),String.valueOf(date.get(Calendar.MONTH)),String.valueOf(date.get(Calendar.DAY_OF_MONTH)));

        Resource<DateResponse> resource = new Resource<>(dateResponse);
        ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getDate(dateRequest));
        resource.add(linkTo.withRel("java8-date"));

        return resource;
    }
}
