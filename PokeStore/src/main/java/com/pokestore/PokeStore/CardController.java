package com.pokestore.PokeStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @Autowired
    private CardRepository cardRepository;

    @PostMapping("/buscar")
    public String buscarYGuardarCarta(@RequestParam String cardId, Model model) {
        Card card = cardService.fetchCardFromAPI(cardId);
        if(card != null) {
            cardRepository.save(card);
            return "redirect:/cards/list";
        } else {
            model.addAttribute("error", "No se encontró la carta con ID: " + cardId);
            return listarCartas(model);
        }
    }

    @GetMapping("/list")
    public String listarCartas(Model model) {
        Iterable<Card> cartas = cardRepository.findAll();
        model.addAttribute("cartas", cartas);
        model.addAttribute("cardId", ""); // Para el formulario de búsqueda
        return "cartas";
    }

    @GetMapping("/login")
    public String logging(Model model) {
        Iterable<Card> cartas = cardRepository.findAll();
        model.addAttribute("login", cartas);
        return "login";
    }


    @PostMapping("/eliminar/{id}")
    public String eliminarCarta(@PathVariable String id) {
        cardRepository.deleteById(id);
        return "redirect:/cards/list";
    }
}