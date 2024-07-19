package bg.soft_uni.mobilele.services;

import bg.soft_uni.mobilele.models.dtos.AddOfferDto;
import bg.soft_uni.mobilele.models.dtos.OfferExportDto;

import java.util.List;

public interface OfferService {
    void addOffer(AddOfferDto addOfferDto);

    List<OfferExportDto> findAllOffers();

    OfferExportDto findOfferById(Long id);
}
