package com.pokestore.PokeStore;

import org.springframework.data.cassandra.repository.CassandraRepository;
import java.util.UUID;

public interface PedidoRepository extends CassandraRepository<Pedido, UUID> {
}
