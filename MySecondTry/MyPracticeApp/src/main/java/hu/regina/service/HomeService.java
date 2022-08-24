package hu.regina.service;

import hu.regina.data.entities.HomeEntity;
import hu.regina.data.repositories.HomeRepository;
import hu.regina.domain.Home;
import hu.regina.mapper.entitymapper.HomeEntityMapper;
import org.springframework.stereotype.Service;

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

}
