package com.pluralsight.finance;

import java.util.Scanner;

public class FinanceApp {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Pam", "123", 12500);
        BankAccount account2 = new BankAccount("Gary", "456", 1500);
// try to deposit money into both accounts
        account1.deposit(100);
        account2.deposit(100);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Portfolio Management System!");

        System.out.print("Enter the name of the portfolio: ");
        String portfolioName = scanner.nextLine();

        System.out.print("Enter the name of the portfolio owner: ");
        String portfolioOwner = scanner.nextLine();

        Portfolio portfolio = new Portfolio(portfolioName, portfolioOwner);

        boolean continueAddingAssets = true;

        while (continueAddingAssets) {
            System.out.println("\nSelect the type of asset to add:");
            System.out.println("1. Gold");
            System.out.println("2. Jewelry");
            System.out.println("3. Credit Card");
            System.out.println("4. Finish adding assets");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the name of the Gold: ");
                    String goldName = scanner.nextLine();
                    System.out.print("Enter the value of the Gold: ");
                    double goldValue = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter the weight of the Gold: ");
                    double goldWeight = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    portfolio.add(new Gold(goldName, goldValue, goldWeight));
                    break;
                case 2:
                    System.out.print("Enter the name of the Jewelry: ");
                    String jewelryName = scanner.nextLine();
                    System.out.print("Enter the value of the Jewelry: ");
                    double jewelryValue = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter the karat of the Jewelry: ");
                    double jewelryKarat = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    portfolio.add(new Jewelry(jewelryName,jewelryValue,jewelryKarat));
                    break;
                case 3:
                    System.out.print("Enter the name of the Credit Card: ");
                    String creditCardName = scanner.nextLine();
                    System.out.print("Enter the account number of the Credit Card: ");
                    String creditCardAccountNumber = scanner.nextLine();
                    System.out.print("Enter the balance of the Credit Card: ");
                    double creditCardBalance = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    portfolio.add(new CreditCard(creditCardName, creditCardAccountNumber, creditCardBalance));
                    break;
                case 4:
                    continueAddingAssets = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }

        System.out.println("\nPortfolio Summary:");
        System.out.println("Portfolio Name: " + portfolio.getName());
        System.out.println("Portfolio Owner: " + portfolio.getOwner());
        System.out.println("Portfolio Value: " + portfolio.getValue());
        System.out.println("Most Valuable Asset: " + portfolio.getMostValuable().toString());
        System.out.println("Least Valuable Asset: " + portfolio.getLeastValuable().toString());
    }
}