package group.springframework.brewery.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import group.springframework.brewery.bootstrap.BeerLoader;
import group.springframework.brewery.model.BeerDTO;
import group.springframework.brewery.model.BeerStyleEnum;
import group.springframework.brewery.services.BeerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    BeerService beerService;

    private static String baseUrl = "http://localhost:8080/api/v1/";

    @Test
    void getBeerById() throws Exception {

        given(beerService.getById(any())).willReturn(getValidBeerDto());

        mockMvc.perform(get(baseUrl+"beer/b146bfe2-2cbc-496a-b96e-b3af5c640893").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveNewBeer() throws Exception {
        BeerDTO beerDTO = getValidBeerDto();
        String beerDTOJson = objectMapper.writeValueAsString(beerDTO);

        given(beerService.getById(any())).willReturn(getValidBeerDto());

        mockMvc.perform(post("/api/v1/beer/")
                        .contentType(MediaType.APPLICATION_JSON)
                .content(beerDTOJson))
                .andExpect(status().isCreated());
    }

    @Test
    void updateBeerById() throws Exception {
        BeerDTO beerDTO = getValidBeerDto();
        String beerDTOJson = objectMapper.writeValueAsString(beerDTO);

        given(beerService.getById(any())).willReturn(getValidBeerDto());

        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDTOJson))
                .andExpect(status().isNoContent());
    }

    BeerDTO getValidBeerDto() {
        return BeerDTO.builder()
                .beerName("my beer")
                .beerStyle(BeerStyleEnum.ALE)
                .price(new BigDecimal("2.99"))
                .upc(BeerLoader.BEER_1_UPC)
                .build();
    }
}