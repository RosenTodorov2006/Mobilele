package bg.soft_uni.mobileleoffers.web;

import bg.soft_uni.mobileleoffers.models.dto.AddOfferDto;
import bg.soft_uni.mobileleoffers.models.dto.OfferExportDto;
import bg.soft_uni.mobileleoffers.models.service.OfferService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@RequestMapping("/offers")
public class OffersController {

    private final OfferService offerService;

    public OffersController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping
    public ResponseEntity<List<OfferExportDto>> viewOffers(Model model){
        return ResponseEntity.ok(this.offerService.findAllOffers());
    }
    @PostMapping
    public ResponseEntity<AddOfferDto> createOffer(@RequestBody AddOfferDto addOfferDto) {
        this.offerService.addOffer(addOfferDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OfferExportDto> details(@PathVariable Long id, Model model){
        OfferExportDto offerExportDto = this.offerService.findOfferById(id);
        return ResponseEntity.ok(offerExportDto);
    }

}
