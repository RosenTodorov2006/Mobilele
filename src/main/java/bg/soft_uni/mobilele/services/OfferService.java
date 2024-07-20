package bg.soft_uni.mobilele.services;

import bg.soft_uni.mobilele.models.dtos.AddOfferDto;
import bg.soft_uni.mobilele.models.dtos.OfferExportDto;

import java.security.Principal;
import java.util.List;

public interface OfferService {
    void addOffer(AddOfferDto addOfferDto, Principal principal);

    List<OfferExportDto> findAllOffers();

    OfferExportDto findOfferById(Long id);
}
