package net.lirent.ms.issuetracker.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Entity class for Issue tracker
 *
 * @author l.pone
 */

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Issue issue = (Issue) o;
        return id.equals(issue.id) && title.equals(issue.title) && description.equals(issue.description) && reporter.equals(issue.reporter) && type == issue.type && priority == issue.priority && status == issue.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, reporter, type, priority, status);
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", reporter='" + reporter + '\'' +
                ", type=" + type +
                ", priority=" + priority +
                ", status=" + status +
                ", timestamp=" + timestamp +
                '}';
    }
}
