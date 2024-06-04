package bg.soft_uni.mobilele.Repositories;

import bg.soft_uni.mobilele.Models.Entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
}
