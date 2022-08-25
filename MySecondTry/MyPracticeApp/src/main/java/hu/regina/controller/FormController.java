package hu.regina.controller;

import hu.regina.controller.dtos.HomeDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormController {

    @GetMapping("/form")
    public String showForm(Model model){
        HomeDTO homeDTO = new HomeDTO();
        model.addAttribute("homeDTO", homeDTO);
        return "form";
    }

    @GetMapping("/home")
    public String showHome(){
        return "homeIndex";
    }

    @GetMapping("/")
    public String redirectToHome(){
        return "redirect:/homeIndex";
    }

}
