package bg.soft_uni.mobilele.init;

import bg.soft_uni.mobilele.models.entities.Model;
import bg.soft_uni.mobilele.models.entities.ModelNames;
import bg.soft_uni.mobilele.repositories.ModelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ModelsInit implements CommandLineRunner {
    private final ModelRepository modelRepository;

    public ModelsInit(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(this.modelRepository.count()==0) {
            Arrays.stream(ModelNames.values())
                    .forEach(m -> this.modelRepository.save(new Model(m)));
        }
    }
}
