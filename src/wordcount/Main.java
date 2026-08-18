package wordcount;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;


/**
 * Main class - Chỉ chứa hàm main để chạy chương trình
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter your content:");
        String content = scanner.nextLine();
        
        Validation validation = new Validation();
        
        System.out.println("Word count result:");
        validation.printWordCount(content);
        
        System.out.println("Character count result:");
        validation.printCharacterCount(content);
        
        scanner.close();
    }
}