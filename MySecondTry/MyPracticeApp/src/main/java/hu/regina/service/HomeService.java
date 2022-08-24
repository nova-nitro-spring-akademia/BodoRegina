package hu.regina.service;

import hu.regina.data.entities.HomeEntity;
import hu.regina.data.repositories.HomeRepository;
import hu.regina.domain.Home;
import hu.regina.mapper.entitymapper.HomeEntityMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HomeService {

    private HomeRepository repository ;

    private HomeEntityMapper mapper;


    public HomeService(HomeRepository repository, HomeEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Home save(Home home){
        HomeEntity homeEntity = mapper.homeToHomeEntity(home);
        HomeEntity savedHomeEntity = repository.save(homeEntity);
        return mapper.homeEntityToHome(savedHomeEntity);

    }

    public List<Home> getAll(){
        return mapper.fromHomeEntityList(repository.findAll());
    }

    public Home deleteHomeById(int id){

        Optional<HomeEntity> optionalHomeEntity= repository.findById(id);
        HomeEntity homeEntityToDelete;
        if (optionalHomeEntity.isPresent()) {
            homeEntityToDelete = optionalHomeEntity.get();
            repository.deleteById(id);
            return mapper.homeEntityToHome(homeEntityToDelete);
        }
        return null;
    }

    public Home findHomeById(int id){
        Optional<HomeEntity> optionalHomeEntity= repository.findById(id);
        HomeEntity homeEntity;
        if (optionalHomeEntity.isPresent()) {
            homeEntity = optionalHomeEntity.get();
            return mapper.homeEntityToHome(homeEntity);
        }
        return null;
    }

}
