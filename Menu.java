import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void showMenu(){
        System.out.println("\n========== MENU ==========");
        System.out.println("\n1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transfer");
        System.out.println("5. Change PIN");
        System.out.println("6. Exit");
        System.out.print("Your choice: ");
    }

    public int getChoice(){
        try{
            return scanner.nextInt();
        }catch (InputMismatchException e ){
            scanner.nextLine();
            return -1;

        }
    }

    public double getAmount() {
        try {
            return scanner.nextDouble();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            return -1;
        }
    }

    public int getPin() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            return -1;
        }
    }


    public void showError(String message) {
        System.out.println("ERROR: " + message);
    }

    public void showSuccess(String message) {
        System.out.println("SUCCESS: " + message);
    }

}
