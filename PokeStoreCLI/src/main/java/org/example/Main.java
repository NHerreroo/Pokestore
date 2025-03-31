package org.example;

import com.datastax.astra.client.Database;
import net.tcgdex.sdk.models.Card;

public class Main {
    public static void main(String[] args) {
        Connection con = new Connection();
        Database db = con.db();

        APIService as = new APIService();
        CardRepository cardRepo = new CardRepository(db);

        Card card = as.getCardById("swsh3-136");
        as.printCardInfo(card);

        cardRepo.saveCard(card);
    }
}
