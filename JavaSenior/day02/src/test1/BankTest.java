package test1;

/**
 * @author Chenyang
 * @create 2021-01-05-11:23
 */
public class BankTest {
    public static void main(String[] args) {
        Bank b = Bank.getInstance();
        System.out.println(b);
    }
}

class Bank {
    private Bank() {
    }

    private static Bank bank = null;

    public static synchronized Bank getInstance() {
        //效率较差
//        synchronized (Bank.class) {
//        if (bank == null) {
//            bank = new Bank();
//        }
//        return bank;
//    }
//    }
        //效率更高
        if (bank == null) {
            synchronized (Bank.class) {
                if (bank == null) {
                    bank = new Bank();
                }
            }
        }
        return bank;
    }
}
