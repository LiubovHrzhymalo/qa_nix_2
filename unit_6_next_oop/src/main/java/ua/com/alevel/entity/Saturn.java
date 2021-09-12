package ua.com.alevel.entity;

import java.math.BigDecimal;

public class Saturn extends Planets{
    public Saturn(){
        super(new BigDecimal(5.7*Math.pow(10,26)), new BigDecimal(60268000));
    }
}
