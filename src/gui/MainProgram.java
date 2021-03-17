/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.Scanner;
import repo.Service;

/**
 *
 * @author Thien Ann
 */
public class MainProgram {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Service animalList = new Service();
        Scanner sc = new Scanner(System.in);
        Menu option = new Menu();
        option.addChoice("1) Add new animal");
        option.addChoice("2) Update animal");
        option.addChoice("3) Delete animal");
        option.addChoice("4) Search animal");
        option.addChoice("5) Show animal list");
        option.addChoice("6) Exit");
        int choice;
        do {
            int ans;
            choice = option.printChoice();
            switch (choice) {
            case 1:
                boolean check = true;
                String getCheck;
                while (check == true) {
                    int result = animalList.addAnimal();
                    if (result == 1) {
                        System.out.println("Add new animal successful");
                    }
                    if (result == 0) {
                        System.out.println("Error happens");
                    }
                    if (result == -1) {
                        System.out.println("System failed");
                    }
                    System.out.println("Do you want to continues? (Y/N)");
                    do {
                        getCheck = sc.nextLine().toUpperCase();
                        if (getCheck.equals("N")) {
                            check = false;
                        }
                    } while (!getCheck.equals("N") && !getCheck.equals("Y"));
                }
                break;
            case 2:
                ans = animalList.update();
                if (ans == -1) {
                    System.out.println("This animal does not exit");
                    break;
                }
                if (ans == 1) {
                    System.out.println("Animal update success");
                    break;
                }
                if (ans == 2) {
                    System.out.println("Nothing update");
                    break;
                }
                if (ans == 0) {
                    System.out.println("Error happen");
                    break;
                }
                System.out.println("System fail");
                break;
            case 3:
                ans = animalList.delete();
                if (ans == 2) {
                    System.out.println("List is empty");
                }
                if (ans == -1) {
                    System.out.println("This ID does not exist");
                }
                if (ans == 1) {
                    System.out.println("Successful");
                }
                if (ans == 0) {
                    System.out.println("Error happen");
                }
                if (ans == -2) {
                    System.out.println("You don't delete this animal");
                }
                break;
            case 4:
                ans = animalList.search();
                if (ans == -1) {
                    System.out.println("List is empty");
                }
                if (ans == 1) {
                    System.out.println("Successful");
                }
                if (ans == -2) {
                    System.out.println("This animal does not exist");
                }
                if (ans == 0) {
                    System.out.println("Error happen");
                }
                break;

            case 5:
                ans = animalList.showAnimal();
                if (ans == -1) {
                    System.out.println("List is empty");
                }
                if (ans == -2) {
                    System.out.println("This group is empty");
                }
                if (ans == 0) {
                    System.out.println("Error happen");
                }
                break;
            case 6:
                animalList.saveData();
                System.out.println("Program closed");
                break;
            }
        } while (choice != 6);
        sc.close();
    }
}
