package group.springframework.brewery.events;

import group.springframework.brewery.model.BeerDTO;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NewInventoryEvent extends BeerEvent{
    public NewInventoryEvent(BeerDTO beerDTO) {
        super(beerDTO);
    }
}
