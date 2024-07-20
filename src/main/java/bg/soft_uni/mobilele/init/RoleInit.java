package bg.soft_uni.mobilele.init;

import bg.soft_uni.mobilele.models.entities.Role;
import bg.soft_uni.mobilele.models.entities.RolesName;
import bg.soft_uni.mobilele.repositories.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class RoleInit implements CommandLineRunner {
    private final RoleRepository roleRepository;

    public RoleInit(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(this.roleRepository.count()==0) {
            Arrays.stream(RolesName.values())
                    .forEach(r -> this.roleRepository.save(new Role(r)));
        }
    }
}
