/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package billcaculator;
 import java.util.Scanner;
 import model.Person;
 import model.Wallet;
/**
 *
 * @author Nguyen Manh
 */
public class BillCaculator {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Create Person
        Person person = new Person();

        System.out.println("====== Shopping program ==========");

        // Input number of bills
        System.out.print("input number of bill:");
        int numberOfBill = Integer.parseInt(scanner.nextLine());

        // Create array to store bills
        double[] bills = new double[numberOfBill];

        // Input value of each bill
        for (int i = 0; i < numberOfBill; i++) {

            System.out.print("input value of bill " + (i + 1) + ":");

            bills[i] = Double.parseDouble(scanner.nextLine());
        }

        // Input wallet amount
        System.out.print("input value of wallet:");

        double walletAmount =
                Double.parseDouble(scanner.nextLine());

        // Set money into wallet
        person.getWallet().setAmount(walletAmount);

        // Calculate total bill
        double totalBill = person.calculateTotalBill(bills);

        // Show result
        System.out.println("this is total of bill:" + (int) totalBill);

        if (person.canBuy(totalBill)) {

            System.out.println("You can buy it.");

        } else {

            System.out.println("You can’t buy it.");
        }

        scanner.close();
    }
}