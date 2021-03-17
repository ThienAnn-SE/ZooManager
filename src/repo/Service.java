/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repo;

import entity.Animal;
import entity.Flightless;
import entity.FlyingBidepal;
import entity.FourLegs;
import entity.Legless;
import gui.Menu;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Service {

    private final DataDao<Animal> file;
    private final AnimalDao<Animal> list;

    public Service() {
        file = new AnimalData();
        list = new AnimalRepository(file.readFile("D:\\JavaVSProject\\Java\\ZooManager\\src\\AnimalData.txt"));
    }

    public int addAnimal() {
        try {
            Menu animalGroup = new Menu();
            animalGroup.addChoice("1) Group of 0-legged animals");
            animalGroup.addChoice("2) Group of bipedal and flightless animals");
            animalGroup.addChoice("3) Group of bipedal and flying animals");
            animalGroup.addChoice("4) Group of 4-legged animals");
            int animalChoice = animalGroup.printChoice();
            String _id;
            System.out.println("Enter Animal ID: ");
            do {
                _id = ValidInput.getString();
                if (list.checkValidId(_id) == true) {
                    System.out.println("This ID is already exist");
                }
            } while (list.checkValidId(_id) == true);
            if (animalChoice == 1) {
                Animal ani1 = new Legless(0);
                ani1.input();
                ani1.setId(_id);
                return list.addAnimal(ani1);
            }
            if (animalChoice == 2) {
                Animal ani2 = new Flightless(1);
                ani2.input();
                ani2.setId(_id);
                return list.addAnimal(ani2);
            }
            if (animalChoice == 3) {
                Animal ani3 = new FlyingBidepal(2);
                ani3.input();
                ani3.setId(_id);
                return list.addAnimal(ani3);
            }
            if (animalChoice == 4) {
                Animal ani4 = new FourLegs(3);
                ani4.input();
                ani4.setId(_id);
                return list.addAnimal(ani4);
            }
            return -1;
        } catch (Exception er) {
            return 0;
        }
    }

    public int showAnimal() {
        if (list.isEmpty()) {
            return -1;
        } else {
            Menu showType = new Menu();
            showType.addChoice("1) Show by group");
            showType.addChoice("2) Show all");
            int choice = showType.printChoice();
            if (choice == 1) {
                Menu animalGroup = new Menu();
                animalGroup.addChoice("1) Group of 0-legged animals");
                animalGroup.addChoice("2) Group of bipedal and flightless animals");
                animalGroup.addChoice("3) Group of bipedal and flying animals");
                animalGroup.addChoice("4) Group of 4-legged animals");
                return list.showGroup(animalGroup.printChoice());
            } else {
                return list.readAll();
            }
        }
    }

    public int update() {
        int location = list.getLocation();
        String _name;
        String _property;
        double _weight;
        try {
            if (location == -1) {
                return -1;
            } else {
                System.out.println("Enter new name (Data will not change if you enter nothing)");
                _name = ValidInput.getUpdateString();
                System.out.println("Enter new weight (Data will not change if you enter nothing)");
                _weight = ValidInput.getUpdateWeight();
                System.out.println("Enter new property (Data will not change if you enter nothing)");
                _property = ValidInput.getUpdateString();
                return list.update(new Animal(_name, _weight, _property), location);
            }
        } catch (Exception e) {
            return 0;
        }
    }

    public int delete() {
        Scanner sc = new Scanner(System.in);
        try {
            if (list.isEmpty() == true) {
                return 2;
            }
            int _id = list.getLocation();
            String getCheck;
            if (_id == -1) {
                return -1;
            }
            System.out.println("Are you really want to delete ? Y/N");
            do {
                getCheck = sc.nextLine().toUpperCase();
            } while (!getCheck.equals("N") && !getCheck.equals("Y"));
            if (getCheck.equals("Y")) {
                return list.delete(_id);
            }
            return -2;
        } catch (Exception e) {
            return 0;
        }
    }

    public int search() {
        if (list.isEmpty() == true) {
            return -1;
        }
        Menu searchType = new Menu();
        searchType.addChoice("1) Search by weight");
        searchType.addChoice("2) Search by name");
        int choice = searchType.printChoice();
        Scanner sc = new Scanner(System.in);
        if (choice == 1) {
            double min, max;
            System.out.println("Enter the min weight: ");
            do {
                min = ValidInput.getDouble();
            } while (min < 0);
            System.out.println("Enter the max weight");
            do {
                max = ValidInput.getDouble();
            } while (max < min);
            return list.searchByWeight(min, max);
        } else {
            String name;
            System.out.println("Enter name you want to search: ");
            do {
                name = sc.nextLine();
            } while (name.isBlank());
            return list.searchByName(name);
        }
    }

    public void saveData() {
        try {
            file.writeDataToFile(list.getList(), "D:\\JavaVSProject\\Java\\ZooManager\\src\\AnimalData.txt");
        } catch (Exception er) {
            System.out.println("Error");
        }
    }
}
