package edu.citytech.cst3613.dto;

import java.util.List;

public class StockResult {

    private List<Stock> data;
    private int size;
    public List<Stock> getData() {
        return data;
    }
    public void setData(List<Stock> data) {
        this.data = data;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    @Override
    public String toString() {
        return "StockResult [data=" + data + ", size=" + size + "]";
    }
}
