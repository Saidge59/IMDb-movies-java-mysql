package com.shesternyak.myimdbapi.controller;

import com.shesternyak.myimdbapi.dto.UserRegistrationDTO;
import com.shesternyak.myimdbapi.service.registration.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserSecurityController {
    private UserService userService;

    public UserSecurityController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @ModelAttribute("user")
    public UserRegistrationDTO userRegistrationDTO() {
        return new UserRegistrationDTO();
    }

    @GetMapping("/registration")
    public String showRegistrationMapping() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUserAccount(@Valid @ModelAttribute("user") UserRegistrationDTO registrationDTO,
                                      BindingResult result,
                                      RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "registration";
        }

        if (userService.findUserByName(registrationDTO.getName()) != null) {
            redirectAttributes.addFlashAttribute("errorUsername", registrationDTO.getName());
            return "redirect:/registration";
        } else if (userService.findByEmail(registrationDTO.getEmail()) != null) {
            redirectAttributes.addFlashAttribute("errorEmail", registrationDTO.getEmail());
            return "redirect:/registration";
        }

        userService.save(registrationDTO);

        redirectAttributes.addFlashAttribute("success", "");
        return "redirect:/registration";
    }
}
