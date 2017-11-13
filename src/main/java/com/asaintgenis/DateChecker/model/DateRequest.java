package com.asaintgenis.DateChecker.model;

public class DateRequest {
    String pattern;
    String dateToParse;

    public DateRequest() {}

    public DateRequest(String pattern, String dateToParse) {
        this.pattern = pattern;
        this.dateToParse = dateToParse;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getDateToParse() {
        return dateToParse;
    }

    public void setDateToParse(String dateToParse) {
        this.dateToParse = dateToParse;
    }
}
