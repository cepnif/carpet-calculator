package com.fincityltd.interfaces.carpetPrices;

import com.fincityltd.enums.City;

import java.math.BigDecimal;

public interface Carpet {
    BigDecimal getCarpetPrice(City city);
}
