package net.lirent.ms.issuetracker.model.entity;

import lombok.*;
import net.lirent.ms.issuetracker.model.enums.IssuePriority;
import net.lirent.ms.issuetracker.model.enums.IssueStatus;
import net.lirent.ms.issuetracker.model.enums.IssueType;

import javax.persistence.*;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long issueId;

    private String title;

    private String description;

    private String reporter;

    @Enumerated(EnumType.STRING)
    private IssueType type;

    @Enumerated(EnumType.STRING)
    private IssuePriority priority;

    @Enumerated(EnumType.STRING)
    private IssueStatus status;

    @Version
    private Timestamp timestamp;

}
