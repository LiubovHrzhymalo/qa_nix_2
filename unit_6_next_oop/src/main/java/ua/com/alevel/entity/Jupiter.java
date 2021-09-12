package ua.com.alevel.entity;

import java.math.BigDecimal;

public class Jupiter extends Planets{
    public Jupiter(){
        super(new BigDecimal(1.9*Math.pow(10,24)), new BigDecimal(71992000));
    }
}
