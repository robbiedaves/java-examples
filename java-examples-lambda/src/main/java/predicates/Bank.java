package predicates;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Bank {

    List<Account> accounts = new ArrayList<>();

    public void testBank() {
        accounts.add(new Account("David Smith", 100, "dave.smith@mail.com"));
        accounts.add(new Account("Jane Jones", 500, "jane.jones@mail.com"));
        accounts.add(new Account("Jack Davies", -400, "jack.davies@mail.com"));
        accounts.add(new Account("Sally Evans", 1200, "sally.evans@mail.co.uk"));

        printAccounts(getAccounts(acc -> true),  "All accounts");
        printAccounts(getAccounts(acc -> acc.getBalance() > 300),  "Accounts with balances > 300");
        printAccounts(getAccounts(acc -> acc.getBalance() < 0), "Accounts in overdraft");
        printAccounts(getAccounts(acc -> acc.getEmail().endsWith(".co.uk")), "Accounts with co.uk email address");
        printAccounts(getAccounts(acc -> acc.getName().contains("Jack")), "Accounts with names containing jack");
    }

    public void printAccounts(List<Account> accs, String listTitle) {
        System.out.println(listTitle);
        accs.forEach(acc -> System.out.println(acc));
    }

    public List<Account> getAccounts(Predicate<Account> filter) {
        List<Account> accs = new ArrayList<>();
        for (Account acc : accounts)  {
            if (filter.test(acc)) {
                accs.add(acc);
            }
        }
        return accs;
    }
}