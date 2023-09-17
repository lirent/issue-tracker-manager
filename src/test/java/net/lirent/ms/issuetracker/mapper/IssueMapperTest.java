package net.lirent.ms.issuetracker.mapper;

import net.lirent.ms.issuetracker.model.dto.IssueRest;
import net.lirent.ms.issuetracker.model.entity.Issue;
import net.lirent.ms.issuetracker.model.enums.IssueStatus;
import net.lirent.ms.issuetracker.model.enums.IssueType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class IssueMapperTest {
    private static final String ISSUE_DESCRIPTION = "issue-description";
    private static final String BUG_REPORTER = "bug-reporter";
    private static final String ISSUE_TITLE = "issue-title";
    private IssueMapper issueMapper;

    @BeforeEach
    public void setUp() {
        issueMapper = Mappers.getMapper(IssueMapper.class);
    }

    @Test
    void testIssueRestToEntity() {
        // Given
        IssueRest issueRest = getIssueRest(1L);

        // When
        Issue issue = issueMapper.issueRestToEntity(issueRest);

        // Then
        assertNotNull(issue);
        assertEquals(issueRest.getDescription(), issue.getDescription());
        assertEquals(issueRest.getTitle(), issue.getTitle());
    }

    @Test
    void testEntityToIssueRest() {
        // Given
        Issue issue = getIssue();

        // When
        IssueRest issueRest = issueMapper.entityToIssueRest(issue);

        // Then
        assertNotNull(issueRest);
        assertEquals(ISSUE_DESCRIPTION, issueRest.getDescription());
        assertEquals(ISSUE_TITLE, issueRest.getTitle());
        assertEquals(IssueType.BUG, issueRest.getType());
    }

    private static IssueRest getIssueRest(Long issueId) {
        return IssueRest.builder()
                .issueId(issueId)
                .description(ISSUE_DESCRIPTION)
                .status(IssueStatus.OPEN)
                .type(IssueType.BUG)
                .reporter(BUG_REPORTER)
                .title(ISSUE_TITLE)
                .build();
    }

    private static Issue getIssue() {
        return Issue.builder()
                .description(ISSUE_DESCRIPTION)
                .status(IssueStatus.OPEN)
                .type(IssueType.BUG)
                .reporter(BUG_REPORTER)
                .title(ISSUE_TITLE)
                .build();
    }
}