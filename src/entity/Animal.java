/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Admin
 */
public class Animal {

    protected int fileCheck;
    protected String id;
    protected String name;
    protected double weight;
    protected String property;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getFileCheck() {
        return fileCheck;
    }

    public void setFileCheck(int fileCheck) {
        this.fileCheck = fileCheck;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public Animal(int fileCheck, String id, String name, double weight, String property) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.property = property;
        this.fileCheck = fileCheck;
    }

    public Animal(int fileCheck) {
        this.fileCheck = fileCheck;
    }

    public Animal(String name, double weight, String property) {
        this.name = name;
        this.weight = weight;
        this.property = property;
    }

    public Animal() {
    }

    public void input() {
    }

    public void output() {
    }

    public String getData() {
        return null;
    }
}
