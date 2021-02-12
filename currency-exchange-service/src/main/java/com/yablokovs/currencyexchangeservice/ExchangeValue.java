package com.yablokovs.currencyexchangeservice;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="Exchange_Value")
public class ExchangeValue
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="currency_from")
    private String from;
    @Column(name="currency_to")
    private String to;
    @Column(name="multiplier")
    private BigDecimal multiplier;
    @Column(name="port")
    private int port;

    public ExchangeValue() {
    }

    public ExchangeValue(Long id, String from, String to, BigDecimal multiplier) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.multiplier = multiplier;
    }

    public Long getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public BigDecimal getMultiplier() {
        return multiplier;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
