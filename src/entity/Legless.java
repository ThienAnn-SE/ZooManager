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
public class Legless extends Animal {

    private boolean posionous;

    public boolean isPosionous() {
        return posionous;
    }

    public void setPosionous(boolean posionous) {
        this.posionous = posionous;
    }

    public Legless(int fileCheck, String id, String name, double weight, String property, boolean posionous) {
        super(fileCheck, id, name, weight, property);
        this.posionous = posionous;
    }

    public Legless(boolean posionous, int fileCheck) {
        super(fileCheck);
        this.posionous = posionous;
    }

    public Legless(boolean posionous, String name, double weight, String property) {
        super(name, weight, property);
        this.posionous = posionous;
    }

    public Legless(boolean posionous) {
        this.posionous = posionous;
    }

    public Legless(int fileCheck, String id, String name, double weight, String property) {
        super(fileCheck, id, name, weight, property);
    }

    public Legless(int fileCheck) {
        super(fileCheck);
    }

    public Legless() {
    }

    @Override
    public String toString() {
        return String.format("ID: %s - name: %s - leg: 0 - ability: %s - posionous: %b - weight: %.2f", this.id, this.name, this.property, this.posionous, this.weight);
    }

    @Override
    public void input() {
        System.out.println("Enter name: ");
        this.setName(ValidInput.getValidateString());
        System.out.println("Enter weight: ");
        this.setWeight(ValidInput.getDouble());
        System.out.println("Enter ability: ");
        this.setProperty(ValidInput.getValidateString());
        System.out.println("Is it posion?");
        this.setPosionous(ValidInput.getBoolean());
    }

    @Override
    public void output() {
        System.out.println(toString());
    }

    @Override
    public String getData() {
        return String.format("%d/%s/%s/%f/%s/%b", this.fileCheck, this.id, this.name, this.weight, this.property, this.posionous);
    }
}
