package bg.soft_uni.mobileleoffers.models.repo;

import bg.soft_uni.mobileleoffers.models.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, Long> {
}
