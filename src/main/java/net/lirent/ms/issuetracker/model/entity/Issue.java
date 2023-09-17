package net.lirent.ms.issuetracker.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import net.lirent.ms.issuetracker.model.enums.IssuePriority;
import net.lirent.ms.issuetracker.model.enums.IssueStatus;
import net.lirent.ms.issuetracker.model.enums.IssueType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import java.sql.Timestamp;

/**
 * Entity class for Issue tracker
 *
 * @author l.pone
 */

@Entity
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Issue {

    /**
     * The unique identifier for an issue.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long issueId;

    /**
     * The title or summary of the issue.
     */
    private String title;

    /**
     * A detailed description of the issue.
     */
    private String description;

    /**
     * The name or identifier of the person who reported the issue.
     */
    private String reporter;

    /**
     * The type or category of the issue (e.g., bug, feature request).
     */
    @Enumerated(EnumType.STRING)
    private IssueType type;

    /**
     * The priority level of the issue (e.g., high, medium, low).
     */
    @Enumerated(EnumType.STRING)
    private IssuePriority priority;

    /**
     * The current status of the issue (e.g., open, in progress, resolved).
     */
    @Enumerated(EnumType.STRING)
    private IssueStatus status;

    /**
     * The timestamp representing the date and time when the issue was created or last modified.
     */
    @Version
    private Timestamp timestamp;

}
