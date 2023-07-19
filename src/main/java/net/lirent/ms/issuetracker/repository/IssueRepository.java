package net.lirent.ms.issuetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.lirent.ms.issuetracker.model.entity.Issue;

/**
 * Repository interface for Issue tracker that extend a JpaRepository
 *
 * @author l.pone
 */

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {
}
