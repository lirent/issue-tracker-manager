package net.lirent.ms.issuetracker.model.dto;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import net.lirent.ms.issuetracker.model.enums.IssuePriority;
import net.lirent.ms.issuetracker.model.enums.IssueStatus;
import net.lirent.ms.issuetracker.model.enums.IssueType;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class IssueRest {

    private Long issueId;

    private String title;

    private String description;

    private String reporter;

    @JsonValue
    private IssueType type;

    @JsonValue
    private IssuePriority priority;

    @JsonValue
    private IssueStatus status;

    private Timestamp timestamp;
}
