package ru.otus.java.hw4FindAccount;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private ArrayList<Client> clients;
    private int i;
    public Bank (ArrayList<Client> clients) {
        this.clients = clients;
    }

    public List<ClientAccount> getAccounts (Client client) { // мы должны как-то получить элемент класса Клиента
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
