package bg.soft_uni.mobilele.Services;

import bg.soft_uni.mobilele.Models.Dtos.AddOfferDto;
import bg.soft_uni.mobilele.Models.Dtos.OfferExportDto;

import java.util.List;

public interface OfferService {
    void addOffer(AddOfferDto addOfferDto);

    List<OfferExportDto> findAllOffers();

    OfferExportDto findOfferById(Long id);
}
