package bg.soft_uni.mobilele.services.impl;

import bg.soft_uni.mobilele.repositories.ModelRepository;
import bg.soft_uni.mobilele.services.ModelService;
import org.springframework.stereotype.Service;

@Service
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;

    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }
}
