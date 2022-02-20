package group.springframework.brewery.web.controller;

import group.springframework.brewery.web.model.BeerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {


//    @GetMapping("/{beerId}")
//    public ResponseEntity<BeerDTO> getBeer(@PathVariable("beerId") UUID beerId){
//
//        return new ResponseEntity<>(this.beerService.getBeerBtId(beerId), HttpStatus.OK);
//    }
//
//    @PostMapping
//    public ResponseEntity handlePost(@RequestBody BeerDTO beerDTO) {
//        BeerDTO saveDTO = beerService.saveNewBeer(beerDTO);
//        HttpHeaders headers = new HttpHeaders();
//        //todo add hostname to url
//        headers.add("Location", "/api/v1/beer/" + saveDTO.getId().toString());
//
//        return new ResponseEntity(headers, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/{beerId}")
//    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @RequestBody BeerDTO beerDTO){
//        beerService.updateBeer(beerId, beerDTO);
//
//        return new ResponseEntity(HttpStatus.NO_CONTENT);
//    }
//
//    @DeleteMapping("/{beerId}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteBeer(@PathVariable("beerId") UUID beerId){
//        beerService.deleteBeer(beerId);
//    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDTO> getBeerById(@PathVariable("beerId") UUID beerId){

        //todo impl
        return new ResponseEntity<>(BeerDTO.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewBeer(@RequestBody BeerDTO beerDto){

        //todo impl
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeerById(@PathVariable("beerId") UUID beerId, @RequestBody BeerDTO beerDto){

        //todo impl
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
