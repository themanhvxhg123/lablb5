package View;

import java.util.Scanner;

/**
 *
 * @author Nangnth
 */
public class InputData {
    // Nhập 1 số nguyên
    public int inputInteger(String mess, String regex){
        Scanner scn = new Scanner(System.in);
        System.out.println(mess);
        while(true){
            String number = scn.nextLine();
            if(number.matches(regex)){
                return Integer.parseInt(number);
            } else
                System.out.println("Please input integer with format: " + regex);
        } 
    }
    
    // Nhập 1 chuỗi
    public String inputString(String mess, String regex){
        Scanner scn = new Scanner(System.in);
        System.out.println(mess);
        while(true){
            String str = scn.nextLine().trim();
            if(str.matches(regex) && !str.matches("\\s*")){
                return str;
            }    
            else 
                System.out.println("Please input string with format: " + regex);
        }    
    }
}