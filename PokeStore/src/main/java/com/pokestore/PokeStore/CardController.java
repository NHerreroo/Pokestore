package com.pokestore.PokeStore;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cards")
public class CardController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CardService cardService;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private UserService userService;


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

    @PostMapping("/login")
    public String login(@RequestParam String usuario,
                        @RequestParam String contrasena,
                        Model model,
                        HttpSession session) {
        if (userService.authenticate(usuario, contrasena)) {
            session.setAttribute("usuarioLogueado", usuario);
            return "redirect:/cards/list";
        } else {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "login";
        }
    }



    @PostMapping("/eliminar/{id}")
    public String eliminarCarta(@PathVariable String id) {
        cardRepository.deleteById(id);
        return "redirect:/cards/list";
    }


    @GetMapping("/register")
    public String register(Model model) {
        Iterable<Card> cartas = cardRepository.findAll();
        model.addAttribute("register", cartas);
        return "register";
    }


    @PostMapping("/adduser")
    public String registerUser(@RequestParam String contrasena, @RequestParam String correo,
                               @RequestParam String cuenta_bancaria, @RequestParam String direccion,
                               @RequestParam String pais, @RequestParam String usuario) {
        userService.registerUser(contrasena, correo, cuenta_bancaria, direccion, pais, usuario);
        return "redirect:/cards/login"; // Redirige al login después del registro
    }


    @GetMapping("/usuario-actual")
    @ResponseBody // Esto asegura que devuelva el string directamente
    public String getUsuarioActual(HttpSession session) {
        String usuario = (String) session.getAttribute("usuarioLogueado");
        if (usuario != null) {
            // Aquí deberías obtener el correo del usuario desde tu UserService
            User user = userService.findByUsername(usuario);
            return user != null ? user.getCorreo() : "";
        }
        return "";
    }

    @GetMapping("/orders")
    public String orders(Model model, HttpSession session) {
        String usuario = (String) session.getAttribute("usuarioLogueado");
        if (usuario != null) {
            User user = userService.findByUsername(usuario);
            if (user != null) {
                String correo = user.getCorreo();
                model.addAttribute("user_email", correo);
                // Recupera los pedidos del usuario
                List<Order> orders = orderService.getOrdersByUser_email(correo);
                model.addAttribute("pedidos", orders);
            }
        }
        return "orders";
    }
}