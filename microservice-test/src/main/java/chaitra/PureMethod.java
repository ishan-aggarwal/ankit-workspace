package chaitra;

public class PureMethod {


    public Employee processInput(final Employee emp) {
        return null;
    }

    public BankAccount debit(BankAccount account) {
        double balance = account.getBalance();
        account.setBalance(account.getBalance() - 10000);
       account = new BankAccount(12,23);
        return null;
    }



}
