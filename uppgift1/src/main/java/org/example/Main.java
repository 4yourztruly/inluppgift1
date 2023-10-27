package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean inMenu;
        boolean start = true;
        Account account = new Account("", "");
        Scanner scanner = new Scanner(System.in);
        int userCash = 0;


        while (start == true) {
            inMenu = true;
            System.out.println();
            System.out.println("Welcome To Maze Bank! If you want to leave enter: exit");
            System.out.println();
            System.out.println("Do you have an account?");
            String answer1 = scanner.nextLine();


            if (answer1.equalsIgnoreCase("exit")) {
                System.out.println("Exiting Maze Bank, Have a great day");
                start = false;
                break;
            } else if (answer1.equalsIgnoreCase("no")) {
                scanner = new Scanner(System.in);
                System.out.println("Please enter Username: ");
                String username = scanner.nextLine();
                account.setUsername(username);
                System.out.println("Your Username is: " + account.getUsername());
                System.out.println("Please enter Password: ");
                String password = scanner.nextLine();
                account.setPassword(password);
                System.out.println("Your Password is: " + account.getPassword());
                System.out.println();
            }
                System.out.println("Login To Maze Bank");
                System.out.println("Enter Username: ");
                String username1 = scanner.nextLine();
                System.out.println("Enter Password: ");
                String password1 = scanner.nextLine();

                if (username1.equalsIgnoreCase(account.getUsername()) && password1.equalsIgnoreCase(account.getPassword())) {
                    while (inMenu == true) {
                        System.out.println("Welcome to Maze Bank! You have " + userCash + " Would you like to Deposit, Withdraw or Log out?");
                        String userOption = scanner.nextLine();

                        if (userOption.equalsIgnoreCase("Deposit")) {
                            System.out.println("How much would you like to deposit?");
                            try {
                                int deposit = Integer.parseInt(scanner.nextLine());

                                userCash = userCash + deposit;

                                System.out.println("You added " + (deposit) + " Dollars in your account");
                            } catch (Exception e) {
                                System.out.println("Please enter a number");
                            }
                        } else if (userOption.equalsIgnoreCase("Withdraw")) {
                            System.out.println("You have " + userCash + " left in your account, how much would you like to withdraw");
                            try {
                                int withdraw = Integer.parseInt(scanner.nextLine());

                                if (userCash - withdraw >= 0) {

                                    System.out.println("You have withdrawn " + withdraw + " from " + userCash + " you have " + (userCash - withdraw) + " left");
                                    userCash = userCash - withdraw;
                                } else {
                                    System.out.println("You do not have enough money to withdraw " + withdraw);
                                }
                            } catch (Exception e) {
                                System.out.println("Please enter a number");
                            }
                        } else if (userOption.equalsIgnoreCase("log out")) {
                            System.out.println("Logging you out of our system... Have a wonderful day!");
                            inMenu = false;
                        } else {

                            System.out.println("Please enter deposit, withdraw or log out");
                        }
                    }

                } else {

                    System.out.println("Username or Password was incorrect");
                    //start = true;
                }

            }

        }
    }






