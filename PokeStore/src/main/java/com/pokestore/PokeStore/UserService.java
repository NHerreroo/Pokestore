package com.pokestore.PokeStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(String contrasena, String correo, String cuenta_bancaria,
                             String direccion, String pais, String usuario) {
        User newUser = new User(UUID.randomUUID(), contrasena, correo,
                cuenta_bancaria, direccion, pais, usuario);
        return userRepository.save(newUser);
    }

    public boolean authenticate(String usuario, String contrasena) {
        User user = userRepository.findByUsuario(usuario);
        return user != null && user.getContrasena().equals(contrasena);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsuario(username);
    }
}