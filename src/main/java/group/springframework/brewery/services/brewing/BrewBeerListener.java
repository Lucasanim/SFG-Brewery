package group.springframework.brewery.services.brewing;

import group.springframework.brewery.config.JmsConfig;
import group.springframework.brewery.domain.Beer;
import group.springframework.brewery.events.BrewBeerEvent;
import group.springframework.brewery.events.NewInventoryEvent;
import group.springframework.brewery.repositories.BeerRepository;
import group.springframework.brewery.model.BeerDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BrewBeerListener {

    private final BeerRepository beerRepository;
    private final JmsTemplate jmsTemplate;

    @Transactional
    @JmsListener(destination = JmsConfig.BREWING_REQUEST_QUEUE)
    public void listen(BrewBeerEvent event) {

        BeerDTO beerDTO = event.getBeerDTO();

        Beer beer = beerRepository.getOne(beerDTO.getId());

        beerDTO.setQuantityOnHand(beer.getQuantityToBrew());

        NewInventoryEvent newInventoryEvent = new NewInventoryEvent(beerDTO);

        log.debug("Brewed beer " + beer.getMinOnHand() + " : QOH: " + beerDTO.getQuantityOnHand());

        jmsTemplate.convertAndSend(JmsConfig.NEW_INVENTORY_QUEUE, newInventoryEvent);
    }

}
