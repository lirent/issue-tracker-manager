package net.lirent.ms.issuetracker.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum IssueType {

    BUG("Bug"),
    DOCUMENTATION("Documentation"),
    FEATURE("Feature"),
    QUESTION("Question"),
    TASK("Task");

    @JsonValue
    private final String value;

    @Override
    public String toString(){
        return value;
    }
}
