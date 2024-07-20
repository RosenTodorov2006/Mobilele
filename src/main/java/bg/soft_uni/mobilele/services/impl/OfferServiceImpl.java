package bg.soft_uni.mobilele.services.impl;

import bg.soft_uni.mobilele.models.dtos.AddOfferDto;
import bg.soft_uni.mobilele.models.dtos.OfferExportDto;
import bg.soft_uni.mobilele.models.entities.Model;
import bg.soft_uni.mobilele.models.entities.ModelNames;
import bg.soft_uni.mobilele.models.entities.User;
import bg.soft_uni.mobilele.repositories.ModelRepository;
import bg.soft_uni.mobilele.repositories.UserRepository;
import bg.soft_uni.mobilele.services.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.security.Principal;
import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {
    private final ModelMapper modelMapper;
    private final ModelRepository modelRepository;
    private final RestClient offerRestClient;
    private final UserRepository userRepository;


    public OfferServiceImpl(ModelMapper modelMapper, ModelRepository modelRepository, @Qualifier("offersRestClient")  RestClient offerRestClient, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.modelRepository = modelRepository;
        this.offerRestClient = offerRestClient;
        this.userRepository = userRepository;
    }

    @Override
    public void addOffer(AddOfferDto addOfferDto, Principal principal) {
        Model byName = modelRepository.findByName(ModelNames.valueOf(addOfferDto.getModelName()));
        addOfferDto.setModel(byName.getId());
        User byEmail = this.userRepository.findByEmail(principal.getName()).get();
        addOfferDto.setUser(byEmail.getId());
        offerRestClient
                .post()
                .uri("/offers")
                .contentType(MediaType.APPLICATION_JSON)
                .body(addOfferDto)
                .retrieve();
    }

    @Override
    public List<OfferExportDto> findAllOffers() {
        return this.offerRestClient
                .get()
                .uri("/offers")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(new ParameterizedTypeReference<>(){});
    }

    @Override
    public OfferExportDto findOfferById(Long id) {
        return this.offerRestClient
                .get()
                .uri("/offers/"+id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(OfferExportDto.class);
    }
}
