package hu.regina.service;

import hu.regina.data.entities.HomeEntity;
import hu.regina.data.entities.RabbitEntity;
import hu.regina.data.repositories.RabbitRepository;
import hu.regina.domain.Home;
import hu.regina.domain.Rabbit;
import hu.regina.mapper.entitymapper.RabbitEntityMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RabbitService {

    private  final HomeService homeService;
    private final RabbitEntityMapper rabbitEntityMapper;
    private final RabbitRepository rabbitRepository;

    public RabbitService(HomeService homeService, RabbitEntityMapper rabbitEntityMapper, RabbitRepository rabbitRepository) {
        this.homeService = homeService;
        this.rabbitEntityMapper = rabbitEntityMapper;
        this.rabbitRepository = rabbitRepository;
    }

    public Rabbit save(Rabbit rabbit){
        RabbitEntity rabbitEntity = rabbitEntityMapper.rabbitToRabbitEntity(rabbit);
        if (rabbitEntity.getFriends() != null) {
            rabbitEntity.getFriends().forEach(rabbitRepository::save);
        }
        if (rabbit.getHome()!= null) {
            homeService.save(rabbit.getHome());
        }
        RabbitEntity savedRabbitEntity = rabbitRepository.save(rabbitEntity);
        //
        return  rabbitEntityMapper.rabbitEntityToRabbit(savedRabbitEntity);

    }

    public List<Rabbit> getAll(){
        return rabbitEntityMapper.toRabbitList(rabbitRepository.findAll());
    }

    @Transactional
    public Rabbit deleteRabbitById(int id){

        Optional<RabbitEntity> optionalRabbitEntity= rabbitRepository.findById(id);
        RabbitEntity rabbitEntityToDelete;
        if (optionalRabbitEntity.isPresent()) {
            rabbitEntityToDelete = optionalRabbitEntity.get();
            rabbitRepository.deleteById(id);
            return rabbitEntityMapper.rabbitEntityToRabbit(rabbitEntityToDelete);
        }
        return null;
    }

    public Rabbit findRabbitById(int id){
        Optional<RabbitEntity> optionalRabbitEntity= rabbitRepository.findById(id);
        RabbitEntity rabbitEntity;
        if (optionalRabbitEntity.isPresent()) {
            rabbitEntity = optionalRabbitEntity.get();
            return rabbitEntityMapper.rabbitEntityToRabbit(rabbitEntity);
        }
        return null;
    }
}
