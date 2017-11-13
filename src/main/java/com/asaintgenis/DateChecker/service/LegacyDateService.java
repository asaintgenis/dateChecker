package com.asaintgenis.DateChecker.service;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class LegacyDateService {

    public Calendar checkAndParseDate(String pattern, String dateToParse) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            Date date = simpleDateFormat.parse(dateToParse);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar;
    }
}
