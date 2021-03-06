package example.scrumboard.infrastructure.jpa.repositories;

import example.scrumboard.domain.sprint.Sprint;
import example.scrumboard.domain.sprint.SprintId;
import example.scrumboard.domain.sprint.SprintRepository;

@JpaRepository
public class JpaSprintRepository extends GenericJpaRepository<Sprint, SprintId> implements SprintRepository {
}
