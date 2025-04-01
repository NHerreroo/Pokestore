package com.pokestore.PokeStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping("/buscar/{id}")
    public Card buscarYGuardarCarta(@PathVariable String id) {
        return cardService.fetchCardFromAPI(id);
    }
}
