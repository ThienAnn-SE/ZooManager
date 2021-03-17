/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repo.DAO;

import java.util.ArrayList;

/**
 *
 * @author Thien Ann
 * @param <T>
 */
public interface DataDao<T> {
    ArrayList<T> readFile(String t);
    void writeDataToFile(ArrayList<T> t,String name);
}
