package com.pokestore.PokeStore;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import java.util.UUID;

@Table("users")
public class User {
    @PrimaryKey
    private UUID id;
    private String contrasena;
    private String correo;
    private String cuenta_bancaria;
    private String direccion;
    private String pais;
    private String usuario;

    public User(UUID id, String contrasena, String correo, String cuenta_bancaria, String direccion, String pais, String usuario) {
        this.id = id;
        this.contrasena = contrasena;
        this.correo = correo;
        this.cuenta_bancaria = cuenta_bancaria;
        this.direccion = direccion;
        this.pais = pais;
        this.usuario = usuario;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCuenta_bancaria() {
        return cuenta_bancaria;
    }

    public void setCuenta_bancaria(String cuenta_bancaria) {
        this.cuenta_bancaria = cuenta_bancaria;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
