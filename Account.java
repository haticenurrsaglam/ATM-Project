public class Account {
    private String accountNumber;
    private String ownerName;
    private double balance;
    private int pin;
    private double dailyLimit;
    private double withdrawnToday;

    Account(String accNum,String name,double bal,int pin){
        this.accountNumber=accNum;
        this.ownerName=name;
        this.balance=bal;
        this.pin=pin;
        this.dailyLimit=5000.0;
        this.withdrawnToday=0.0;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setBalance(double balance) {this.balance = balance;}

    public String getOwnerName() {return ownerName;}

    public int getPin() {return pin;}

    public void setPin(int pin){this.pin=pin;}

    public double getDailyLimit() {return dailyLimit;}

    public double getWithdrawnToday() {return withdrawnToday;}

    public void setWithdrawnToday(double amount) {this.withdrawnToday = amount;}
}
