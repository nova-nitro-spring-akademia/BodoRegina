package hu.regina.controller;

import hu.regina.controller.dtos.HomeDTO;
import hu.regina.domain.Home;
import hu.regina.domain.exeptions.InvalidIdExeption;
import hu.regina.mapper.dtomapper.HomeDTOMapper;
import hu.regina.service.HomeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {

    private HomeService homeService;

    private HomeDTOMapper homeDTOMapper;

    public HomeController(HomeService homeService, HomeDTOMapper homeDTOMapper) {
        this.homeService = homeService;
        this.homeDTOMapper = homeDTOMapper;
    }

    @ExceptionHandler(InvalidIdExeption.class)
    public ResponseEntity<?> handleException(InvalidIdExeption e) {
        // log exception
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(e.getMessage());
    }

    @PostMapping("/saveHome")
    public HomeDTO saveHome(@RequestBody HomeDTO homeDTO){
        Home homeToSave = homeDTOMapper.homeDTOToHome(homeDTO);
        return homeDTOMapper.homeToHomeDTO(homeService.save(homeToSave));
    }

    @GetMapping("/getAllHomes")
    public List<HomeDTO> getAllHomes(){
        return homeDTOMapper.toHomeDTOList(homeService.getAll());
    }

    @GetMapping("/getHome/{id}")
    public HomeDTO getHome(@PathVariable int id){
        Home Home = homeService.findHomeById(id);
        if (Home == null){
            throw new InvalidIdExeption("Id cannot be found in repository");
        }
        return homeDTOMapper.homeToHomeDTO(Home);
    }

    @DeleteMapping("/deleteHome/{id}")
    public HomeDTO deleteHomeByID(@PathVariable int id){
        Home deletedHome = homeService.deleteHomeById(id);
        if (deletedHome == null){
            throw new InvalidIdExeption("Id cannot be found in repository");
        }
        return homeDTOMapper.homeToHomeDTO(deletedHome);
    }

    @PatchMapping("/patchHome/{id}")
    public HomeDTO patchHomeById(@PathVariable int id, @RequestBody HomeDTO newHomeDTO){
        Home newHome = homeDTOMapper.homeDTOToHome(newHomeDTO);

    }

}

