/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repo;

import java.util.ArrayList;

/**
 *
 * @author Thien Ann
 * @param <T>
 */
public interface AnimalDao<T> {
    
    void setList(ArrayList<T> t);
    
    ArrayList<T> getList();

    boolean isEmpty();
    
    int addAnimal(T t);
    
    int readAll();
    
    int getLocation();

    int showGroup(int t);
    
    int update(T t,int i);

    int delete(int i);

    int searchByWeight(double i,double a);
    
    int searchByName(String i);
    
    boolean checkValidId(String t);
    
}
