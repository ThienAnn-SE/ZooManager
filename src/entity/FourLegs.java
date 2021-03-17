/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import repo.ValidInput;

/**
 *
 * @author Admin
 */
public class FourLegs extends Animal {

    private boolean danger;

    public boolean isDanger() {
        return danger;
    }

    public void setDanger(boolean danger) {
        this.danger = danger;
    }

    public FourLegs(int fileCheck, String id, String name, double weight, String property, boolean danger) {
        super(fileCheck, id, name, weight, property);
        this.danger = danger;
    }

    public FourLegs(String food, boolean danger, int fileCheck) {
        super(fileCheck);
    }

    public FourLegs(boolean danger, String name, double weight, String property) {
        super(name, weight, property);
        this.danger = danger;
    }

    public FourLegs(boolean danger) {
        this.danger = danger;
    }

    public FourLegs(int fileCheck, String id, String name, double weight, String property) {
        super(fileCheck, id, name, weight, property);
    }

    public FourLegs(int fileCheck) {
        super(fileCheck);
    }

    public FourLegs() {
    }

    @Override
    public String toString() {
        return String.format("ID: %s - name: %s - leg: 4 - danger: %b - ability: %s - weight: %.2f kg", this.id, this.name,
                this.danger, this.property, this.weight);
    }

    @Override
    public void input() {
        System.out.println("Enter name: ");
        this.setName(ValidInput.getValidateString());
        System.out.println("Enter weight (kg): ");
        this.setWeight(ValidInput.getDouble());
        System.out.println("Enter ability: ");
        this.setProperty(ValidInput.getValidateString());
        System.out.println("Is it danger? (true/false)");
        this.setDanger(ValidInput.getBoolean());
    }

    @Override
    public void output() {
        System.out.println(toString());
    }

    @Override
    public String getData() {
        return String.format("%d/%s/%s/%f/%s/%b", this.fileCheck, this.id, this.name, this.weight, this.property,
                this.danger);
    }
}
