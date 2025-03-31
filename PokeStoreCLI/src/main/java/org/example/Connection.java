package org.example;

import com.datastax.astra.client.DataAPIClient;
import com.datastax.astra.client.Database;
import io.github.cdimascio.dotenv.Dotenv;

public class Connection {

    public Database db(){
        Dotenv dotenv = Dotenv.load();
        // Initialize the client
        DataAPIClient client = new DataAPIClient(dotenv.get("TOKEN"));
        Database db = client.getDatabase(dotenv.get("APIENDPOINT"));
        System.out.println("Connected to AstraDB " + db.listCollectionNames().toList());
        return db;
    }
}
