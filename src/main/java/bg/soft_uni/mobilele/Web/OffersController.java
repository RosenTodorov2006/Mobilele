package bg.soft_uni.mobilele.Web;

import bg.soft_uni.mobilele.Models.Dtos.OfferExportDto;
import bg.soft_uni.mobilele.Models.Entities.Offer;
import bg.soft_uni.mobilele.Services.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OffersController {
    private final OfferService offerService;

    public OffersController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("offers/all")
    public String viewOffers(Model model){
        List<OfferExportDto> offers = offerService.findAllOffers();
        model.addAttribute("offers", offers);
        return "offers";
    }
    @GetMapping("offers/{id}")
    public String details(@PathVariable Long id, Model model){
        OfferExportDto offerExportDto = this.offerService.findOfferById(id);
        model.addAttribute("offer", offerExportDto);
        return "details";
    }

}
