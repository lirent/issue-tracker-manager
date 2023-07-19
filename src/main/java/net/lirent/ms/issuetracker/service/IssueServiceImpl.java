package net.lirent.ms.issuetracker.service;

import lombok.RequiredArgsConstructor;
import net.lirent.ms.issuetracker.mapper.IssueMapper;
import net.lirent.ms.issuetracker.model.dto.IssueRest;
import net.lirent.ms.issuetracker.model.entity.Issue;
import net.lirent.ms.issuetracker.repository.IssueRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

/**
 * Implemented Service for Issue
 *
 * @author l.pone
 */

@Service
@RequiredArgsConstructor
public class IssueServiceImpl implements IssueService {

    private final IssueRepository issueRepository;
    private final IssueMapper issueMapper;

    @Override
    public Optional<IssueRest> findIssueById(Long issueId) {
        return issueRepository.findById(issueId).map(issueMapper::entityToIssueRest);
    }

    @Override
    public IssueRest updateIssue(Long issueId, IssueRest issueRest) {
        Issue issue = issueRepository.findById(issueId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Issue with id: %s not found".formatted(issueId)
                ));
        issue.setDescription(issueRest.getDescription());
        issue.setPriority(issueRest.getPriority());
        issue.setStatus(issueRest.getStatus());
        issue.setTitle(issueRest.getTitle());
        issue.setReporter(issueRest.getReporter());
        issue.setType(issueRest.getType());
        issueRepository.save(issue);
        return issueRest;
    }

    @Override
    public void deleteIssueById(Long id) {
        issueRepository.deleteById(id);
    }

    @Override
    public List<IssueRest> findAllIssues() {
        return issueRepository.findAll().stream().map(issueMapper::entityToIssueRest).toList();
    }

    @Override
    public IssueRest createNewIssue(IssueRest issueRest) {
        Issue saved = issueRepository.save(issueMapper.issueRestToEntity(issueRest));
        issueRest.setIssueId(saved.getIssueId());
        return issueRest;
    }
}
