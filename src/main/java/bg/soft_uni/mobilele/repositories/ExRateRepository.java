package bg.soft_uni.mobilele.repositories;

import bg.soft_uni.mobilele.models.entities.ExRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExRateRepository extends JpaRepository<ExRate, Long> {

}
