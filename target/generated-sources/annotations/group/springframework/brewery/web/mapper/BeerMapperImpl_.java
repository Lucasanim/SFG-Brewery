package group.springframework.brewery.web.mapper;

import group.springframework.brewery.domain.Beer;
import group.springframework.brewery.domain.Beer.BeerBuilder;
import group.springframework.brewery.model.BeerDTO;
import group.springframework.brewery.model.BeerDTO.BeerDTOBuilder;
import group.springframework.brewery.model.BeerStyleEnum;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-05T17:50:12-0300",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
@Qualifier("delegate")
public class BeerMapperImpl_ implements BeerMapper {

    @Autowired
    private DateMapper dateMapper;

    @Override
    public BeerDTO beerToBeerDto(Beer beer) {
        if ( beer == null ) {
            return null;
        }

        BeerDTOBuilder beerDTO = BeerDTO.builder();

        beerDTO.id( beer.getId() );
        if ( beer.getVersion() != null ) {
            beerDTO.version( beer.getVersion().intValue() );
        }
        beerDTO.createdDate( dateMapper.asOffsetDateTime( beer.getCreatedDate() ) );
        beerDTO.lastModifiedDate( dateMapper.asOffsetDateTime( beer.getLastModifiedDate() ) );
        beerDTO.beerName( beer.getBeerName() );
        if ( beer.getBeerStyle() != null ) {
            beerDTO.beerStyle( Enum.valueOf( BeerStyleEnum.class, beer.getBeerStyle() ) );
        }
        beerDTO.upc( beer.getUpc() );
        beerDTO.price( beer.getPrice() );

        return beerDTO.build();
    }

    @Override
    public Beer beerDtoToBeer(BeerDTO beerDTO) {
        if ( beerDTO == null ) {
            return null;
        }

        BeerBuilder beer = Beer.builder();

        beer.id( beerDTO.getId() );
        if ( beerDTO.getVersion() != null ) {
            beer.version( beerDTO.getVersion().longValue() );
        }
        beer.createdDate( dateMapper.asTimestamp( beerDTO.getCreatedDate() ) );
        beer.lastModifiedDate( dateMapper.asTimestamp( beerDTO.getLastModifiedDate() ) );
        beer.beerName( beerDTO.getBeerName() );
        if ( beerDTO.getBeerStyle() != null ) {
            beer.beerStyle( beerDTO.getBeerStyle().name() );
        }
        beer.upc( beerDTO.getUpc() );
        beer.price( beerDTO.getPrice() );

        return beer.build();
    }
}
