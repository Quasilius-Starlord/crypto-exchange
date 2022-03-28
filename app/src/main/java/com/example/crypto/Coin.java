package com.example.crypto;

import java.io.Serializable;
import java.math.BigInteger;

public class Coin implements Serializable {
    private BigInteger roundID = null, price = null, startedAt = null, updatedAt = null, answeredInRound = null, decimal = null;
    private int coinCode;
    private String coinName;

    public Coin(String coinName,BigInteger roundID, BigInteger price, BigInteger startedAt, BigInteger updatedAt, BigInteger answeredInRound, BigInteger decimal){
        this.coinName = coinName;
        this.roundID = roundID;
        this.price = price;
        this.startedAt = startedAt;
        this.updatedAt = updatedAt;
        this.answeredInRound = answeredInRound;
        this.decimal = decimal;
    }

    public Coin(String coinName, int coinCode){
        this.coinName=coinName;
        this.coinCode=coinCode;
    }

    public void setRoundID(BigInteger roundID) {
        this.roundID = roundID;
    }

    public BigInteger getRoundID() {
        return roundID;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setStartedAt(BigInteger startedAt) {
        this.startedAt = startedAt;
    }

    public BigInteger getStartedAt() {
        return startedAt;
    }

    public void setUpdatedAt(BigInteger updatedAt) {
        this.updatedAt = updatedAt;
    }

    public BigInteger getUpdatedAt() {
        return updatedAt;
    }

    public void setAnsweredInRound(BigInteger answeredInRound) {
        this.answeredInRound = answeredInRound;
    }

    public BigInteger getAnsweredInRound() {
        return answeredInRound;
    }

    public String getCoinName() {
        return coinName;
    }

    public int getCoinCode() {
        return coinCode;
    }

    public void setDecimal(BigInteger decimal) {
        this.decimal = decimal;
    }

    public BigInteger getDecimal() {
        return decimal;
    }
}
