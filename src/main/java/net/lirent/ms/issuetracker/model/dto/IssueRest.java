package net.lirent.ms.issuetracker.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(
            description = "The unique identifier for an issue",
            example = "1")
    private Long issueId;

    @Schema(
            description = "The title or summary of the issue",
            example = "Bug in the login page")
    private String title;

    @Schema(
            description = "A detailed description of the issue",
            example = "When I try to log in, I get an error message.")
    private String description;

    @Schema(
            description = "The name or identifier of the person who reported the issue",
            example = "John Doe")
    private String reporter;

    @Schema(
            description = "The type or category of the issue (e.g., bug, feature request)",
            example = "Bug")
    private IssueType type;

    @Schema(
            description = "The priority level of the issue (e.g., high, medium, low)",
            example = "High")
    private IssuePriority priority;

    @Schema(
            description = "The current status of the issue (e.g., open, in progress, resolved)",
            example = "Open")
    private IssueStatus status;

    @Schema(
            description = "The timestamp representing the date and time when the issue was created or last modified",
            example = "2023-09-14T10:30:00Z")
    private Timestamp timestamp;
}
