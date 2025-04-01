package com.pokestore.PokeStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    private final String TCGDEX_API_URL = "https://api.tcgdex.net/v2/es/cards/";

    public Card fetchCardFromAPI(String id) {
        RestTemplate restTemplate = new RestTemplate();

        try {
            Map<String, Object> response = restTemplate.getForObject(TCGDEX_API_URL + id, Map.class);

            if (response != null) {
                Card card = new Card();
                card.setId((String) response.get("id"));
                card.setNombre((String) response.get("name"));

                // Modificación para añadir /high.png a la URL de la imagen
                String imagenOriginal = (String) response.get("image");
                String imagenConHighRes = imagenOriginal.endsWith("/high.png") ? imagenOriginal : imagenOriginal + "/high.png";
                card.setFoto(imagenConHighRes);

                card.setTipo((String) response.get("category"));
                card.setVida((int) response.get("hp"));
                card.setRareza((String) response.get("rarity"));
                card.setPrecio(Math.random() * 100); // Precio aleatorio

                return cardRepository.save(card);
            }
        } catch (Exception e) {
            System.out.println("Carta no encontrada: " + e.getMessage());
        }

        return null;
    }
}