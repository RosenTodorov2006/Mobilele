package bg.soft_uni.mobilele.repositories;

import bg.soft_uni.mobilele.models.entities.Model;
import bg.soft_uni.mobilele.models.entities.ModelNames;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long> {
    Model findByName(@NotNull ModelNames name);
}
