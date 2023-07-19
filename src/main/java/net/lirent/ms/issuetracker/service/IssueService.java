package net.lirent.ms.issuetracker.service;

import net.lirent.ms.issuetracker.model.dto.IssueRest;

import java.util.List;
import java.util.Optional;

/**
 * Exposed Service for Issue
 *
 * @author l.pone
 */

public interface IssueService {


    /**
     * Search the Issue data repository by the primary key
     * @param id Issue primary key
     * @return An Issue entity or null if not found
     */
    Optional<IssueRest> findIssueById(Long id);

    /**
     * Update an Issue entity in the data repository
     *
     * @param issueRest An issue entity to persist
     * @return The persisted issue
     */
    IssueRest updateIssue(Long issueId, IssueRest issueRest);

    /**
     * Delete an Issue entity from the data repository
     * @param id Issue primary key
     */
    void deleteIssueById(Long id);

    /**
     * Search for all Issue entities on the data repository
     * @return All issues from data repository
     */
    List<IssueRest> findAllIssues();

    /**
     * Create a new Issue in the data repository
     * @param issueRest Issue request
     * @return The persisted issue
     */
    IssueRest createNewIssue(IssueRest issueRest);
}
