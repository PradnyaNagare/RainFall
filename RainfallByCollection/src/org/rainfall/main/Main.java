package org.rainfall.main;
import java.util.List;

import org.rainfall.database.DBHandler;

public class Main {
    public static void main(String[] args)
    {
        RainfallReport rainfallReport = new RainfallReport();
        List<AnnualRainfall> annualRainfalls = rainfallReport.generateRainfallReport("AllCityMonthlyRainfall.txt");
        List<AnnualRainfall> maximumRainfallCities = rainfallReport.findMaximumRainfallCities();

        System.out.println("All cities");
        for (AnnualRainfall annualRainfall : annualRainfalls) {
            System.out.println(String.format("id: %d, name: %s, rain: %f",
                    annualRainfall.getCityPincode(),
                    annualRainfall.getCityName(),
                    annualRainfall.getAverageAnnualRainfall()));
        }

        System.out.println("Cities with valid pincode");
          new DBHandler().adding(annualRainfalls);// adding to collection database
      
      
          
      
        
    }
}