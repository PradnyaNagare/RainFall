package org.rainfall.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.rainfall.exception.InvalidCityPincodeException;

public class RainfallReport
{
   
    public boolean validate(String cityPincode) throws InvalidCityPincodeException {
        Pattern pattern = Pattern.compile("^\\d{5}$");
        Matcher matcher = pattern.matcher(cityPincode);

        if (matcher.matches()) {
            return true;
        } else {
            throw new InvalidCityPincodeException("Invalid City Pincode");
        }
    }

  
    public List<AnnualRainfall> generateRainfallReport(String filePath)
    {
        List<AnnualRainfall> annualRainfallList = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            Scanner scanner = new Scanner(bufferedReader);

            while (scanner.hasNext()) {
                String[] records = scanner.nextLine().split(",");
                String cityPincodeStr = records[0];
                boolean correctPin = false;
                try {
                    correctPin = validate(cityPincodeStr);

                    if (correctPin) {
                        int cityPincode = Integer.parseInt(cityPincodeStr);
                        String cityName = records[1];
                        double[] monthlyRainfalls = new double[12];

                        for (int i = 0; i < 12; ++i) {
                            double monthlyRainfall = Double.parseDouble(records[i + 2]);
                            monthlyRainfalls[i] = monthlyRainfall;
                        }

                        AnnualRainfall annualRainfall = new AnnualRainfall();
                        annualRainfall.setCityPincode(cityPincode);
                        annualRainfall.setCityName(cityName);
                        annualRainfall.calculateAverageAnnualRainfall(monthlyRainfalls);
                        annualRainfallList.add(annualRainfall);
                    }
                } catch (InvalidCityPincodeException e) {
                    System.out.println(e.getMessage());
                }
            }

            scanner.close();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

        return annualRainfallList;
    }
    

   
    public List<AnnualRainfall> findMaximumRainfallCities() 
    {
        List<AnnualRainfall> maximumRainfallCities = new ArrayList<>();
		return maximumRainfallCities;
    }
}


      