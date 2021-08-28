package ua.com.alevel.conroller;

import ua.com.alevel.entity.Owner;
import ua.com.alevel.entity.service.PetService;
//import ua.com.alevel.service.PetService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class PetController {

    private PetService petService = new PetService();

    public void start() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("select your option");
        String position;
        try {
            runNavigation();
            while ((position = reader.readLine()) != null) {
                crud(position, reader);
                position = reader.readLine();
                if (position.equals("0")) {
                    System.exit(0);
                }
                crud(position, reader);
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void runNavigation() {
        System.out.println();
        System.out.println("if you want create user, please enter 1");
        System.out.println("if you want update user, please enter 2");
        System.out.println("if you want delete user, please enter 3");
        System.out.println("if you want findById user, please enter 4");
        System.out.println("if you want findAll user, please enter 5");
        System.out.println("if you want exit, please enter 0");
        System.out.println();
    }

    private void crud(String position, BufferedReader reader) {
        switch (position) {
            case "1" : create(reader); break;
            case "2" : update(reader); break;
            case "3" : delete(reader); break;
            case "4" : findById(reader); break;
            case "5" : findAll(reader); break;
        }
        runNavigation();
    }

    private void create(BufferedReader reader) {
        System.out.println("UserController.create");
        try {
            System.out.println("Please, enter your name");
            String name = reader.readLine();
            System.out.println("Please, enter your age");
            String ageString = reader.readLine();
            int age = Integer.parseInt(ageString);
            Owner owner = new Owner();
            owner.setAge(age);
            owner.setNamePet(name);
            petService.creat(owner);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void update(BufferedReader reader) {
        System.out.println("UserController.update");
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            System.out.println("Please, enter your name");
            String name = reader.readLine();
            System.out.println("Please, enter your age");
            String ageString = reader.readLine();
            int age = Integer.parseInt(ageString);
            Owner owner = new Owner();
            owner.setId(id);
            owner.setAge(age);
            owner.setNamePet(name);
            petService.update(owner);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void delete(BufferedReader reader) {
        System.out.println("UserController.delete");
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            petService.delete(id);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findById(BufferedReader reader) {
        System.out.println("UserController.findById");
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            Owner owner = petService.findById(id);
            System.out.println("owner = " + owner);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findAll(BufferedReader reader) {
        System.out.println("UserController.findAll");
        List<Owner> pets = petService.findAll();
        for (Owner pet : pets) {
            System.out.println("owner = " + pet);
        }
    }
}