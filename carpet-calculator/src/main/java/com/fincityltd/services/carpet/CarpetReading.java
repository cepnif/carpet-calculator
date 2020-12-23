package com.fincityltd.services.carpet;

import com.fincityltd.enums.City;
import com.fincityltd.interfaces.carpetPrices.Carpet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class CarpetReading implements Carpet {

    private static final Map<City,BigDecimal> priceForCity = new HashMap<>();
    static {
        priceForCity.put(City.LONDON,new BigDecimal("5.02"));
        priceForCity.put(City.READING,new BigDecimal("5.23"));
        priceForCity.put(City.LIVERPOOL,new BigDecimal("6.53"));
    }

    @Override
    public BigDecimal getCarpetPrice(City city) {

        BigDecimal defaultValue = BigDecimal.ZERO;

        Optional<Map.Entry<City, BigDecimal>> collect = priceForCity.entrySet()
                .stream()
                .filter(x->x.getKey() == city).findFirst();

        return collect.isPresent() ? collect.get().getValue() : defaultValue;
    }
}
