package bg.soft_uni.mobilele.web;

import bg.soft_uni.mobilele.models.dtos.AddOfferDto;
import bg.soft_uni.mobilele.models.dtos.OfferExportDto;
import bg.soft_uni.mobilele.services.ExRateService;
import bg.soft_uni.mobilele.services.OfferService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
public class OffersController {
    private final ExRateService exRateService;
    private final OfferService offerService;

    public OffersController(ExRateService exRateService, OfferService offerService) {
        this.exRateService = exRateService;
        this.offerService = offerService;
    }

    @GetMapping("/offers/all")
    public String viewOffers(Model model){
        List<OfferExportDto> offers = offerService.findAllOffers();
        model.addAttribute("offers", offers);
        model.addAttribute("currencyNames", this.exRateService.getAllRatesNames());
        return "offers";
    }
    @GetMapping("/offers/add")
    public String newOffer(Model model){
        if(!model.containsAttribute("addOfferDto")) {
            model.addAttribute(new AddOfferDto());
        }
        return "offer-add";
    }
    @PostMapping("/offers/add")
    public String addOffer(@Valid AddOfferDto addOfferDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Principal principal){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addOfferDto", bindingResult);
            redirectAttributes.addFlashAttribute("addOfferDto", addOfferDto);
            return "redirect:/offers/add";
        }
        offerService.addOffer(addOfferDto, principal);
        return "redirect:/";
    }
    @GetMapping("/offers/{id}")
    public String details(@PathVariable Long id, Model model){
        OfferExportDto offerExportDto = this.offerService.findOfferById(id);
        model.addAttribute("offer", offerExportDto);
        return "details";
    }

}
