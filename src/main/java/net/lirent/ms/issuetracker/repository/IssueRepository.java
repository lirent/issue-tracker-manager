package net.lirent.ms.issuetracker.repository;

import net.lirent.ms.issuetracker.model.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Issue tracker that extend a JpaRepository
 *
 * @author l.pone
 */

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {
}
