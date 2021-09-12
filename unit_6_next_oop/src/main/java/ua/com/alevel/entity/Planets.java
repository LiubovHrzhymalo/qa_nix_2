package ua.com.alevel.entity;


import ua.com.alevel.service.Space;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Planets implements Space {
    private BigDecimal planetMass;
    private BigDecimal planetRadius;
    protected final BigDecimal GravityCalculation = new BigDecimal(6.67 * Math.pow(10, -11));

    public Planets(BigDecimal mass, BigDecimal radius) {
        this.planetMass = mass;
        this.planetRadius = radius;
    }

    public BigDecimal getPlanetMass() {

        return planetMass;
    }

    public BigDecimal getPlanetRadius() {

        return planetRadius;
    }

    public BigDecimal getGravityCalculation() {

        return GravityCalculation;
    }

    public BigDecimal getAccelerationOfGravity() {
        BigDecimal acceleration = getPlanetMass().multiply(GravityCalculation).divide(getPlanetRadius().pow(2), 2, RoundingMode.HALF_UP);
        return acceleration;
    }


}
