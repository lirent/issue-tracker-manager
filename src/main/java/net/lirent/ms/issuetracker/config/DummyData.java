package net.lirent.ms.issuetracker.config;

import net.lirent.ms.issuetracker.model.Issue;
import net.lirent.ms.issuetracker.model.IssuePriority;
import net.lirent.ms.issuetracker.model.IssueStatus;
import net.lirent.ms.issuetracker.model.IssueType;
import net.lirent.ms.issuetracker.repository.IssueRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DummyData {

    @Bean
    CommandLineRunner initDatabase(IssueRepository repository){
        return args -> {
            repository.save(new Issue(null, "Load DB", "Load db script", "Lory", IssueType.TASK, IssuePriority.LOW, IssueStatus.OPEN, null));
            repository.save(new Issue(null, "Push DB", "Push db script", "Lory", IssueType.TASK, IssuePriority.LOW, IssueStatus.OPEN, null));

        };
    }
}
