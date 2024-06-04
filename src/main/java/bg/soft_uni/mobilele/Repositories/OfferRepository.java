package bg.soft_uni.mobilele.Repositories;

import bg.soft_uni.mobilele.Models.Entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, Long> {
}
