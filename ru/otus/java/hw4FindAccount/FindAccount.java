package ru.otus.java.hw4FindAccount;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Bank {
    private ArrayList<Client> clients;
    private int i;
    public Bank (ArrayList<Client> clients) {
        this.clients = clients;
    }

    public List <ClientAccount> getAccounts (Client client) { // мы должны как-то получить элемент класса Клиента
       return client.getClientAccounts(); // не нужно создавать отдельный массив и перебором закидывать в него счета, если в класе Клиент счета уже хранятся в массиве. Просто вытаскивать из клааса этот элементомассив
    }

    public Client findClient(ClientAccount accountNumber) {
       Client showClient = null;
        for (int i = 0; i < clients.size(); i++) {
            ArrayList<ClientAccount> listAccount = clients.get(i).checkClientAccount();
            for (int j = 0; j < clients.get(i).getNumOfAccounts(); j++) {
               // System.out.println(listAccount);
                ClientAccount currentAccount = listAccount.get(j);
                //System.out.println("number "+accountNumber);
                if (accountNumber.equals(currentAccount)) {
                   showClient = clients.get(i);
                   //System.out.println(clients.get(i));
                   return showClient;
                }
              else showClient = null;

            }
        }
        return showClient;
    }
}

class Client {
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
    public ArrayList<ClientAccount> checkClientAccount () {
        return (ArrayList<ClientAccount>) this.clientAccounts;
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

class ClientAccount {
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

public class FindAccount {
    public static void main (String[] args ) {

        ArrayList<ClientAccount> client1Account = new ArrayList<>();
        client1Account.add(0,new ClientAccount(1,20));
        client1Account.add(1,new ClientAccount(2,30));
        ArrayList<ClientAccount> client2Account = new ArrayList<>();
        client2Account.add(0,new ClientAccount(3,20));
        client2Account.add(1,new ClientAccount(4,30));
        client2Account.add(2,new ClientAccount(5,3000));
        Client client1 = new Client("Julia", 20,client1Account);
        Client client2 = new Client("Max", 30,client2Account);
        ArrayList<Client> clients = new ArrayList<>();
        clients.add(0,client1);
        clients.add(1,client2);

        Bank bank = new Bank(clients);
        var client1accounts = bank.getAccounts(client1);
        var client2accounts = bank.getAccounts(client2);


        var accountsofClient1 = bank.findClient (new ClientAccount(2,30));// Julia (номер счета)
        var accountofClient2 = bank.findClient (new ClientAccount(4,30));//Max
        
        System.out.println("Счета 1 клиента: "+client1accounts);
        System.out.println("Счета 2 клиента: "+client2accounts);
        System.out.println("Поиск клиента по счету 2: "+accountsofClient1);
        System.out.println("Поиск клиента по счету 4: "+accountofClient2);
        }

    }


