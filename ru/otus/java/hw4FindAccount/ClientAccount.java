package ru.otus.java.hw4FindAccount;

import java.util.Objects;

public class ClientAccount {
    private int money;
    private int accountNumber;
    public ClientAccount(int accountNumber, int money) {
        this.money=money;
        this.accountNumber=accountNumber;
    }

    @Override
    public String  toString () {
        return ("account:"+String.valueOf(accountNumber)+" money:"+ String.valueOf(money));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientAccount that = (ClientAccount) o;
        return money == that.money && accountNumber == that.accountNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money, accountNumber);
    }
}
