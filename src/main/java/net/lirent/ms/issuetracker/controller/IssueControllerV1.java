package net.lirent.ms.issuetracker.controller;

import lombok.RequiredArgsConstructor;
import net.lirent.ms.issuetracker.model.dto.IssueRest;
import net.lirent.ms.issuetracker.service.IssueServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for Issue API
 *
 * @author l.pone
 */

 @RestController
 @RequiredArgsConstructor
public class IssueControllerV1 implements IssueControllerApiV1{

    private final IssueServiceImpl issueService;

    @Override
    public ResponseEntity<IssueRest> findIssueById(Long issueId) {
        return ResponseEntity.of(issueService.findIssueById(issueId));
    }

    @Override
    public ResponseEntity<Void> deleteIssueById(Long issueId) {
        issueService.deleteIssueById(issueId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @Override
    public ResponseEntity<List<IssueRest>> findAllIssues() {
        return ResponseEntity.ok(issueService.findAllIssues());
    }

    @Override
    public ResponseEntity<IssueRest> updateIssueById(Long issueId, IssueRest issueRest) {
        issueService.updateIssue(issueId, issueRest);
        return ResponseEntity.status(HttpStatus.OK).body(issueRest);
    }

    @Override
    public ResponseEntity<IssueRest> createNewIssue(@RequestBody IssueRest issueRest){

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(issueService.createNewIssue(issueRest));
    }

}
