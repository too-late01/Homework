package ru.otus.java;


import java.util.*;

class Client {
    private String client;
    private ClientAge age;
    private ClientAccount account;
    private List <ClientAccount> accounts = new ArrayList<ClientAccount>();
    private List <ClientAge> ages = new ArrayList<ClientAge>();

    public Client (String client){
        this.client= client;
       // this.age = age;
    }

    @Override
    public String toString (){
        return client;
    }

    public void addAccount (ClientAccount account) {
        accounts.add(account);
    }
    public void addAge (ClientAge age) {
        ages.add(age);
    }
    public int getNumOfAccounts() {
        return accounts.size();
    }
    public String getClient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберете клиента из списка:"+"" +
                ""+client);
        String client = scanner.next();
        return client;
    }
    public ClientAccount getAccount(int i) {
        return accounts.get(i);
    }
    public void showAccount () {
        String chooseClient = getClient();
        for (int i = 0; i < accounts.size(); i++) {
            if (chooseClient.equals(accounts))
            System.out.println(accounts.get(i));
        }
    }
}

class ClientAge {
    private int age;
    public ClientAge (int age) {
        this.age = age;
    }
    @Override
    public String  toString () {
        return String.valueOf(age);
    }
}
class ClientAccount {
    private int account;

    public ClientAccount(int account) {
        this.account = account;
    }
    @Override
    public String  toString () {
        return String.valueOf(account);
    }
}
public class HWFindBankAccount {
    public static void main(String[] args) {
        Set<Client> bank = new HashSet<>();
        Client linkClient;
        linkClient = new Client("Jane");
        linkClient.addAge(new ClientAge(20));
        linkClient.addAccount(new ClientAccount(1000001));
        linkClient.addAccount(new ClientAccount(1000003));
        bank.add(linkClient);
        linkClient = new Client("Max");
        linkClient.addAge(new ClientAge(25));
        linkClient.addAccount(new ClientAccount(10000002));
        bank.add(linkClient);


        System.out.println(bank);
        Client chooseClient = new Client(" ");
                chooseClient.showAccount();



    }


}
