package com.fincityltd.services.floor;

import com.fincityltd.interfaces.floorTypes.Floor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Kitchen implements Floor {

    @Value("${radius}")
    BigDecimal radius;

    @Override
    public BigDecimal getArea() {
        return radius.multiply(radius).multiply(new BigDecimal(Math.PI));
    }
}
