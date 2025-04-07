package com.pokestore.PokeStore;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Table("orders")
public class Order {

    @PrimaryKey
    private UUID id;
    private Date created_at;
    private List<String> items;
    private BigDecimal total_price;
    private String user_email;

    public Order() {
        this.id = UUID.randomUUID();
        this.created_at = new Date();
    }

    public Order(UUID id, Date created_at, List<String> items, BigDecimal total_price, String user_email) {
        this.id = id;
        this.created_at = created_at;
        this.items = items;
        this.total_price = total_price;
        this.user_email = user_email;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public BigDecimal getTotal_price() {
        return total_price;
    }

    public void setTotal_price(BigDecimal total_price) {
        this.total_price = total_price;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }
}