package bg.soft_uni.mobilele.repositories;

import bg.soft_uni.mobilele.models.entities.Role;
import bg.soft_uni.mobilele.models.entities.RolesName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(RolesName name);
}
