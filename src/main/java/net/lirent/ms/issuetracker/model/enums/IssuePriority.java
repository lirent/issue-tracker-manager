package net.lirent.ms.issuetracker.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum IssuePriority {

    LOW("Low"),
    MEDIUM("Medium"),
    HIGH("High"),
    CRITICAL("Critical");

    private final String value;

    @Override
    public String toString(){
        return value;
    }
}
