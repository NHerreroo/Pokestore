package com.pokestore.PokeStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/crear")
    public Pedido crearPedido(@RequestBody Map<String, Object> datos) {
        String usuario = (String) datos.get("usuario");
        List<String> productos = (List<String>) datos.get("productos");
        BigDecimal total = new BigDecimal(String.valueOf(datos.get("total")));
        return pedidoService.guardarPedido(usuario, productos, total);
    }
}
