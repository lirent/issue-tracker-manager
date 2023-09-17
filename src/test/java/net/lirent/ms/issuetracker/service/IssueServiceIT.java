package net.lirent.ms.issuetracker.service;

import net.lirent.ms.issuetracker.mapper.IssueMapper;
import net.lirent.ms.issuetracker.model.dto.IssueRest;
import net.lirent.ms.issuetracker.model.entity.Issue;
import net.lirent.ms.issuetracker.repository.IssueRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class IssueServiceIT {
    @Autowired
    private IssueService issueService;

    @MockBean
    private IssueRepository issueRepository;

    @MockBean
    private IssueMapper issueMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testFindIssueById() {
        Long issueId = 1L;
        Issue issue = new Issue();
        IssueRest issueRest = new IssueRest();

        when(issueRepository.findById(issueId)).thenReturn(Optional.of(issue));
        when(issueMapper.entityToIssueRest(issue)).thenReturn(issueRest);

        Optional<IssueRest> result = issueService.findIssueById(issueId);

        verify(issueRepository, times(1)).findById(issueId);
        verify(issueMapper, times(1)).entityToIssueRest(issue);
        assertEquals(issueRest, result.get());
    }

    @Test
    void testUpdateIssue() {
        Long issueId = 1L;
        IssueRest issueRest = new IssueRest();
        Issue issue = new Issue();

        when(issueRepository.findById(issueId)).thenReturn(Optional.of(issue));

        issueService.updateIssue(issueId, issueRest);

        verify(issueRepository, times(1)).findById(issueId);
    }

    @Test
    void testDeleteIssueById() {
        Long issueId = 1L;

        issueService.deleteIssueById(issueId);

        verify(issueRepository, times(1)).deleteById(issueId);
    }

    @Test
    void testFindAllIssues() {
        List<Issue> issueList = List.of(new Issue(), new Issue());
        List<IssueRest> issueRestList = List.of(new IssueRest(), new IssueRest());

        when(issueRepository.findAll()).thenReturn(issueList);
        when(issueMapper.entityToIssueRest(any(Issue.class))).thenReturn(issueRestList.get(0), issueRestList.get(1));

        List<IssueRest> result = issueService.findAllIssues();

        verify(issueRepository, times(1)).findAll();
        verify(issueMapper, times(2)).entityToIssueRest(any(Issue.class));
        assertEquals(2, result.size());
    }

    @Test
    void testCreateNewIssue() {
        IssueRest issueRest = new IssueRest();
        Issue savedIssue = new Issue();
        savedIssue.setIssueId(1L);

        when(issueMapper.issueRestToEntity(issueRest)).thenReturn(savedIssue);
        when(issueRepository.save(savedIssue)).thenReturn(savedIssue);

        IssueRest result = issueService.createNewIssue(issueRest);

        verify(issueMapper, times(1)).issueRestToEntity(issueRest);
        verify(issueRepository, times(1)).save(savedIssue);
        assertEquals(issueRest, result);
    }
}