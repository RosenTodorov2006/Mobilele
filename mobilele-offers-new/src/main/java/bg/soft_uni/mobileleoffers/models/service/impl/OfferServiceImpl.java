package bg.soft_uni.mobileleoffers.models.service.impl;
import bg.soft_uni.mobileleoffers.models.dto.AddOfferDto;
import bg.soft_uni.mobileleoffers.models.dto.OfferExportDto;
import bg.soft_uni.mobileleoffers.models.entity.Offer;
import bg.soft_uni.mobileleoffers.models.repo.OfferRepository;
import bg.soft_uni.mobileleoffers.models.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;


    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addOffer(AddOfferDto addOfferDto) {
        Offer map = new Offer();
        map.setImageUrl(addOfferDto.getUrl());
        map.setCreated(LocalDateTime.now());
        map.setModified(LocalDateTime.now());
        map.setModelId(addOfferDto.getModel());
        map.setEngine(addOfferDto.getEngine());
        map.setDescription(addOfferDto.getDescription());
        map.setPrice(addOfferDto.getPrice());
        map.setMileage(addOfferDto.getMileage());
        map.setUserId(addOfferDto.getUser());
        map.setTransmission(addOfferDto.getTransmission());
        map.setYear(addOfferDto.getYear());
        this.offerRepository.save(map);
    }

    @Override
    public List<OfferExportDto> findAllOffers() {
        return this.offerRepository.findAll().stream()
                .map(offer->{
                    OfferExportDto map = modelMapper.map(offer, OfferExportDto.class);
                    map.setModel(offer.getModelId());
                    return map;
                }).collect(Collectors.toList());
    }

    @Override
    public OfferExportDto findOfferById(Long id) {
        Offer offer = this.offerRepository.findById(id).get();
        OfferExportDto map = modelMapper.map(offer, OfferExportDto.class);
        map.setModel(offer.getModelId());
        return map;
    }
}
