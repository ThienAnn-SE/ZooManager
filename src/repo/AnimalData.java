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
import repo.DAO.DataDao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Thien Ann
 */
public class AnimalData implements DataDao<Animal> {

    @Override
    public ArrayList<Animal> readFile(String filename) {
        FileReader file;
        try {
            file = new FileReader(filename);
        } catch (FileNotFoundException er) {
            return null;
        }
        ArrayList<Animal> list = new ArrayList<Animal>();
        BufferedReader buffer = new BufferedReader(file);
        String line;
        try {
            while ((line = buffer.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(line, "/");
                int _fileCheck = Integer.parseInt(stk.nextToken());
                String _id = stk.nextToken();
                String _name = stk.nextToken();
                double _weight = Double.parseDouble(stk.nextToken());
                String _ability = stk.nextToken();

                if (_fileCheck == 0) {
                    boolean _posion = Boolean.parseBoolean(stk.nextToken());
                    list.add(new Legless(_fileCheck, _id, _name, _weight, _ability, _posion));
                }
                if (_fileCheck == 1) {
                    String _enviroment = stk.nextToken();
                    list.add(new Flightless(_fileCheck, _id, _name, _weight, _ability, _enviroment));
                }
                if (_fileCheck == 2) {
                    double _height = Double.parseDouble(stk.nextToken());
                    list.add(new FlyingBidepal(_fileCheck, _id, _name, _weight, _ability, _height));
                }
                if (_fileCheck == 3) {
                    boolean _danger = Boolean.parseBoolean(stk.nextToken());
                    list.add(new FourLegs(_fileCheck, _id, _name, _weight, _ability, _danger));
                }
            }
            System.out.println("Data upload successful");
        } catch (IOException e) {
            System.out.println("IOException error");
        } finally {
            try {
                file.close();
                buffer.close();
            } catch (IOException e) {
                System.out.println("IOException error");
            }
        }
        return list;
    }

    @Override
    public void writeDataToFile(ArrayList<Animal> _MemberList, String filename) {
        if (_MemberList.isEmpty()) {
            System.out.println("List is empty");
        } else {
            try {
                File f = new File(filename);
                FileWriter fw = new FileWriter(f);
                PrintWriter pw = new PrintWriter(fw);
                for (int i = 0; i < _MemberList.size(); i++) {
                    if (_MemberList.get(i) instanceof Legless) {
                        pw.println(_MemberList.get(i).getData());
                    }
                    if (_MemberList.get(i) instanceof Flightless) {
                        pw.println(_MemberList.get(i).getData());
                    }
                    if (_MemberList.get(i) instanceof FlyingBidepal) {
                        pw.println(_MemberList.get(i).getData());
                    }
                    if (_MemberList.get(i) instanceof FourLegs) {
                        pw.println(_MemberList.get(i).getData());
                    }
                }

                pw.close();
                fw.close();
                System.out.println("Date save successful");
            } catch (IOException er) {
                System.out.println("Error");
            }
        }
    }

}
