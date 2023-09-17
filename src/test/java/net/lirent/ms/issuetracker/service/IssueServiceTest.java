package net.lirent.ms.issuetracker.service;
import net.lirent.ms.issuetracker.mapper.IssueMapper;
import net.lirent.ms.issuetracker.model.dto.IssueRest;
import net.lirent.ms.issuetracker.model.entity.Issue;
import net.lirent.ms.issuetracker.repository.IssueRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class IssueServiceTest {

    @InjectMocks
    private IssueServiceImpl issueService;
    @Mock
    private IssueRepository issueRepository;
    @Mock
    private IssueMapper issueMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void shouldFindIssueByIdSuccessful() {
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
    void shouldUpdateIssue() {
        Long issueId = 1L;
        IssueRest issueRest = new IssueRest();
        Issue issue = new Issue();

        when(issueRepository.findById(issueId)).thenReturn(Optional.of(issue));

        issueService.updateIssue(issueId, issueRest);

        verify(issueRepository, times(1)).findById(issueId);
    }

    @Test
    void shouldDeleteIssueById() {
        Long issueId = 1L;

        issueService.deleteIssueById(issueId);

        verify(issueRepository, times(1)).deleteById(issueId);
    }

    @Test
    void shouldFindAllIssues() {
        List<Issue> issueList = List.of(new Issue(), new Issue());
        List<IssueRest> issueRestList = List.of(new IssueRest(), new IssueRest());

        when(issueRepository.findAll()).thenReturn(issueList);
        when(issueMapper.entityToIssueRest(any(Issue.class))).thenReturn(issueRestList.get(0), issueRestList.get(1));

        List<IssueRest> result = issueService.findAllIssues();

        verify(issueRepository, times(1)).findAll();
        verify(issueMapper, times(2)).entityToIssueRest(any(Issue.class));
    }

    @Test
    void shouldCreateNewIssue() {
        IssueRest issueRest = new IssueRest();
        Issue savedIssue = new Issue();
        savedIssue.setIssueId(1L);

        when(issueMapper.issueRestToEntity(issueRest)).thenReturn(savedIssue);
        when(issueRepository.save(savedIssue)).thenReturn(savedIssue);

        IssueRest result = issueService.createNewIssue(issueRest);

        verify(issueMapper, times(1)).issueRestToEntity(issueRest);
        verify(issueRepository, times(1)).save(savedIssue);
    }
}