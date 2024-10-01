/*Task 1
 * Create an ATM Machine Simulation:

Your program should simulate the basic functions of an ATM machine.
Functions to include:
Account balance inquiry
Cash withdrawal
Cash deposit
PIN change
Transaction history
Program Specifications:

Use Java for your implementation.
Ensure your code is well-documented with comments explaining 
the functionality of each part.*/
package task1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATMSimulation {
	private double balance;
    private String pin;
    private List<String> transactionHistory;

    public ATMSimulation(String initialPin, double initialBalance) {
        this.pin = initialPin;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }
    
    // Method to check account balance
    public void checkBalance() {
        System.out.println("Your current balance is: Rs" + balance);
        transactionHistory.add("Checked balance: Rs" + balance);
    }

    // Method to withdraw cash
    public void withdrawCash(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("You have withdrawn: Rs" + amount);
            transactionHistory.add("Withdrew: Rs" + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
    
    // Method to deposit cash
    public void depositCash(double amount) {
        balance += amount;
        System.out.println("You have deposited: Rs" + amount);
        transactionHistory.add("Deposited: Rs" + amount);
    }

    // Method to change PIN
    public void changePin(String newPin) {
        this.pin = newPin;
        System.out.println("PIN changed successfully.");
    }
    
 // Method to display transaction history
    public void displayTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
    
 // Main method to simulate ATM operations
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATMSimulation atm = new ATMSimulation("1234", 1000.0); // Initial PIN and balance

        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Cash");
            System.out.println("3. Deposit Cash");
            System.out.println("4. Change PIN");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");
            System.out.print("Choose an option (1-6): ");
            
            int choice = scanner.nextInt();
            switch (choice) {
            case 1:
                atm.checkBalance();
                break;
            case 2:
                System.out.print("Enter amount to withdraw: Rs");
                double withdrawAmount = scanner.nextDouble();
                atm.withdrawCash(withdrawAmount);
                break;
            case 3:
                System.out.print("Enter amount to deposit: Rs");
                double depositAmount = scanner.nextDouble();
                atm.depositCash(depositAmount);
                break;
            case 4:
                System.out.print("Enter new PIN: ");
                String newPin = scanner.next();
                atm.changePin(newPin);
                break;
            case 5:
                atm.displayTransactionHistory();
                break;
            case 6:
                System.out.println("Thank you for using the ATM.");
                scanner.close();
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
       }
    }
  }
}
	
	
