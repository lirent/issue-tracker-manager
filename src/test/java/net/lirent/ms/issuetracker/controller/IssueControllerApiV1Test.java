package net.lirent.ms.issuetracker.controller;

import net.lirent.ms.issuetracker.model.dto.IssueRest;
import net.lirent.ms.issuetracker.model.enums.IssueStatus;
import net.lirent.ms.issuetracker.model.enums.IssueType;
import net.lirent.ms.issuetracker.service.IssueService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class IssueControllerApiV1Test {

    private IssueControllerApiV1 issueController;

    @Mock
    private IssueService issueService; // Replace with your actual service interface

    @BeforeEach
    public void setUp() {
        issueController = new IssueControllerV1(issueService);
    }

    @Test
    void shouldFindIssueById_Success() {
        // Given
        Long issueId = 1L;
        IssueRest issueRest = getIssueRest(issueId);
        when(issueService.findIssueById(issueId)).thenReturn(Optional.of(issueRest));

        // When
        ResponseEntity<IssueRest> responseEntity = issueController.findIssueById(issueId);

        // Then
        verify(issueService, times(1)).findIssueById(issueId);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(issueRest, responseEntity.getBody());
    }

    @Test
    void shouldReturnNotFoundFindIssueById_WhenIssueNotFound() {
        // Given
        Long issueId = 999L;
        when(issueService.findIssueById(issueId)).thenReturn(Optional.empty());

        // When
        ResponseEntity<IssueRest> responseEntity = issueController.findIssueById(issueId);

        // Then
        verify(issueService, times(1)).findIssueById(issueId);
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    private static IssueRest getIssueRest(Long issueId) {
        return IssueRest.builder()
                .issueId(issueId)
                .description("text-description")
                .status(IssueStatus.OPEN)
                .type(IssueType.BUG)
                .reporter("bug-reporter")
                .title("text-title")
                .build();
    }
}