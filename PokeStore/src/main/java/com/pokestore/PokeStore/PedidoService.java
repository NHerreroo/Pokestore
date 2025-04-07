package com.pokestore.PokeStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido guardarPedido(String usuario, List<String> productos, BigDecimal total) {
        Pedido pedido = new Pedido();
        pedido.setId(UUID.randomUUID());
        pedido.setUsuario(usuario);
        pedido.setProductos(productos);
        pedido.setTotal(total);
        pedido.setFecha(new Date());
        return pedidoRepository.save(pedido);
    }
}
