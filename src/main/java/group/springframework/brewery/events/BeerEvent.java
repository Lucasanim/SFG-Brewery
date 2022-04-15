package group.springframework.brewery.events;

import group.springframework.brewery.model.BeerDTO;
import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerEvent implements Serializable {

    static final long serialVersionUID = -2331221881499463591L;

    private BeerDTO beerDTO;
}
