package net.lirent.ms.issuetracker.controller;

import lombok.val;
import net.lirent.ms.issuetracker.model.Issue;
import net.lirent.ms.issuetracker.service.IssueServiceImpl;
import net.lirent.ms.issuetracker.util.Utils;
import org.springframework.beans.BeanUtils;
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
@RequestMapping("/api/issues")
public class IssueController {

    @Autowired
    private IssueServiceImpl issueService;

    /**
     * Handles the incoming POST API "api/issues/"
     * @param issue from RequestBody
     * @return ResponseEntity
     */
    @PostMapping
    public ResponseEntity<Issue> addIssue(@RequestBody Issue issue){
        return new ResponseEntity<>( issueService.addIssue(issue), HttpStatus.CREATED);
    }

    /**
     * Find issue from a given id "api/issues/{id}"
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
        //return issue.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Update issue from a given id "api/issues/{id}"
     * @param issue Issue
     * @param id issue id from path
     * @return ResponseEntity
     */
    @PutMapping("/{id}")
    public ResponseEntity<Issue> updateIssue(@RequestBody Issue issue, @PathVariable("id") Long id){
        var issueData = issueService.findIssue(id);
        if(!issueData.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        val issueUpdated = issueData.get();
        val ignoredFields = Utils.getNullPropertyNames(issue);
        BeanUtils.copyProperties(issue, issueUpdated, ignoredFields);

        return new ResponseEntity<>( issueService.updateIssue(issueUpdated), HttpStatus.OK);
    }

    /**
     * Delete issue from datastore "api/issues/{id}"
     * @param id Issue Id
     * @return ResponseEntity
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Issue> deleteIssue(@PathVariable("id") Long id){
        //issue not-found
        if(!issueService.findIssue(id).isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        issueService.deleteIssue(id);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }

    /**
     * Get all issues from DB  "/api/issues"
     * @return all issues from datastore
     */
    @GetMapping
    public ResponseEntity<?> findAllIssues(){
        return new ResponseEntity<>(issueService.findAll(), HttpStatus.OK);
    }

}
