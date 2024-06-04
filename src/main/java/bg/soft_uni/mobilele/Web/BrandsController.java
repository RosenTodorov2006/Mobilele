package bg.soft_uni.mobilele.Web;

import bg.soft_uni.mobilele.Models.Dtos.BrandExportDto;
import bg.soft_uni.mobilele.Services.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BrandsController {
    private final BrandService brandService;

    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/brands/all")
    public String brands(Model model){
        List<BrandExportDto> list = brandService.findAll();
        model.addAttribute("brands", list);
        return "brands";
    }
}
