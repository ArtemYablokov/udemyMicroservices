package com.yablokovs.currencyconversionservice;

import java.math.BigDecimal;

public class CurrencyConversionBean {

    private Long id;
    private String from;
    private String to;
    private BigDecimal multiplier;
    private BigDecimal quantity;
    private BigDecimal amount;
    private int port;


    public CurrencyConversionBean() {
    }

    public CurrencyConversionBean(Long id, String from, String to, BigDecimal multiplier, BigDecimal quantity, BigDecimal amount, int port)
    {
        super();
        this.id = id;
        this.from = from;
        this.to = to;
        this.multiplier = multiplier;
        this.quantity = quantity;
        this.amount = amount;
        this.port = port;
    }
    //creating setters and getters
    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }
    public String getFrom()
    {
        return from;
    }
    public void setFrom(String from)
    {
        this.from = from;
    }
    public String getTo()
    {
        return to;
    }
    public void setTo(String to)
    {
        this.to = to;
    }
    public BigDecimal getMultiplier()
    {
        return multiplier;
    }
    public void setMultiplier(BigDecimal multiplier)
    {
        this.multiplier = multiplier;
    }
    public BigDecimal getQuantity()
    {
        return quantity;
    }
    public void setQuantity(BigDecimal quantity)
    {
        this.quantity = quantity;
    }
    public BigDecimal getAmount()
    {
        return amount;
    }
    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }
    public int getPort()
    {
        return port;
    }
    public void setPort(int port)
    {
        this.port = port;
    }
}
