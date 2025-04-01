package com.pokestore.PokeStore;

import org.springframework.data.annotation.Transient;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("cards")
public class Card {

    @PrimaryKey
    private String id; // Código de la carta

    private String nombre;
    private String foto;
    private double precio;
    private String tipo;
    private int vida;
    private String rareza;

    // Constructor vacío para Cassandra
    public Card() {}

    // Constructor
    public Card(String id, String nombre, String foto, double precio, String tipo, int vida, String rareza) {
        this.id = id;
        this.nombre = nombre;
        this.foto = foto;
        this.precio = precio;
        this.tipo = tipo;
        this.vida = vida;
        this.rareza = rareza;
    }

    // Getters y setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getFoto() { return foto; }
    public void setFoto(String foto) { this.foto = foto; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public int getVida() { return vida; }
    public void setVida(int vida) { this.vida = vida; }

    public String getRareza() { return rareza; }
    public void setRareza(String rareza) { this.rareza = rareza; }
}
