package edu.citytech.cst3613.service;
//Developer: Usman, Muhammad | @AbuTalha63 on GitHub
import java.util.List;
import static com.jbbwebsolutions.http.utility.JSONGet.*;
import edu.citytech.cst3613.dto.Stock;
import edu.citytech.cst3613.dto.StockResult;

public class StockService {

    private static final String SURL = "http://localhost:8080/stocks/dividends";

    public List<Stock> getStocks() {
        var stockResults = submitGet(SURL, StockResult.class);

        return stockResults.getData();
    }
    public static void main(String[] args) {
        var service = new StockService();

        service.getStocks()
                    .forEach(System.out::println);
        System.out.println("Developer: Usman, Muhammad");
    }
}