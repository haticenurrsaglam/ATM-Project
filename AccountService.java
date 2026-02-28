import java.util.ArrayList;

public class AccountService {

    public Account login(ArrayList<Account> accountList,String inputAccNum,int inputPin){
        for(Account acc:accountList){
            if(acc.getAccountNumber().equals(inputAccNum) && acc.getPin()==inputPin){
               return acc;
            }
        }
        return null ;

    }

    public void deposit(Account account,double amount){
        if(amount > 0){
            double newBalance= account.getBalance()+ amount;
            account.setBalance(newBalance);
            System.out.println("Amount deposited:"+amount);
        }
    }

    public boolean withdraw(Account account,double amount) {
        if (amount > 0 && account.getBalance() >= amount) {
            if (account.getWithdrawnToday() + amount <= account.getDailyLimit()) {
                double newBalance = account.getBalance() - amount;
                account.setBalance(newBalance);
                account.setWithdrawnToday(account.getWithdrawnToday() + amount);
                return true;
            } else {
                System.out.println("Daily withdrawal limit exceeded!");
                System.out.println("Remaining Limit:" + (account.getDailyLimit() - account.getWithdrawnToday()) + "TL");
                return false;
            }

        } else {
            return false;
        }

    }

    public void transfer(Account fromAcc,Account toAcc,double amount){
        boolean isSuccess=withdraw(fromAcc,amount);
        if(isSuccess){
            deposit(toAcc,amount);
            System.out.println("Transfer Successful!");
            System.out.println(fromAcc.getOwnerName()+" -> "+toAcc.getOwnerName()+" : "+amount+" TL");
        }else{
            System.out.println("Transfer Failed! Insufficient balance or limit exceeded.");
        }
    }

    public Account findAccount(ArrayList<Account> accountList, String targetAccNum){
        for(Account acc:accountList){
            if(acc.getAccountNumber().equals(targetAccNum)){ return acc;}
        }
        return null;
    }

    public boolean changePin(Account account,int oldPin, int newPin){
        if(account.getPin() == oldPin){
            if(oldPin != newPin){
                account.setPin(newPin);
                return true;
            }else{
                System.out.println("ERROR: New PIN cannot be the same as old PIN.");
                return  false;
            }
        }else{
            System.out.println("ERROR: Current PIN is incorrect!");
            return false;
        }
    }
}
