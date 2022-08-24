package hu.regina.mapper.dtomapper;

import hu.regina.controller.dtos.RabbitDTO;
import hu.regina.data.entities.RabbitEntity;
import hu.regina.domain.Rabbit;
import hu.regina.domain.eatingstrategy.MyEatingStrategy;
import hu.regina.mapper.entitymapper.HomeEntityMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RabbitDTOMapper {
    private HomeDTOMapper homeMapper;

    public RabbitDTOMapper(HomeDTOMapper homeMapper) {
        this.homeMapper = homeMapper;
    }

    public RabbitDTO rabbitToRabbitDTO(Rabbit rabbit){
        RabbitDTO rabbitDTO = new RabbitDTO();
        rabbitDTO.setId(rabbit.getId());
        rabbitDTO.setName(rabbit.getName());
        rabbitDTO.setLevelOfFullness(rabbit.getLevelOfFullness());
        if(rabbit.getFriends() != null)
            rabbitDTO.setFriends(this.toRabbitDTOList(rabbit.getFriends()));
        else{
            rabbitDTO.setFriends(null);
        }

        rabbitDTO.setHomeDTO(homeMapper.homeToHomeDTO(rabbit.getHome()));

        rabbitDTO.setEatingStrategy(rabbit.getEatingStrategy().toString());

        return rabbitDTO;
    }

    public Rabbit rabbitDTOToRabbit(RabbitDTO rabbitDTO){

        String strategyStr = rabbitDTO.getEatingStrategy();
        Rabbit rabbit = new Rabbit(null);

        if(strategyStr != null)
            rabbit.setEatingStrategy(MyEatingStrategy.valueOf(strategyStr));

        rabbit.setId(rabbitDTO.getId());
        rabbit.setName(rabbitDTO.getName());
        rabbit.setLevelOfFullness(rabbitDTO.getLevelOfFullness());

        if (rabbitDTO.getFriends() != null)
            rabbit.setFriends(this.toRabbitList(rabbitDTO.getFriends()));
        else {
            rabbit.setFriends(null);
        }

        rabbit.setHome(homeMapper.homeDTOToHome(rabbitDTO.getHomeDTO()));
        return rabbit;
    }

    public List<Rabbit> toRabbitList(List<RabbitDTO> entityList){
        return entityList.stream().map(this::rabbitDTOToRabbit).toList();
    }

    public List<RabbitDTO> toRabbitDTOList(List<Rabbit> rabbitList){
        return rabbitList.stream().map(this::rabbitToRabbitDTO).toList();
    }
}
