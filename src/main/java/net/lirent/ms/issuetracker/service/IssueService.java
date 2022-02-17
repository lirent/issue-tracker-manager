package net.lirent.ms.issuetracker.service;

import net.lirent.ms.issuetracker.model.Issue;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Exposed Service for Issue
 *
 * @author l.pone
 */

public interface IssueService {

    /**
     * Create a new Issue in the data repository
     * @param issue An issue entity to persist
     * @return The persisted issue
     */
    Issue addIssue(Issue issue);

    /**
     * Search the Issue data repository by the primary key
     * @param id Issue primary key
     * @return An Issue entity or null if not found
     */
    Issue findIssue(Long id);

    /**
     * Update an Issue entity in the data repository
     * @param issue  An issue entity to persist
     * @return The persisted issue
     */
    Issue updateIssue(Issue issue);

    /**
     * Delete an Issue entity from the data repository
     * @param id Issue primary key
     */
    void deleteIssue(Long id);

    /**
     * Search for all Issue entities on the data repository
     * @return All issues from data repository
     */
    List<Issue> findAll();
}
