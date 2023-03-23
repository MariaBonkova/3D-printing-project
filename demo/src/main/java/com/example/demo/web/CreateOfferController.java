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

    @GetMapping("/create-item-form/view")
    public String viewItemForm(Model model, CreateOfferView createOfferView) {

        modelMapper.map(createOfferDto(),CreateOfferView.class);

        model.addAttribute("productName", createOfferView.getProductName());
        model.addAttribute("price", createOfferService.totalProductPrice(createOfferDto().getMaterialComposition().name()));

      createOfferService.addPrice();

        return "redirect:/basket";
    }


    @PostMapping("/create-item-form/view")
    public String createOffer(@Valid CreateOfferDto createOfferDto,
                              BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("createOfferDto", createOfferDto)
                    .addFlashAttribute("org.springframework.validation.BindingResult.createOfferDto", bindingResult);

            return "redirect:create-item-form";
        }

        createOfferRepository.save (modelMapper.map(createOfferDto, CreateOfferEntity.class));

        return "redirect:/create-item-form/view";
    }
}
