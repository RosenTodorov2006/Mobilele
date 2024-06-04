package bg.soft_uni.mobilele.Web;

import bg.soft_uni.mobilele.Models.Dtos.RegisterSeedDto;
import bg.soft_uni.mobilele.Models.Dtos.LoginDto;
import bg.soft_uni.mobilele.Services.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/register")
    public String register(Model model){
        if(!model.containsAttribute("registerSeedDto")){
            model.addAttribute(new RegisterSeedDto());
        }
        return "auth-register";
    }

    @PostMapping("/users/register")
    public String namesSubmit(@Valid RegisterSeedDto registerSeedDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors() || userService.isNotValidEmail(registerSeedDto.getEmail())){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerSeedDto", bindingResult);
            redirectAttributes.addFlashAttribute("registerSeedDto", registerSeedDto);
            return "redirect:/users/register";
        }else{
            userService.saveNewUser(registerSeedDto);
            return "redirect:/users/login";
        }
    }

    @GetMapping("/users/login")
    public String login(Model model){
        if(!model.containsAttribute("loginDto")){
            model.addAttribute(new LoginDto());
        }
        return "auth-login";
    }
    @PostMapping("/users/login")
    public String loginIfRegisterIsValid(@Valid LoginDto loginDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors() || this.userService.isInvalidData(loginDto.getEmail(), loginDto.getPassword())) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginDto", bindingResult);
            redirectAttributes.addFlashAttribute("loginDto", loginDto);
            return "redirect:/users/login";
        }
        return "redirect:/";
    }
}
