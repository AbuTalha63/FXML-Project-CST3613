package edu.citytech.cst3613.dto;

public class Stock {

    public int rank = 0;
    public String symbol = "";
    public String companyName = "";
    public float marketCapInBillions = 0;
    public float divYield = 0;

    @Override
    public String toString() {
        return "Stock [rank=" + rank + ", symbol=" + symbol + ", companyName=" + companyName + ", marketCap="
                + marketCapInBillions + ", divYield=" + divYield + "]";
    }

}