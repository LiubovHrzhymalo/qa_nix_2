package ua.com.alevel.controller;

import ua.com.alevel.entity.*;
import ua.com.alevel.service.AllPlanet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {
    public static void start() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String userInput = "";
        try {
            while (true) {
                System.out.println("Select planet to calculate: ");
                runNavigation();
                userInput = reader.readLine();
                runPlanetsCalculation(userInput);
                System.exit(0);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void runNavigation() {
        System.out.println("Enter 1 for Earth");
        System.out.println("Enter 2 for Jupiter");
        System.out.println("Enter 3 for Mars");
        System.out.println("Enter 4 for Mercury");
        System.out.println("Enter 5 for Neptune");
        System.out.println("Enter 6 for Pluton");
        System.out.println("Enter 7 for Saturn");
        System.out.println("Enter 8 for Uranus");
        System.out.println("Enter 9 for Venus");
    }

    private static void runPlanetsCalculation(String input) {
        switch (input) {
            case "1":
                AllPlanet.print(new Earth());
                break;
            case "2":
                AllPlanet.print(new Jupiter());
                break;
            case "3":
                AllPlanet.print(new Mars());
                break;

            case "4":
                AllPlanet.print(new Mercury());
                break;
            case "5":
                AllPlanet.print(new Neptune());
                break;
            case "6":
                AllPlanet.print(new Pluton());
                break;
            case "7":
                AllPlanet.print(new Saturn());
                break;
            case "8":
                AllPlanet.print(new Uranus());
                break;
            case "9":
                AllPlanet.print(new Venus());
                break;


        }

    }
}
