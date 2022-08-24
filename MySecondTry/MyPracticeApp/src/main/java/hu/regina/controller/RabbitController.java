package hu.regina.controller;

import hu.regina.domain.Home;
import hu.regina.domain.Rabbit;
import hu.regina.domain.eatingstrategy.MyEatingStrategy;
import hu.regina.service.RabbitService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RabbitController {

    private RabbitService rabbitService;

    public RabbitController(RabbitService rabbitService) {
        this.rabbitService = rabbitService;
    }

    @GetMapping("/getAll")
    public List<Rabbit> getAll(){
        return rabbitService.getAll();
    }

    @PostMapping
    public Rabbit insertRabbit(Rabbit rabbit){
        return rabbitService.save(rabbit);
    }


}
