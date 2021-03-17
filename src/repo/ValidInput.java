/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repo;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class ValidInput {

    public static double getDouble() {
        double number = 0;
        Scanner sc = new Scanner(System.in);
        boolean check = false;
        do {
            try {
                number = Double.parseDouble(sc.nextLine());
                check = true;
            } catch (NumberFormatException n) {
                System.out.println("Only DOUBLE numeric input");
            }
        } while (check == false || number < 0);
        return number;
    }

    public static int getInt() {
        int n = 0;
        Scanner sc = new Scanner(System.in);
        boolean check = false;
        do {
            try {
                String ans = sc.nextLine();
                n = Integer.parseInt(ans);
                check = true;
            } catch (NumberFormatException a) {
                System.out.println("Only INT numeric input");
            }
        } while (check == false || n < 0);
        return n;
    }

    public static boolean getBoolean() {
        boolean n = false;
        Scanner sc = new Scanner(System.in);
        boolean check = false;
        do {
            try {
                String str;
                do {
                    String a = sc.nextLine();
                    str = a.toLowerCase();
                } while (!"true".equals(str) && !"false".equals(str));
                n = Boolean.parseBoolean(str);
                check = true;
            } catch (Exception a) {
                System.out.println("Only TRUE or FALSE input");
            }
        } while (check == false);
        return n;
    }

    public static String getString() {
        String n = null;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                n = sc.nextLine().trim();
            } catch (Exception e) {
                System.out.println("Exception happened!");
            }
        } while (n.isBlank());
        return n;
    }

    public static String getValidateString() {
        String n = null;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                n = sc.nextLine().trim();
            } catch (Exception e) {
                System.out.println("Exception happened!");
            }
        } while (n.isBlank() && validateString(n) == false);
        return n;
    }

    public static double getUpdateWeight() {
        double ans = 0;
        boolean check = false;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                String str = sc.nextLine();
                if (str.isBlank()) {
                    return -1;
                } else {
                    ans = Double.parseDouble(str);
                    check = true;
                }
            } catch (NumberFormatException er) {
                System.out.println("error");
            }
        } while (check == false | ans < 0);
        return ans;
    }

    public static String getUpdateString() {
        Scanner sc = new Scanner(System.in);
        String result = null;
        try {
            do {
                result = sc.nextLine();
            } while (validateString(result) == false);
        } catch (Exception er) {
            System.out.println("Error");
        }
        return result;
    }

    public static boolean validateString(String str) {
        str = str.toLowerCase();
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            if (!(ch >= 'a' && ch <= 'z') && !(ch == 32)) {
                return false;
            }
        }
        return true;
    }
}
