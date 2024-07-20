package bg.soft_uni.mobileleoffers.models.service;
import bg.soft_uni.mobileleoffers.models.dto.AddOfferDto;
import bg.soft_uni.mobileleoffers.models.dto.OfferExportDto;

import java.util.List;

public interface OfferService {
    void addOffer(AddOfferDto addOfferDto);

    List<OfferExportDto> findAllOffers();

    OfferExportDto findOfferById(Long id);
}
