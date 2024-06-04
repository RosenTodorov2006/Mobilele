package bg.soft_uni.mobilele.Services.Impl;

import bg.soft_uni.mobilele.Models.Dtos.BrandExportDto;
import bg.soft_uni.mobilele.Models.Dtos.ModelDto;
import bg.soft_uni.mobilele.Models.Entities.Model;
import bg.soft_uni.mobilele.Repositories.BrandRepository;
import bg.soft_uni.mobilele.Services.BrandService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;

    public BrandServiceImpl(BrandRepository brandRepository, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public List<BrandExportDto> findAll() {
        List<BrandExportDto> collect = this.brandRepository.findAll()
                .stream()
                .map(brand -> {
                        BrandExportDto map = modelMapper.map(brand, BrandExportDto.class);
                            List<ModelDto> currentModelsDtos = brand.getModels().stream().map(model ->{
                                ModelDto map1 = modelMapper.map(model, ModelDto.class);
                                return map1;
                            }).collect(Collectors.toList());

                            map.setModelDtoList(currentModelsDtos);
                            return map;
                }).collect(Collectors.toList());
        return collect;
    }
}
