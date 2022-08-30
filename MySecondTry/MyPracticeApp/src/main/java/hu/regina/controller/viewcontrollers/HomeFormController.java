package hu.regina.controller.viewcontrollers;

import hu.regina.controller.dtos.HomeDTO;
import hu.regina.domain.Home;
import hu.regina.mapper.dtomapper.HomeDTOMapper;
import hu.regina.service.HomeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeFormController {

    HomeDTOMapper homeDTOMapper;

    HomeService homeService;

    public HomeFormController(HomeDTOMapper homeDTOMapper, HomeService homeService) {
        this.homeDTOMapper = homeDTOMapper;
        this.homeService = homeService;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
        return new ResponseEntity<>("not valid due to validation error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/home")
    public String showHome(){
        return "/homePages/homeIndex";
    }

    @GetMapping("/")
    public String redirectToHome(){
        return "redirect:/home";
    }

    @GetMapping("/form")
    public String showForm(Model model){
        HomeDTO homeDTO = new HomeDTO();
        model.addAttribute("homeDTO", homeDTO);
        return "/homePages/form";
    }

    @PostMapping("/saveHome")
    public String saveHome(@Valid @ModelAttribute HomeDTO homeDTO, Model model){
        Home homeToSave = homeDTOMapper.homeDTOToHome(homeDTO);
        homeService.save(homeToSave);
        return "redirect:/home";
    }

    @GetMapping("/homeList")
    public String listHomes(Model model){
        List<Home> homes = homeService.getAll();
        model.addAttribute("homes",homes);
        return "/homePages/homeListMagic";
    }

    @GetMapping("/getOneHome/{id}")
    public String getHome(@PathVariable int id, Model model){
        HomeDTO homeDTO = homeDTOMapper.homeToHomeDTO(homeService.findHomeById(id));
        model.addAttribute("homeDTO",homeDTO);

        return "/homePages/oneHome";
    }

    @GetMapping("/patchHome/{id}")
    public String patchHome( @ModelAttribute HomeDTO homeDTO, @PathVariable int id, Model model){
        homeService.deleteHomeById(id);
        homeService.save(homeDTOMapper.homeDTOToHome(homeDTO));
        return "redirect:/homeList";
    }

    @GetMapping("/homeDeleteQuestion/{id}")
    public String homeDeleteQuestion(@PathVariable int id, Model model){
        model.addAttribute("id",id);
        return "/homePages/deleteQuestion";
    }

    @GetMapping("/deleteHome/{id}")
    public String deleteHome(@PathVariable int id){
        //TODO valamit csinálni a mi ennél szebb azért
        //int id = (int) model.getAttribute("id");
        homeService.deleteHomeById(id);
        return "redirect:/homeList";
    }


}
