package ua.com.alevel.entity;

import java.math.BigDecimal;

public class Venus extends Planets{
    public Venus(){
        super(new BigDecimal(4.9*Math.pow(10,24)), new BigDecimal(6051500));
    }
}
