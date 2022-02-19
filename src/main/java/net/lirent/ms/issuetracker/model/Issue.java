package net.lirent.ms.issuetracker.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Entity class for Issue tracker
 *
 * @author l.pone
 */

//TODO overwrite equals and toString
@Entity
@Data
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
    private Status status;

    @Version
    private Timestamp timestamp;

    //TODO refactor on separate class all enums
    public enum Status{
        OPEN
        ,CLOSE
       // ,TO_DO
       // ,IN_PROGRESS
       // ,RELEASED
    }
}
