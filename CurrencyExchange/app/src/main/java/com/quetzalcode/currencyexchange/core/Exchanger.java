package com.quetzalcode.currencyexchange.core;

public class Exchanger {
    public double convertDollarToPeso(double dollarPrice, double quantity) {
        return dollarPrice * quantity;
    }

    public double convertPesoToDollar(double dollarPrice, double quantity) {
        return quantity / dollarPrice;
    }
}
