package hu.regina.controller;

import hu.regina.controller.dtos.HomeDTO;
import hu.regina.controller.dtos.RabbitDTO;
import hu.regina.domain.Home;
import hu.regina.domain.Rabbit;
import hu.regina.domain.exeptions.InvalidIdExeption;
import hu.regina.mapper.dtomapper.RabbitDTOMapper;
import hu.regina.mapper.dtomapper.HomeDTOMapper;
import hu.regina.service.HomeService;
import hu.regina.service.RabbitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RabbitController {

    private RabbitService rabbitService;

    private RabbitDTOMapper rabbitDTOMapper;

    public RabbitController(RabbitService rabbitService, RabbitDTOMapper rabbitDTOMapper) {
        this.rabbitService = rabbitService;
        this.rabbitDTOMapper = rabbitDTOMapper;
    }

    @ExceptionHandler(InvalidIdExeption.class)
    public ResponseEntity<?> handleException(InvalidIdExeption e) {
        // log exception
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(e.getMessage());
    }

    @PostMapping("/saveRabbit")
    public RabbitDTO saveRabbit(@RequestBody RabbitDTO rabbitDTO){
        Rabbit rabbitToSave = rabbitDTOMapper.rabbitDTOToRabbit(rabbitDTO);
        return rabbitDTOMapper.rabbitToRabbitDTO(rabbitService.save(rabbitToSave));
    }

    @GetMapping("/getAllRabbits")
    public List<RabbitDTO> getAllRabbits(){
        return rabbitDTOMapper.toRabbitDTOList(rabbitService.getAll());
    }

    @GetMapping("/getRabbit/{id}")
    public RabbitDTO getRabbit(@PathVariable int id){
        Rabbit rabbit = rabbitService.findRabbitById(id);
        if (rabbit == null){
            throw new InvalidIdExeption("Id cannot be found in repository");
        }
        return rabbitDTOMapper.rabbitToRabbitDTO(rabbit);
    }

    @DeleteMapping("/deleteRabbit/{id}")
    public RabbitDTO deleteRabbitByID(@PathVariable int id){
        Rabbit deletedRabbit = rabbitService.deleteRabbitById(id);
        if (deletedRabbit == null){
            throw new InvalidIdExeption("Id cannot be found in repository");
        }
        return rabbitDTOMapper.rabbitToRabbitDTO(deletedRabbit);
    }

    @PatchMapping("/patchRabbit/{id}")
    public RabbitDTO patchRabbitById(@PathVariable int id, @RequestBody RabbitDTO newRabbitDTO){
        Rabbit newRabbit = rabbitDTOMapper.rabbitDTOToRabbit(newRabbitDTO);
        Rabbit oldRabbit = rabbitService.findRabbitById(id);
        if (oldRabbit == null){
            throw new InvalidIdExeption("Id cannot be found in repository");
        }
        newRabbit.setId(id);
        rabbitService.save(newRabbit);
        return rabbitDTOMapper.rabbitToRabbitDTO(oldRabbit);
    }


}
