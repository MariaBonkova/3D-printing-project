package com.example.demo.web;

import com.example.demo.models.dto.CreateHouseOfferDto;
import com.example.demo.models.dto.CreateOfferDto;
import com.example.demo.models.entity.CreateOfferEntity;
import com.example.demo.models.entity.PetsItemEntity;
import com.example.demo.models.view.HouseView;
import com.example.demo.models.view.MusicInstrumentView;
import com.example.demo.models.view.PetsView;
import com.example.demo.repositopy.CreateOfferRepository;
import com.example.demo.service.CreateOfferService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    public CreateOfferEntity createOfferEntity() {
        return new CreateOfferEntity();
    }

    @ModelAttribute
    public CreateOfferDto createOfferDto() {
        return new CreateOfferDto();
    }

    @ModelAttribute
    public PetsView createOfferView() {
        return new PetsView();
    }


    @ModelAttribute
    public CreateHouseOfferDto createHouseOfferDto() {
        return new CreateHouseOfferDto();
    }



    @GetMapping("/create-item-form")
    public String createItemForm() {
        return "create-item-form";
    }

    @GetMapping("/create-item-form-music")
    public String createMusicForm() {
        return "create-item-form-music";
    }

    @GetMapping("/create-item-form-house")
    public String createHouseForm() {
        return "create-item-form-house";
    }


    @GetMapping("/pets-view")
    public String petsView() {
        return "pets-view" ;

    }
    @GetMapping("/music-view")
    public String musicView() {
        return "/music-view";
    }

    @GetMapping("/house-view")
    public String houseViewGet() {
        return "house-view";
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

        return "redirect:/pets-view";
    }

    @PostMapping("/create-item-form-music")
    public String createMusicOffer(@Valid CreateOfferDto createOfferDto,
                                   BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("createOfferDto", createOfferDto)
                    .addFlashAttribute("org.springframework.validation.BindingResult.createOfferDto", bindingResult);

            return "redirect:create-item-form-music";
        }

        createOfferService.createOffer(createOfferDto);

        return "redirect:/music-view";
    }
 @PostMapping("/create-item-form-house")
    public String createHouseOffer(@Valid CreateHouseOfferDto createHouseOfferDto,
                                   BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("createHouseOfferDto", createHouseOfferDto)
                    .addFlashAttribute("org.springframework.validation.BindingResult.createHouseOfferDto", bindingResult);

            return "redirect:create-item-form-house";
        }

        createOfferService.createHouseOffer(createHouseOfferDto);

        return "redirect:/house-view";
    }


    @GetMapping("/create-item-form/pets-view/{id}")
    public String createItemForms(@PathVariable Long id, Model model) {
        model.addAttribute("petsView", createOfferService.getPetView(id));
        model.addAttribute("price", createOfferService.getPetView(id).getPrice());
        return "pets-view";
    }

    @GetMapping("/create-item-form/music-view/{id}")
    public String createMusicForms(@PathVariable Long id, Model model) {
        model.addAttribute("musicInstrumentView", createOfferService.getMusicView(id));
        model.addAttribute("price", createOfferService.getMusicView(id).getPrice());
        return "music-view";

    } @GetMapping("/create-item-form/house-view/{id}")
    public String createHouseForms(@PathVariable Long id, Model model) {
        model.addAttribute("houseView", createOfferService.getHouseView(id));
        model.addAttribute("price", createOfferService.getHouseView(id).getPrice());
        return "house-view";
    }


}
