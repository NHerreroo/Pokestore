package com.pokestore.PokeStore;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends CassandraRepository<Order, UUID> {
    @Query("SELECT * FROM orders WHERE user_email = ?0 ALLOW FILTERING")
    List<Order> findByUserEmailCustom(String user_email);
}