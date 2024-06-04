package bg.soft_uni.mobilele.Repositories;

import bg.soft_uni.mobilele.Models.Entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long> {
    Model findByName(String model);
}
