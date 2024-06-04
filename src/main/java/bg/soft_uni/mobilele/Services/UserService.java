package bg.soft_uni.mobilele.Services;

import bg.soft_uni.mobilele.Models.Dtos.RegisterSeedDto;

public interface UserService {
    void saveNewUser(RegisterSeedDto registerSeedDto);

    boolean isNotValidEmail(String email);

    boolean isInvalidData(String email, String password);
}
