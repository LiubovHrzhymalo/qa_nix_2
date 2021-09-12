package ua.com.alevel.entity;

import java.math.BigDecimal;

public final class Earth extends Planets {
    public Earth(){
        super(new BigDecimal(5.97*Math.pow(10,24)), new BigDecimal(6371000));
    }
}
