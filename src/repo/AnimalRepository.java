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
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Thien Ann
 */
public class AnimalRepository implements AnimalDao<Animal> {

    AnimalData file = new AnimalData();
    private ArrayList<Animal> list;
    Scanner sc = new Scanner(System.in);

    @Override
    public ArrayList<Animal> getList() {
        return list;
    }

    @Override
    public void setList(ArrayList<Animal> list) {
        this.list = list;
    }

    public AnimalRepository() {
        this.list = new ArrayList<Animal>();
    }

    public AnimalRepository(ArrayList<Animal> list) {
        this.list = list;
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int getLocation() {
        System.out.println("Enter ID: ");
        String _id = ValidInput.getString();
        for (int i = 0; i < this.list.size(); i++) {
            if (this.list.get(i).getId().equals(_id)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int addAnimal(Animal animal) {
        try {
            this.list.add(animal);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int readAll() {
        try {
            System.out.println("Here is your list: ");
            this.getList().forEach(p -> p.output());
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int showGroup(int choice) {
        try {
            boolean flag = false;
            for (Animal animal : list) {
                if (choice == 1) {
                    if (animal instanceof Legless) {
                        animal.output();
                        flag = true;
                    }
                }
                if (choice == 2) {
                    if (animal instanceof Flightless) {
                        animal.output();
                        flag = true;
                    }
                }
                if (choice == 3) {
                    if (animal instanceof FlyingBidepal) {
                        animal.output();
                        flag = true;
                    }
                }
                if (choice == 4) {
                    if (animal instanceof FourLegs) {
                        animal.output();
                        flag = true;
                    }
                }
            }
            if (flag == false) {
                return -2;
            }
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int update(Animal animal, int location) {
        boolean check = false;
        try {
            if (!animal.getName().isBlank()) {
                list.get(location).setName(animal.getName());
                check = true;
            }
            if (animal.getWeight() != -1) {
                list.get(location).setWeight(animal.getWeight());
                check = true;
            }
            if (!animal.getProperty().isBlank()) {
                list.get(location).setProperty(animal.getProperty());
                check = true;
            }
            if (list.get(location) instanceof Legless) {
                System.out.println("Does it posionous (Data will not change if you enter nothing)");
                Boolean _posionous = ValidInput.getBoolean();
                list.set(location, new Legless(0, list.get(location).getId(), list.get(location).getName(),
                        list.get(location).getWeight(), list.get(location).getProperty(), _posionous));
                check = true;
            }
            if (list.get(location) instanceof Flightless) {
                System.out.println("Enter new enviroment (Data will not change if you enter nothing)");
                String _enviroment = ValidInput.getUpdateString();
                if (!_enviroment.isBlank()) {
                    list.set(location, new Flightless(1, list.get(location).getId(), list.get(location).getName(),
                            list.get(location).getWeight(), list.get(location).getProperty(), _enviroment));
                    check = true;
                }
            }
            if (list.get(location) instanceof FlyingBidepal) {
                System.out.println("Enter new flying height (Data will not change if you enter nothing)");
                double _flyingHeight = ValidInput.getDouble();
                if (_flyingHeight != -1) {
                    list.set(location, new FlyingBidepal(2, list.get(location).getId(), list.get(location).getName(),
                            list.get(location).getWeight(), list.get(location).getProperty(), _flyingHeight));
                    check = true;
                }
            }
            if (list.get(location) instanceof FourLegs) {
                System.out.println("Does it danger (Data will not change if you enter nothing)");
                boolean _danger = ValidInput.getBoolean();
                list.set(location, new FourLegs(3, list.get(location).getId(), list.get(location).getName(),
                        list.get(location).getWeight(), list.get(location).getProperty(), _danger));
                check = true;

            }
            if (check == false) {
                return 2;
            }
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int delete(int location) {
        try {
            list.remove(location);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int searchByWeight(double min, double max) {
        boolean flag = false;
        try {
            for (Animal animal : list) {
                if (animal.getWeight() >= min && animal.getWeight() <= max) {
                    animal.output();
                    flag = true;
                }
            }
            if (flag == true) {
                return 1;
            }
            return -2;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int searchByName(String name) {
        boolean flag = false;
        try {
            for (Animal animal : list) {
                if (animal.getName().toLowerCase().trim().contains(name.toLowerCase().trim())) {
                    animal.output();
                    flag = true;
                }
            }
            if (flag == true) {
                return 1;
            } else {
                return -2;
            }
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public boolean checkValidId(String _id) {
        try {
            if (this.list.isEmpty() == true) {
                return false;
            } else {
                return list.stream().anyMatch((animal) -> (animal.getId().equals(_id)));
            }
        } catch (Exception e) {
            return false;
        }
    }
}
