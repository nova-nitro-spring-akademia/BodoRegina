package hu.regina.mapper.entitymapper;

import hu.regina.data.entities.RabbitEntity;
import hu.regina.domain.Rabbit;
import hu.regina.domain.eatingstrategy.MyEatingStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RabbitEntityMapper {
    private HomeEntityMapper homeMapper;

    public RabbitEntityMapper(HomeEntityMapper homeMapper) {
        this.homeMapper = homeMapper;
    }

    public RabbitEntity rabbitToRabbitEntity(Rabbit rabbit){
        RabbitEntity rabbitEntity = new RabbitEntity();
        rabbitEntity.setId(rabbit.getId());
        rabbitEntity.setName(rabbit.getName());
        rabbitEntity.setLevelOfFullness(rabbit.getLevelOfFullness());
        if(rabbit.getFriends() != null)
            rabbitEntity.setFriends(this.toRabbitEntityList(rabbit.getFriends()));
        else{
            rabbitEntity.setFriends(null);
        }

        rabbitEntity.setHome(homeMapper.homeToHomeEntity(rabbit.getHome()));

        rabbitEntity.setEatingStrategy(rabbit.getEatingStrategy().toString());

        return rabbitEntity;
    }

    public Rabbit rabbitEntityToRabbit(RabbitEntity rabbitEntity){

        String strategyStr = rabbitEntity.getEatingStrategy();
        Rabbit rabbit = new Rabbit(null);

        if(strategyStr != null)
            rabbit.setEatingStrategy(MyEatingStrategy.valueOf(strategyStr));

        rabbit.setId(rabbitEntity.getId());
        rabbit.setName(rabbitEntity.getName());
        rabbit.setLevelOfFullness(rabbit.getLevelOfFullness());

        if (rabbitEntity.getFriends() != null)
            rabbit.setFriends(this.toRabbitList(rabbitEntity.getFriends()));
        else {
            rabbit.setFriends(null);
        }

        rabbit.setHome(homeMapper.homeEntityToHome(rabbitEntity.getHome()));
        return rabbit;
    }

    public List<Rabbit> toRabbitList(List<RabbitEntity> entityList){
        return entityList.stream().map(this::rabbitEntityToRabbit).toList();
    }

    public List<RabbitEntity> toRabbitEntityList(List<Rabbit> rabbitList){
        return rabbitList.stream().map(this::rabbitToRabbitEntity).toList();
    }

}
