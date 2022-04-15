package group.springframework.brewery.services.brewing;

import group.springframework.brewery.config.JmsConfig;
import group.springframework.brewery.domain.Beer;
import group.springframework.brewery.events.BrewBeerEvent;
import group.springframework.brewery.repositories.BeerRepository;
import group.springframework.brewery.services.inventory.BeerInventoryService;
import group.springframework.brewery.web.mapper.BeerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BrewingService {

    private final BeerRepository beerRepository;
    private final BeerInventoryService beerInventoryService;
    private final JmsTemplate jmsTemplate;
    private final BeerMapper beerMapper;

    @Scheduled(fixedRate = 5000) //every 5 second ds
    public void checkForLowInventory() {
        List<Beer> beers = beerRepository.findAll();

        beers.forEach(beer -> {
            Integer invQOH = beerInventoryService.getOnhandInventory(beer.getId());
            log.debug("Min On Hand: " + beer.getMinOnHand());
            log.debug("Inventory is:: " + invQOH);
            if(beer.getMinOnHand() >= invQOH) {
                jmsTemplate.convertAndSend(JmsConfig.BREWING_REQUEST_QUEUE, new BrewBeerEvent(beerMapper.beerToBeerDto(beer)));
            }
        });
    }

}
