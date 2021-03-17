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
public class FlyingBidepal extends Animal {

    private double flyingHeight;

    public double getHigh() {
        return flyingHeight;
    }

    public void setHigh(double high) {
        this.flyingHeight = high;
    }

    public FlyingBidepal(int fileCheck, String id, String name, double weight, String property, double flyingHeight) {
        super(fileCheck, id, name, weight, property);
        this.flyingHeight = flyingHeight;
    }

    public FlyingBidepal(double flyingHeight, int fileCheck) {
        super(fileCheck);
        this.flyingHeight = flyingHeight;
    }

    public FlyingBidepal(double flyingHeight, String name, double weight, String property) {
        super(name, weight, property);
        this.flyingHeight = flyingHeight;
    }

    public FlyingBidepal(double flyingHeight) {
        this.flyingHeight = flyingHeight;
    }

    public FlyingBidepal(int fileCheck, String id, String name, double weight, String property) {
        super(fileCheck, id, name, weight, property);
    }

    public FlyingBidepal(int fileCheck) {
        super(fileCheck);
    }

    public FlyingBidepal() {
    }

    @Override
    public String toString() {
        return String.format("ID: %s - name: %s - 2 legs - 2 swings - ability: %s - can fly - flying height: %.2f - weight: %.2f", this.id, this.name, this.property, this.flyingHeight, this.weight);

    }

    @Override
    public void input() {
        System.out.println("Enter name: ");
        this.setName(ValidInput.getValidateString());
        System.out.println("Enter weight: ");
        this.setWeight(ValidInput.getDouble());
        System.out.println("Enter ability: ");
        this.setProperty(ValidInput.getValidateString());
        System.out.println("Enter the flying high: ");
        this.setHigh(ValidInput.getDouble());
    }

    @Override
    public void output() {
        System.out.println(toString());
    }

    @Override
    public String getData() {
        return String.format("%d/%s/%s/%f/%s/%f", this.fileCheck, this.id, this.name, this.weight, this.property, this.flyingHeight);
    }
}
