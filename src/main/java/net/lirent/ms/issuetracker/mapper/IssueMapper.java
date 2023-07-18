package net.lirent.ms.issuetracker.mapper;

import net.lirent.ms.issuetracker.model.dto.IssueRest;
import net.lirent.ms.issuetracker.model.entity.Issue;
import org.mapstruct.Mapper;

@Mapper
public interface IssueMapper {

    Issue issueRestToEntity(IssueRest issueRest);
    IssueRest entityToIssueRest(Issue issue);
}
