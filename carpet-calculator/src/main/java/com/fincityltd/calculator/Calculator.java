package com.fincityltd.calculator;

import com.fincityltd.enums.City;
import com.fincityltd.interfaces.carpetPrices.Carpet;
import com.fincityltd.interfaces.floorTypes.Floor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Calculator {

    @Qualifier("carpetLondon")
    @Autowired
    private Carpet carpet;

    @Qualifier("kitchen")
    @Autowired
    private Floor floor;

    public String getTotalCarpetPrice(City city) throws Exception{
       BigDecimal cost = carpet.getCarpetPrice(city).multiply(floor.getArea());

       if(cost.compareTo(BigDecimal.ZERO)==0){
           throw new Exception("This city does not exist");
       }
       return "Total cost fro the carpet is: " + cost;
    }
}
