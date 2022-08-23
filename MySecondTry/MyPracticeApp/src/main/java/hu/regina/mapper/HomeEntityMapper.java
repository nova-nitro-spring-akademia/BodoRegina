package hu.regina.mapper;

import hu.regina.data.entities.HomeEntity;
import hu.regina.domain.Home;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface HomeEntityMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "name", source = "name")
    HomeEntity homeToHomeEntity(Home home);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Home homeEntityToHome(HomeEntity homeEntity);

}
