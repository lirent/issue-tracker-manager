package net.lirent.ms.issuetracker.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum IssueStatus {
    OPEN("Open"),
    CLOSE("Close"),
    TODO("Todo");
    // ,IN_PROGRESS
    // ,RELEASED

    private final String value;

    @Override
    public String toString(){
        return value;
    }
}
