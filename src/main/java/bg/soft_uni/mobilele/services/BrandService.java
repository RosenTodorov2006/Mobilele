package bg.soft_uni.mobilele.services;

import bg.soft_uni.mobilele.models.dtos.BrandExportDto;

import java.util.List;

public interface BrandService {
    List<BrandExportDto> findAll();

}
