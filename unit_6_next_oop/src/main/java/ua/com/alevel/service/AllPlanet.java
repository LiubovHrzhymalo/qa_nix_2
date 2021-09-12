package ua.com.alevel.service;

import ua.com.alevel.entity.*;

import java.util.ArrayList;

public class AllPlanet {
    public static void print(Space space) {
        System.out.println(space.getClass().getSimpleName()+" "+space.getAccelerationOfGravity());
    }

    public static void printPlanet() {

        ArrayList<Space> PlanetsOfSpace = getPlanetsOfSpace();
        for (Space space : PlanetsOfSpace) {
            print(space);
        }
    }

    private static ArrayList<Space> getPlanetsOfSpace() {
        ArrayList<Space> spaces = new ArrayList<Space>();
        spaces.add(new Earth());
        spaces.add(new Jupiter());
        spaces.add(new Mars());
        spaces.add(new Mercury());
        spaces.add(new Neptune());
        spaces.add(new Pluton());
        spaces.add(new Saturn());
        spaces.add(new Uranus());
        spaces.add(new Venus());

        return spaces;
    }
}
