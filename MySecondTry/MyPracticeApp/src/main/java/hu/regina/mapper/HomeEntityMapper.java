package hu.regina.mapper;

import hu.regina.data.entities.HomeEntity;
import hu.regina.domain.Home;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface HomeEntityMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "location", source = "location")
    HomeEntity homeToHomeEntity(Home home);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "location", source = "location")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Home homeEntityToHome(HomeEntity homeEntity);

}
