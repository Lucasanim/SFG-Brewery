package group.springframework.brewery.web.mapper;
import group.springframework.brewery.domain.Beer;
import group.springframework.brewery.services.inventory.BeerInventoryService;
import group.springframework.brewery.model.BeerDTO;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BeerMapperDecorator implements BeerMapper {
    private BeerInventoryService beerInventoryService;
    private BeerMapper mapper;

    @Autowired
    public void setBeerInventoryService(BeerInventoryService beerInventoryService) {
        this.beerInventoryService = beerInventoryService;
    }

    @Autowired
    public void setMapper(BeerMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public BeerDTO beerToBeerDto(Beer beer) {
        BeerDTO dto = mapper.beerToBeerDto(beer);
        dto.setQuantityOnHand(beerInventoryService.getOnhandInventory(beer.getId()));
        return dto;
    }

    @Override
    public Beer beerDtoToBeer(BeerDTO beerDto) {
        return mapper.beerDtoToBeer(beerDto);
    }
}