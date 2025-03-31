package org.example;

import net.tcgdex.sdk.TCGdex;
import net.tcgdex.sdk.models.Card;


import java.util.Scanner;

public class APIService {

    TCGdex tcgdex = new TCGdex("es");

    public Card getCardById(String id){
        Card card = tcgdex.fetchCard(id);
        return card;
    }

    public void printCardInfo(Card card){
        System.out.println(card.getName());
        System.out.println(card.getAttacks());
        System.out.println(card.getTypes());
    }
}
