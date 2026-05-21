package edu.citytech.cst3613.service;

import java.util.HashMap;
//Developer: Usman, Muhammad | @AbuTalha63 on GitHub
import java.util.List;
import java.util.Map;

import static com.jbbwebsolutions.http.utility.JSONGet.*;
import edu.citytech.cst3613.dto.Stock;
import edu.citytech.cst3613.dto.StockResult;

public class StockService {

    private static final String SURL = "http://localhost:8080/stocks/dividends";
    private static StockResult stockResults;
    private Map<Character, Integer> map = new HashMap<>();

    public Map<Character, Integer> getMapping(){
        return map;
    }

    public StockService() {
        stockResults = submitGet(SURL, StockResult.class);
        List<Stock> list = stockResults.getData();

        for (Stock stock : list) {
            char c = stock.symbol.charAt(0);
            if (map.containsKey(c)) {
                int b = map.get(c);
                map.put(c, ++b);
            } else
                map.put(c, 1);
        }
    }

    public List<Stock> getStocks() {
        return stockResults.getData();
    }

    public static void main(String[] args) {
        var service = new StockService();

        service.getStocks()
                .forEach(System.out::println);
        System.out.println("Developer: Usman, Muhammad");
        System.out.println(service.map);
    }

    public List<String> getCount() {
        return null;
    }

    public List<Stock> getStocks(String query) {
        List<Stock> list = this.getStocks();

        if (query.equalsIgnoreCase("All"))
            return list;

        var filteredList = list.stream().filter(e -> e.symbol.startsWith(query)).toList();

        return filteredList;
    }
}