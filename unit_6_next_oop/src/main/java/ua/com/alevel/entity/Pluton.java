package ua.com.alevel.entity;

import java.math.BigDecimal;

public class Pluton extends Planets{
    public Pluton(){
        super(new BigDecimal(1.3*Math.pow(10,24)), new BigDecimal(1195000));
    }
}
