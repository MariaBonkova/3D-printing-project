package com.example.demo.web;

import com.example.demo.models.dto.CreateOfferDto;
import com.example.demo.models.entity.CreateOfferEntity;
import com.example.demo.models.entity.enums.MaterialComposition;
import com.example.demo.models.view.CreateOfferView;
import com.example.demo.repositopy.CreateOfferRepository;
import com.example.demo.service.CreateOfferService;
import com.example.demo.service.MaterialService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CreateOfferController {
    private final ModelMapper modelMapper;
    private final CreateOfferService createOfferService;
    private final CreateOfferRepository createOfferRepository;



    public CreateOfferController(ModelMapper modelMapper,
                                 CreateOfferService createOfferService,
                                 CreateOfferRepository createOfferRepository) {
        this.modelMapper = modelMapper;
        this.createOfferService = createOfferService;
        this.createOfferRepository = createOfferRepository;


    }

    @ModelAttribute
    public CreateOfferDto createOfferDto() {
        return new CreateOfferDto();
    }

    @ModelAttribute
    public CreateOfferView createOfferView() {
        return new CreateOfferView();
    }

    @GetMapping("/create-item-form")
    public String createItemForm() {
        return "create-item-form";
    }

    @PostMapping("/create-item-form/view")
    public String viewItemForm(Model model, CreateOfferEntity createOfferEntity) {

        model.addAttribute("productName", createOfferEntity.getProductName());
        model.addAttribute("price", createOfferService.getTotalPrice(createOfferEntity));

        return "redirect:/create-item-form/view";
    }
   @GetMapping("/create-item-form/view")
    public String createItemForms(Model model, CreateOfferEntity createOfferEntity) {

            model.addAttribute("productName", createOfferEntity.getProductName());
            model.addAttribute("price", createOfferService.getTotalPrice(createOfferEntity));

            return "create-item-form";
    }


    @PostMapping("/create-item-form")
    public String createOffer(@Valid CreateOfferDto createOfferDto,
                              BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("createOfferDto", createOfferDto)
                    .addFlashAttribute("org.springframework.validation.BindingResult.createOfferDto", bindingResult);

            return "redirect:create-item-form";
        }

        createOfferService.createOffer(createOfferDto);

        return "redirect:/create-item-form/view";
    }
}
