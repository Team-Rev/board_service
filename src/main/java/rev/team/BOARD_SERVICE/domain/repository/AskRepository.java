package rev.team.BOARD_SERVICE.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rev.team.BOARD_SERVICE.domain.entity.Ask;

@Repository
public interface AskRepository extends JpaRepository<Ask, Long> {

}
