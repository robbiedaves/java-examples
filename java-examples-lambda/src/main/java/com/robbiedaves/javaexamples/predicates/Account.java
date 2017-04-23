package com.robbiedaves.javaexamples.predicates;


public class Account {

    private String name;
    private Integer balance;
    private String email;

    public Account(String n, Integer b, String e) {
        name = n;
        balance = b;
        email = e;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Integer getBalance() { return balance; }
    public void setBalance(Integer balance) { this.balance = balance; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                ", email='" + email + '\'' +
                '}';
    }
}
