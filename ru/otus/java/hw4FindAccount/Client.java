package ru.otus.java.hw4FindAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client {
    private String name;
    private int age;
    private List<ClientAccount> clientAccounts;

    public Client (String name, int age, ArrayList<ClientAccount> clientAccounts) {
        this.age=age;
        this.name = name;
        this.clientAccounts = clientAccounts;
    }
    public String getName() {
        return this.name;
    }
    public List <ClientAccount> getClientAccounts() {
        return this.clientAccounts;
    }
    public void addAccount(ClientAccount ac){
        clientAccounts.add(ac);
    }
    public int getNumOfAccounts() {
        return clientAccounts.size();
    }
    public ClientAccount getAccount(int i) {
        return clientAccounts.get(i);
    }

    @Override
    public String  toString () {
        return "Name "+ name + " "+"age:"+ String.valueOf(age); //+" "+ clientAccounts.toString();
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, age, clientAccounts);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return age == client.age && Objects.equals(name, client.name) && Objects.equals(clientAccounts, client.clientAccounts);
    }
}
