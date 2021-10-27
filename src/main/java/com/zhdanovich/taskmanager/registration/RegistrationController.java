package com.zhdanovich.taskmanager.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping()
    public String createUser(Model model) {
        RegistrationRequest request = new RegistrationRequest();
        model.addAttribute("request", request);
        return "registration/registration_form";
    }

    @PostMapping()
    public String registerUser(@ModelAttribute("request") RegistrationRequest request) {
        registrationService.register(request);
        return "redirect:/login";
    }

}
