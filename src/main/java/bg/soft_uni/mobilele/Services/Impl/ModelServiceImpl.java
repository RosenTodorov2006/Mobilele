package bg.soft_uni.mobilele.Services.Impl;

import bg.soft_uni.mobilele.Repositories.ModelRepository;
import bg.soft_uni.mobilele.Services.ModelService;
import org.springframework.stereotype.Service;

@Service
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;

    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }
}
