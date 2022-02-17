package net.lirent.ms.issuetracker.service;

import net.lirent.ms.issuetracker.model.Issue;
import net.lirent.ms.issuetracker.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implemented Service for Issue
 *
 * @author l.pone
 */

@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    private IssueRepository issueRepository;

    @Override
    public Issue addIssue(Issue issue) {
        return issueRepository.save(issue);
    }

    @Override
    public Optional<Issue> findIssue(Long id) {
        return issueRepository.findById(id);
    }

    @Override
    public Issue updateIssue(Issue issue) {
        return issueRepository.save(issue);
    }

    @Override
    public void deleteIssue(Long id) {
        issueRepository.deleteById(id);
    }

    @Override
    public List<Issue> findAll() {
        return issueRepository.findAll();
    }
}
