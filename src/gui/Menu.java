/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.ArrayList;
import repo.ValidInput;

/**
 *
 * @author Thien Ann
 */
public class Menu {

    /**
     *
     * @author Admin
     */
    private ArrayList<String> option;

    public ArrayList<String> getOption() {
        return option;
    }

    public void setOption(ArrayList<String> option) {
        this.option = option;
    }

    public Menu(ArrayList<String> option) {
        this.option = option;
    }

    public Menu() {
        option = new ArrayList<>();
    }

    public void addChoice(String e) {
        this.option.add(e);
    }

    public int printChoice() {
        int n;
        System.out.println("\n======================================");
        for (int i = 0; i < this.option.size(); i++) {
            System.out.println(this.option.get(i));
        }
        System.out.println("======================================");
        System.out.println("Enter choice: ");
        do {
            n = ValidInput.getInt();
        } while (n < 1 || n > this.option.size());
        System.out.println();
        return n;
    }

}
