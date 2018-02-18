package com.asaintgenis.DateChecker.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

@ApiModel(description = "The request send a pattern and the date to parse")
public class DateRequest {

    @NotEmpty
    @ApiModelProperty(notes = "the pattern should be a valid java date format")
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
