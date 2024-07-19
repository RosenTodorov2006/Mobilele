package bg.soft_uni.mobilele.repositories;

import bg.soft_uni.mobilele.models.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OfferRepository extends JpaRepository<Offer, Long> {
}
