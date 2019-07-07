package edu.mum.cs544.bank.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@SecondaryTable(name = "CustomerDetails", pkJoinColumns = @PrimaryKeyJoinColumn(name = "accountId"))
public class Account {

    @Id
    private long accountnumber;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fromAccountNumber")
    private Collection<AccountEntry> entryList = new ArrayList<AccountEntry>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(table = "CustomerDetails")
    private Customer customer;


    public Account(long accountnr) {
        this.accountnumber = accountnr;
    }

    public double getBalance() {
        double balance = 0;
        for (AccountEntry entry : entryList) {
            balance += entry.getAmount();
        }
        return balance;
    }

    public void deposit(double amount) {
        AccountEntry entry = new AccountEntry(new Date(), amount, "deposit", "", "");
        entryList.add(entry);
    }

    public void withdraw(double amount) {
        AccountEntry entry = new AccountEntry(new Date(), -amount, "withdraw", "", "");
        entryList.add(entry);
    }

    private void addEntry(AccountEntry entry) {
        entryList.add(entry);
    }

    public void transferFunds(Account toAccount, double amount, String description) {
        AccountEntry fromEntry = new AccountEntry(new Date(), -amount, description, "" + toAccount.getAccountnumber(), toAccount.getCustomer().getName());
        AccountEntry toEntry = new AccountEntry(new Date(), amount, description, "" + toAccount.getAccountnumber(), toAccount.getCustomer().getName());
        entryList.add(fromEntry);
        toAccount.addEntry(toEntry);
    }

}
