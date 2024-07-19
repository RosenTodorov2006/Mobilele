package bg.soft_uni.mobilele.services;

import bg.soft_uni.mobilele.models.dtos.RegisterSeedDto;

public interface UserService {
    void saveNewUser(RegisterSeedDto registerSeedDto);

    boolean isNotValidEmail(String email);


}
