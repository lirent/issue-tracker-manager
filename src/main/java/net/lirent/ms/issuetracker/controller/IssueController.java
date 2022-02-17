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

    @PostMapping
    public ResponseEntity<Issue> addIssue(@RequestBody Issue issue){
        return new ResponseEntity<>( issueService.addIssue(issue), HttpStatus.CREATED);
    }

    @GetMapping("/{id}") //api/issue/{id}
    public ResponseEntity<Issue> findIssue(@PathVariable("id") long id) {
        Optional<Issue> issue = issueService.findIssue(id);
        if (!issue.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(issue.get(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Issue> updateIssue(@RequestBody Issue issue){
        return new ResponseEntity<>(issueService.updateIssue(issue), HttpStatus.OK);
    }

    @DeleteMapping("/{id}") //api/issue/{id}
    public ResponseEntity<Issue> deleteIssue(@PathVariable("id") Long id){
        issueService.deleteIssue(id);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<?> findAllIssues(){
        return new ResponseEntity<>(issueService.findAll(), HttpStatus.OK);
    }

}
