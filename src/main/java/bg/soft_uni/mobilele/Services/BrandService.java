package bg.soft_uni.mobilele.Services;

import bg.soft_uni.mobilele.Models.Dtos.BrandExportDto;

import java.util.List;

public interface BrandService {
    List<BrandExportDto> findAll();

}
