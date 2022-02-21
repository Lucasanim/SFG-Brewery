package group.springframework.brewery.web.mapper;

import group.springframework.brewery.domain.Beer;
import group.springframework.brewery.web.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
    BeerDTO beerToBeerDto(Beer beer);

    Beer BeerDtoToBeer(BeerDTO beerDTO);
}
