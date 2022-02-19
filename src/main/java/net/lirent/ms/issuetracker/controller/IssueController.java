package net.lirent.ms.issuetracker.controller;

import net.lirent.ms.issuetracker.model.Issue;
import net.lirent.ms.issuetracker.service.IssueServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Controller for Issue API
 *
 * @author l.pone
 */

@RestController
@RequestMapping("/api/issue")
public class IssueController {

    @Autowired
    private IssueServiceImpl issueService;

    /**
     * Handles the incoming POST API "api/issue/{id}"
     * @param issue from RequestBody
     * @return ResponseEntity
     */
    @PostMapping
    public ResponseEntity<Issue> addIssue(@RequestBody Issue issue){
        return new ResponseEntity<>( issueService.addIssue(issue), HttpStatus.CREATED);
    }

    /**
     * Find issue from a given Id
     * @param id Issue Id
     * @return ResponseEntity
     */
    @GetMapping("/{id}")
    public ResponseEntity<Issue> findIssue(@PathVariable("id") long id) {
        Optional<Issue> issue = issueService.findIssue(id);
        if (!issue.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(issue.get(), HttpStatus.OK);
    }

    /**
     *  Update issue "/api/issue"
     * @param issue RequestBody
     * @return ResponseEntity
     */
    @PutMapping
    public ResponseEntity<Issue> updateIssue(@RequestBody Issue issue){
        return new ResponseEntity<>(issueService.updateIssue(issue), HttpStatus.OK);
    }

    /**
     * Delete issue from datastore "api/issue/{id}"
     * @param id Issue Id
     * @return ResponseEntity
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Issue> deleteIssue(@PathVariable("id") Long id){
        issueService.deleteIssue(id);
        //TODO not-found
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }

    /**
     * Get all issues from DB  "/api/issue"
     * @return all issues from datastore
     */
    @GetMapping
    public ResponseEntity<?> findAllIssues(){
        return new ResponseEntity<>(issueService.findAll(), HttpStatus.OK);
    }

}
