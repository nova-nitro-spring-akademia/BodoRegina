package hu.regina.mapper;

import hu.regina.data.entities.RabbitEntity;
import hu.regina.domain.Rabbit;
import hu.regina.domain.eatingstrategy.MyEatingStrategy;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public abstract class RabbitEntityMapper {

    HomeEntityMapper homeMapper;

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "levelOfFullness", source = "levelOfFullness")
    RabbitEntity rabbitToRabbitEntity(Rabbit rabbit){
        RabbitEntity rabbitEntity = new RabbitEntity();
        rabbitEntity.setHome(homeMapper.homeToHomeEntity(rabbit.getHome()));

        rabbitEntity.setEatingStrategy(rabbitEntity.getEatingStrategy());

        return rabbitEntity;
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "levelOfFullness", source = "levelOfFullness")
    Rabbit rabbitEntityToRabbit(RabbitEntity rabbitEntity){
        Rabbit rabbit = new Rabbit(MyEatingStrategy.valueOf(rabbitEntity.getEatingStrategy()));
        rabbit.setHome(homeMapper.homeEntityToHome(rabbitEntity.getHome()));
        return rabbit;
    }

    List<Rabbit> toRabbitList(List<RabbitEntity> entityList){
        return entityList.stream().map(this::rabbitEntityToRabbit).toList();
    }

    List<RabbitEntity> toRabbitEntityList(List<Rabbit> rabbitList){
        return rabbitList.stream().map(this::rabbitToRabbitEntity).toList();
    }

}
