package bg.soft_uni.mobilele.Services.Impl;

import bg.soft_uni.mobilele.Models.Dtos.AddOfferDto;
import bg.soft_uni.mobilele.Models.Dtos.OfferExportDto;
import bg.soft_uni.mobilele.Models.Entities.Offer;
import bg.soft_uni.mobilele.Repositories.ModelRepository;
import bg.soft_uni.mobilele.Repositories.OfferRepository;
import bg.soft_uni.mobilele.Services.OfferService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;
    private final ModelRepository modelRepository;


    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper, ModelRepository modelRepository) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.modelRepository = modelRepository;
    }

    @Override
    public void addOffer(AddOfferDto addOfferDto) {
        Offer map = modelMapper.map(addOfferDto, Offer.class);
        map.setImageUrl(addOfferDto.getUrl());
        map.setCreated(LocalDateTime.now());
        map.setCreated(LocalDateTime.now());
        map.setModified(LocalDateTime.now());
        map.setModel(modelRepository.findByName(addOfferDto.getModel()));
        this.offerRepository.saveAndFlush(map);
    }

    @Override
    public List<OfferExportDto> findAllOffers() {
        return this.offerRepository.findAll().stream()
                .map(offer->{
                    OfferExportDto map = modelMapper.map(offer, OfferExportDto.class);
                    map.setModel(offer.getModel().getName());
                    return map;
                }).collect(Collectors.toList());
    }

    @Override
    public OfferExportDto findOfferById(Long id) {
        OfferExportDto map = modelMapper.map(this.offerRepository.findById(id).get(), OfferExportDto.class);
        map.setModel(this.offerRepository.findById(id).get().getModel().getName());
        return map;
    }
}
