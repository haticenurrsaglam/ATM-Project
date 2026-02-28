import java.util.ArrayList;
import java.util.Scanner;
public class ATMApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Account> list = new ArrayList<>();
        AccountService service = new AccountService();
        Menu menu=new Menu(scanner);

        Account acc1 = new Account("TR001", "Ahmet Yılmaz ", 15000.0, 4579);
        Account acc2 = new Account("TR002", "Ayşe Demir", 8200.0, 3658);
        Account acc3 = new Account("TR003", "Nur Sağlam", 78000.0, 7564);
        Account acc4 = new Account("TR004", "Fatma Sevgi", 5000.0, 3456);
        Account acc5 = new Account("TR005", "Ali Korkmaz", 12000.0, 7890);

        list.add(acc1);
        list.add(acc2);
        list.add(acc3);
        list.add(acc4);
        list.add(acc5);

        System.out.println("Welcome to ATMApp");
        //login start
        int rights = 3;
        Account currentUser = null;

        while (rights > 0) {

            System.out.println("\nEnter Account Number:");
            String inputNum = scanner.next().toUpperCase();

            System.out.println("Enter PIN:");
            int inputPin = menu.getPin();

            if (inputPin == -1) {
                menu.showError("Please enter a valid number!");
                continue;  // Döngünün başına dön
            }

            currentUser = service.login(list, inputNum, inputPin);

            if (currentUser != null) {
                System.out.println("Login successful!");
                break;
            } else {
                rights--;
                System.out.println("Wrong account number or PIN! Rights: " + rights);

                if (rights == 0) {
                    System.out.println("Account blocked!");
                    return;
                }
            }
        }
            //login finish
                boolean isRunning = true;

                while (isRunning) {

                    menu.showMenu();
                    int choice = menu.getChoice();

                    switch (choice) {
                        case 1:
                            System.out.println("Current Balance:" + currentUser.getBalance() + "TL");
                            break;
                        case 2:
                            System.out.println("Enter amount to deposit:");
                            double depAmount = menu.getAmount();
                            if(depAmount <= 0){
                                menu.showError("Invalid Input!");
                            }else{
                            service.deposit(currentUser, depAmount);
                            menu.showSuccess("Deposit successful!");
                            System.out.println("Current Balance:" + currentUser.getBalance() + "TL");
                            }
                            break;
                        case 3:
                            System.out.println("Enter amount to withdraw:");
                            double withAmount = menu.getAmount();
                            if(withAmount <= 0){
                                menu.showError("Invalid Amount!");
                            }
                            else{
                            boolean result = service.withdraw(currentUser, withAmount);
                            if (result) {
                                menu.showSuccess("Please take your cash!");
                                System.out.println("Remaining Balance:" + currentUser.getBalance());
                            } else {
                                menu.showError("ERROR: Insufficient balance or invalid amount!");
                            }
                        }
                            break;
                        case 4:
                            System.out.println("Enter target account number:");
                            String targetAccNum = scanner.next().toUpperCase();

                            Account toAcc = service.findAccount(list, targetAccNum);

                            if (toAcc != null) {
                                System.out.println("Enter amount to transfer:");
                                double transferAmount = menu.getAmount();

                                service.transfer(currentUser, toAcc, transferAmount);
                                menu.showSuccess("Transfer succesful!");
                            } else {
                                menu.showError("Target account not found!");
                            }
                            break;
                        case 5:
                            System.out.println("Enter current PIN:");
                            int oldPin = menu.getPin();

                            if (oldPin == -1 ){
                                menu.showError("Invalid PIN Format");
                                break;
                            }
                            System.out.println("Enter new PIN:");
                            int newPin = menu.getPin();

                            if (newPin == -1 ){
                                menu.showError("Invalid PIN Format");
                                break;
                            }

                            if (oldPin < 1000 || oldPin > 9999 || newPin < 1000 || newPin > 9999) {
                                menu.showError("PIN must be 4 digits!");
                                break;
                            }

                            boolean isChange = service.changePin(currentUser, oldPin, newPin);

                            if (isChange) {
                                System.out.println("PIN updated successfully.");
                            } else {
                                System.out.println("PIN change failed!");
                            }
                            break;
                        case 6:
                            System.out.println("Thank you for using ATM. Goodbye!");
                            isRunning = false;
                            break;
                        default:
                            menu.showError("Invalid selection!");
                            break;
                    }
                }
        scanner.close();
        }
    }