package net.lirent.ms.issuetracker.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Entity class for Issue tracker
 *
 * @author l.pone
 */


@Entity
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String reporter;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    private Status status;

    private Timestamp timestamp;

    //TODO refactor on separate class all enums
    public enum Type{
        BUG,
        DOCUMENTATION,
        FEATURE,
        QUESTION,
        TASK
    }
    public enum Priority{
        LOW,
        MEDIUM,
        HIGH,
        CRITICAL,
        NONE
    }
    public enum Status{
        OPEN,
        CLOSE,
        TO_DO,
        IN_PROGRESS,
        RELEASED
    }
}
