package bg.soft_uni.mobilele.Services.Impl;

import bg.soft_uni.mobilele.Models.Dtos.RegisterSeedDto;
import bg.soft_uni.mobilele.Models.Entities.User;
import bg.soft_uni.mobilele.Repositories.UserRepository;
import bg.soft_uni.mobilele.Services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void saveNewUser(RegisterSeedDto registerSeedDto) {
        User map = modelMapper.map(registerSeedDto, User.class);
        map.setCreated(LocalDateTime.now());
        this.userRepository.saveAndFlush(map);
    }

    @Override
    public boolean isNotValidEmail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    @Override
    public boolean isInvalidData(String email, String password) {
        return this.userRepository.findByEmailAndPassword(email, password).isEmpty();
    }
}
