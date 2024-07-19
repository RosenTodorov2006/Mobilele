package bg.soft_uni.mobilele.service;

import bg.soft_uni.mobilele.models.dtos.AddOfferDto;
import bg.soft_uni.mobilele.models.dtos.OfferExportDto;
import bg.soft_uni.mobilele.models.entities.Model;
import bg.soft_uni.mobilele.models.entities.Offer;
import bg.soft_uni.mobilele.repositories.ModelRepository;
import bg.soft_uni.mobilele.repositories.OfferRepository;
import bg.soft_uni.mobilele.services.impl.OfferServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class OfferServiceImpTest {
    @Mock
    private OfferRepository offerRepository;
    @Mock
    private ModelMapper modelMapper;
    @Mock
    private ModelRepository modelRepository;
    private OfferServiceImpl offerService;
    @BeforeEach
    public void setUp(){
        offerService = new OfferServiceImpl(offerRepository, modelMapper, modelRepository);
    }
    @Test
    public void findOfferByIdTest(){
        Offer testOffer = new Offer();
        Model testModel = new Model();
        testModel.setName("testModel");
        testOffer.setModel(testModel);
        OfferExportDto offerExportDto = new OfferExportDto();
        offerExportDto.setModel(testModel.getName());
        offerExportDto.setEngine("engine");

        Mockito.when(offerRepository.findById(1L))
                .thenReturn((Optional.of(testOffer)));
        Mockito.when(modelMapper.map(testOffer, OfferExportDto.class))
                .thenReturn(offerExportDto);

        OfferExportDto offerById = this.offerService.findOfferById(1L);

        Assertions.assertEquals(offerById.getModel(), testModel.getName());
        Assertions.assertEquals(offerById.getEngine(), offerExportDto.getEngine());
    }
}
