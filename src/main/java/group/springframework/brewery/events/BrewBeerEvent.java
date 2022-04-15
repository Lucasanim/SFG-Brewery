package group.springframework.brewery.events;

import group.springframework.brewery.model.BeerDTO;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BrewBeerEvent extends  BeerEvent{
    public BrewBeerEvent(BeerDTO beerDTO) {
        super(beerDTO);
    }
}
