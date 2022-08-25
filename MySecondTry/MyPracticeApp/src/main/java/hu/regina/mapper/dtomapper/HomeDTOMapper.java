package hu.regina.mapper.dtomapper;

import hu.regina.controller.dtos.HomeDTO;
import hu.regina.domain.Home;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface HomeDTOMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "location", source = "location")
    HomeDTO homeToHomeDTO(Home home);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "location", source = "location")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Home homeDTOToHome(HomeDTO homeDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "location", source = "location")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    List<Home> fromHomeDTOList(List<HomeDTO> homeDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "location", source = "location")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    List<HomeDTO> toHomeDTOList(List<Home> home);

}
