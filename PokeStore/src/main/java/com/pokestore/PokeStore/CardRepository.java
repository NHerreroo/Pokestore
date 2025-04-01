package com.pokestore.PokeStore;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends CassandraRepository<Card, String> {
}
