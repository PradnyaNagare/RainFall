package org.rainfall.database;

import java.util.ArrayList;
import java.util.List;

import org.rainfall.main.AnnualRainfall;


public class DBHandler
{
	List<AnnualRainfall> collectionBase=new ArrayList<AnnualRainfall>();
    public void adding( List<AnnualRainfall> annualRainfalls)
    {
    	 collectionBase.addAll(annualRainfalls);
    	 
    	   for (AnnualRainfall annualRainfall : collectionBase)
           {
               System.out.println(String.format("id: %d, name: %s, rain: %f",
                       annualRainfall.getCityPincode(),
                       annualRainfall.getCityName(),
                       annualRainfall.getAverageAnnualRainfall()));
           }
    	   
    	
    	   getMaxData(collectionBase);
    }
 
    double rainfallData[]=new double[50];int j;
    public void getMaxData( List<AnnualRainfall> collectionBase)
    {
    	 for (AnnualRainfall annualRainfall : collectionBase)
         {
    		
    		 
    		 rainfallData[j]=annualRainfall.getAverageAnnualRainfall();
            j++;
                    
         }
    	 double maxValue=rainfallData[0];int pin=0;String cname="";
    	 AnnualRainfall annualRainfall =new AnnualRainfall();
    	 for (int i = 0; i < rainfallData.length; i++)
    	 {
			if(rainfallData[i]>maxValue)
			{
				maxValue=rainfallData[i];	
			}
				
		 }
    	 System.out.println();
    	 System.out.println("Maximum Average Rainfall City Details");
    	 for (AnnualRainfall annualRainfall1 : collectionBase)
         {
    		if(maxValue==annualRainfall1.getAverageAnnualRainfall())
    		{
    			 System.out.println(String.format("id: %d, name: %s, rain: %f",
                         annualRainfall1.getCityPincode(),
                         annualRainfall1.getCityName(),
                         maxValue));
    		}
    		 
    		
                    
         }
    	 
    }
}
