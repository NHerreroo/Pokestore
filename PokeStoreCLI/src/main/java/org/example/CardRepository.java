package org.example;

import com.datastax.astra.client.Database;
import com.datastax.astra.client.model.Document;
import net.tcgdex.sdk.models.Card;

public class CardRepository {
    private final Database db;

    public CardRepository(Database db) {
        this.db = db;
    }

    public void saveCard(Card card) {
        Document doc = new Document();
        doc.put("id", card.getId());
        doc.put("name", card.getName());
        doc.put("types", card.getTypes());

        db.getCollection("cards").insertOne(doc);
        System.out.println("✅ Carta guardada en la colección 'cards'");
    }
}
