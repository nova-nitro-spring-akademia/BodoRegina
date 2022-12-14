package hu.regina.mapper.entitymapper;

import hu.regina.data.entities.HomeEntity;
import hu.regina.domain.Home;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HomeEntityMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "location", source = "location")
    HomeEntity homeToHomeEntity(Home home);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "location", source = "location")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Home homeEntityToHome(HomeEntity homeEntity);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "location", source = "location")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    List<Home> fromHomeEntityList(List<HomeEntity> homeEntity);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "location", source = "location")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    List<HomeEntity> toHomeEntityList(List<Home> homeEntity);

}
