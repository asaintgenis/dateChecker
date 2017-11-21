package com.asaintgenis.DateChecker.model;

import javax.validation.constraints.NotEmpty;

public class DateRequest {

    @NotEmpty
    String pattern;

    @NotEmpty
    String dateToParse;

    public DateRequest() {}

    public DateRequest(String pattern, String dateToParse) {
        this.pattern = pattern;
        this.dateToParse = dateToParse;
    }

    public String getPattern() {
        return pattern;
    }

    public String getDateToParse() {
        return dateToParse;
    }
}
