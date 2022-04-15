package group.springframework.brewery.services;

import group.springframework.brewery.model.BeerDTO;
import group.springframework.brewery.model.BeerPagedList;
import group.springframework.brewery.model.BeerStyleEnum;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

public interface BeerService {
    BeerDTO getById(UUID beerId);

    BeerDTO saveBeer(BeerDTO beerDto);

    BeerDTO updateBeer(UUID beerId, BeerDTO beerDto);

    BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest of);
}
