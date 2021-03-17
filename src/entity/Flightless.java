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
public class Flightless extends Animal {

    private String enviroment;

    public String getEnviroment() {
        return enviroment;
    }

    public void setEnviroment(String enviroment) {
        this.enviroment = enviroment;
    }

    public Flightless(int fileCheck, String id, String name, double weight, String property, String enviroment) {
        super(fileCheck, id, name, weight, property);
        this.enviroment = enviroment;
    }

    public Flightless(String enviroment, int fileCheck) {
        super(fileCheck);
        this.enviroment = enviroment;
    }

    public Flightless(String enviroment, String name, double weight, String property) {
        super(name, weight, property);
        this.enviroment = enviroment;
    }

    public Flightless(String enviroment) {
        this.enviroment = enviroment;
    }

    public Flightless(int fileCheck, String id, String name, double weight, String property) {
        super(fileCheck, id, name, weight, property);
    }

    public Flightless(int fileCheck) {
        super(fileCheck);
    }

    public Flightless() {
    }

    @Override
    public String toString() {
        return String.format("ID: %s - name: %s - 2 legs - 2 swings - ability: %s - enviroment : %s - weight: %.2f kg", this.id, this.name, this.property, this.enviroment, this.weight
        );
    }

    @Override
    public void input() {
        System.out.println("Enter name: ");
        this.setName(ValidInput.getValidateString());
        System.out.println("Enter weight (kg): ");
        this.setWeight(ValidInput.getDouble());
        System.out.println("Enter ability: ");
        this.setProperty(ValidInput.getValidateString());
        System.out.println("Enter enviroment: ");
        this.setEnviroment(ValidInput.getValidateString());
    }

    @Override
    public void output() {
        System.out.println(toString());
    }

    @Override
    public String getData() {
        return String.format("%d/%s/%s/%f/%s/%s", this.fileCheck, this.id, this.name, this.weight, this.property, this.enviroment);
    }
}
