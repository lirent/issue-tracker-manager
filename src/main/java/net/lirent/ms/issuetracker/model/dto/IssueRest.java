package net.lirent.ms.issuetracker.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.lirent.ms.issuetracker.model.enums.IssuePriority;
import net.lirent.ms.issuetracker.model.enums.IssueStatus;
import net.lirent.ms.issuetracker.model.enums.IssueType;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IssueRest {

    private Long issueId;

    private String title;

    private String description;

    private String reporter;

    private IssueType type;

    private IssuePriority priority;

    private IssueStatus status;

    private Timestamp timestamp;
}
