package ru.otus.java.hw4FindAccount;
//  code => inspect code
// интерфейсы в методах (последний пример с урока по разбору кода)??

import java.util.*;
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

        System.out.println("Добавление счета к существующему клиенту");
        bankList.addClientAccount(client1, new ClientAccount(6, 500));
        System.out.println(bankList);

        System.out.println("Добавление счета к несуществующему клиенту");
        ArrayList<ClientAccount> client3Account = new ArrayList<>();
        Client client3 = new Client("Alma", 25,client3Account);
        bankList.addClientAccount(client3, new ClientAccount(7, 50));
        System.out.println(bankList);


    }


    }


