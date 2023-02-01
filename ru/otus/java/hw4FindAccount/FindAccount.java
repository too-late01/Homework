package ru.otus.java.hw4FindAccount;
//  code => inspect code
// интерфейсы в методах (последний пример с урока по разбору кода)??

import java.util.*;

class BankSet {
    private Map<Client, List<ClientAccount>> clients = new HashMap<>(); // у вас было написано private final,
    // но через константу переменная класса не создавалась
    private Map<ClientAccount, Client> accounts = new HashMap<>();


    public BankSet(Map<Client, List<ClientAccount>> clients, Map<ClientAccount, Client> accounts) {
        this.clients = clients;
        this.accounts = accounts;
    }
    public List <ClientAccount> getAccounts (Client client) {
        return client.getClientAccounts();
    }
    public Client findClient(ClientAccount accountNumber) {
        Client showClient = null;
            System.out.println("Поиск клиента по номеру счета(use HashMap): "+accounts.get(accountNumber));
        return showClient;
    }
    public void addClientAccount(Client client, ClientAccount account) {
        accounts.put(account, client);
    }
}

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
           // ArrayList<ClientAccount> listAccount = clients.get(i).checkClientAccount();
            List<ClientAccount> listAccount = clients.get(i).getClientAccounts(); /*переделала с использованием этого метода.
            пока не сравнила, что они практически идентичны, не обращала внимания. */
            for (int j = 0; j < clients.get(i).getNumOfAccounts(); j++) {
                ClientAccount currentAccount = listAccount.get(j);
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

        System.out.println("========использование HashSet======");
        Map <Client, List <ClientAccount>> clientsMap = new HashMap<>();
        Map <ClientAccount, Client> accountsMap = new HashMap<>();
        clientsMap.put(client1, client1Account);
        clientsMap.put(client2, client2accounts);
        accountsMap.put(new ClientAccount(1,20), client1);
        accountsMap.put(new ClientAccount(2,30), client1);
        accountsMap.put(new ClientAccount(3,20), client2);
        accountsMap.put(new ClientAccount(4,30), client2);
        accountsMap.put(new ClientAccount(5,3000), client2);


        BankSet bankList = new BankSet(clientsMap, accountsMap);
        var client1accountsBankList = bankList.getAccounts(client1);
        System.out.println("Счета 1 клиента (use HashMap): "+client1accountsBankList);

        var accountofClient1BankList = bankList.findClient(new ClientAccount(4,30));//Max)


    }


    }


