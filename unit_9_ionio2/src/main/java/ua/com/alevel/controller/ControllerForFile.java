package ua.com.alevel.controller;

import ua.com.alevel.model.ModelForFile;
import ua.com.alevel.model.TypeForFile;
import ua.com.alevel.service.ServiceImpl;
import ua.com.alevel.service.ServiceForFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ControllerForFile {
    ServiceForFile fileService = new ServiceImpl();

    public void start() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the text  palindrome");
        String userInput;
        try {
            userInput = reader.readLine();
            ModelForFile modelForFile = new ModelForFile();
            modelForFile.setFileName(TypeForFile.INPUT.getFileName());
            modelForFile.setFileContent(userInput);
            modelForFile.setFileType(TypeForFile.INPUT);
            fileService.create(modelForFile);
            System.out.println();
            System.out.println(" Input was saved in input.txt ");
            navigation();
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void navigation() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Select 1 - to save in output.txt file");
        System.out.println("Select 2 - to verify  output.txt file");
        System.out.println("Select 3 - to verify input in input.txt file");
        System.out.println("Select 4 - to remove input.txt file");
        System.out.println("Select 5 - to remove output.txt file");
        System.out.println("Select 6 - to update your input");
        System.out.println("Select 0 - exit");
        String fileOption;
        try {
            while ((fileOption = reader.readLine()) != null) {
                crudFile(fileOption);
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void crudFile(String fileOption) {
        ModelForFile modelForFile = new ModelForFile();
        switch (fileOption) {
            case "1":
                modelForFile.setFileType(TypeForFile.OUTPUT);
                modelForFile.setFileName(TypeForFile.OUTPUT.getFileName());
                fileService.create(modelForFile);
                System.out.println("Input information saved in output.txt file");
                System.out.println();
                navigation();
                break;
            case "2":
                modelForFile.setFileType(TypeForFile.OUTPUT);
                modelForFile.setFileName(TypeForFile.OUTPUT.getFileName());
                String outputData = fileService.read(modelForFile.getFileName());
                printData(outputData);
                navigation();
                break;
            case "3":
                modelForFile.setFileType(TypeForFile.INPUT);
                modelForFile.setFileName(TypeForFile.INPUT.getFileName());
                String inputData = fileService.read(modelForFile.getFileName());
                printData(inputData);
                navigation();
                break;
            case "4":
                fileService.delete(TypeForFile.INPUT.getFileName());
                navigation();
                break;
            case "5":
                fileService.delete(TypeForFile.OUTPUT.getFileName());
                navigation();
                break;
            case "6":
                fileService.delete(TypeForFile.OUTPUT.getFileName());
                start();
                break;
            case "0":
                System.exit(1);
                break;
            default:
                System.out.println("Invalid value,  try again \n");
                navigation();

        }
    }

    private void printData(String content) {
        if(content!= null) {
            System.out.println(content);
            System.out.println();
        }
    }
}
