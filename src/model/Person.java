/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Nguyen Manh
 */
public class Person {

    private Wallet wallet;

    public Person() {
        wallet = new Wallet();
    }

    public Person(Wallet wallet) {
        this.wallet = wallet;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    // Calculate total money of bills
    public double calculateTotalBill(double[] bills) {

        double total = 0;

        for (double bill : bills) {
            total += bill;
        }

        return total;
    }

    // Check whether user can buy
    public boolean canBuy(double totalBill) {

        return totalBill <= wallet.getAmount();
    }
}