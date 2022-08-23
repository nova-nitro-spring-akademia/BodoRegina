package hu.regina.service;

import hu.regina.data.entities.RabbitEntity;
import hu.regina.data.repositories.RabbitRepository;
import hu.regina.domain.Rabbit;
import hu.regina.mapper.entitymapper.RabbitEntityMapper;
import org.springframework.stereotype.Service;

@Service
public class RabbitService {
    RabbitEntityMapper rabbitEntityMapper;

    RabbitRepository rabbitRepository;

    public RabbitService(RabbitEntityMapper rabbitEntityMapper, RabbitRepository rabbitRepository) {
        this.rabbitEntityMapper = rabbitEntityMapper;
        this.rabbitRepository = rabbitRepository;
    }

    public Rabbit save(Rabbit rabbit){
        RabbitEntity rabbitEntity = rabbitEntityMapper.rabbitToRabbitEntity(rabbit);
        RabbitEntity savedRabbitEntity = rabbitRepository.save(rabbitEntity);
        return  rabbitEntityMapper.rabbitEntityToRabbit(savedRabbitEntity);

    }
}
