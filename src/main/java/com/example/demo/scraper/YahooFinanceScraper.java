package com.example.demo.scraper;

import com.example.demo.StocksFactory.Stock;
import com.example.demo.StocksFactory.StockFactory;
import lombok.AllArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class YahooFinanceScraper {
    @Autowired
    private final StockFactory stockFactory;
    @Autowired
    private final MongoOperations mongoOperations;

    @Value("#{'${yahoo.finance.urls}'.split(',')}")
    private List<String> targetUrls;

    @Value("#{'${mongodb.database.collections}'.split(',')}")
    private List<String> collectionNames;

    @PostConstruct
    private void startScraping() throws InterruptedException {

        for(int i=0; i<targetUrls.size(); ++i){
            int targetNumber = i;
            new Thread(() ->{
                try {
                    getUrlData(targetUrls.get(targetNumber), collectionNames.get(targetNumber));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    private void getUrlData(String targetUrl, String targetCollection) throws IOException {
        while (true){
            List<Stock> stocksFromTable = getTableRows(targetUrl, targetCollection);

            //insert to data base all the data collected
            mongoOperations.dropCollection(targetCollection);
            mongoOperations.insert(stocksFromTable, targetCollection);
        }
    }

    private List<Stock> getTableRows(String targetUrl, String targetCollection) throws IOException {
        List<Stock> tableRowsData = new ArrayList<Stock>();
        Document mainPage = Jsoup.connect(targetUrl).get();
        int tableSize = getTableSize(mainPage);

        do{//will run untill all data will be mined from the stocks table
            mainPage = Jsoup.connect(targetUrl + tableRowsData.size()).get();
            Elements tableRowsElements = mainPage.select("tr[class*=simpTblRow Bgc($hoverBgColor):h BdB Bdbc($seperatorColor) Bdbc($tableBorderBlue):h H(32px) Bgc($lv]");
            //use factory design pattern
            for(Element tableRow : tableRowsElements){
                Stock newStock = stockFactory.makeStock(targetCollection);
                newStock.convertElementToStock(tableRow);
                tableRowsData.add(newStock);
                if(tableRowsData.size() >= tableSize && tableSize != 0)//we reach the last row of the table in case it is a multi page table
                    break;
            }
        }while (tableRowsData.size() < tableSize);

        return tableRowsData;
    }

    private int getTableSize(Document mainPage) {
        Element currntTableInfoElement = mainPage.select("span[class=Mstart(15px) Fw(500) Fz(s)] > span").first();
        if(currntTableInfoElement == null){//in case the table is not a multi page table
            return 0;
        }

        List<String> currntTableInfoString = Arrays.asList(currntTableInfoElement.text().split(" "));//split to stings
        int tableSize = Integer.parseInt(currntTableInfoString.get(2));//extract the number that is representative of the table lenght

        return tableSize;
    }
}
