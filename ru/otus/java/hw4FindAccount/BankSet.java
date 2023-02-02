package ru.otus.java.hw4FindAccount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankSet {
    private Map<Client, List<ClientAccount>> clients = new HashMap<>(); // у вас было написано private final,
    // но через константу переменная класса не создавалась
    private Map<ClientAccount, Client> accounts = new HashMap<>();


    public BankSet(Map<Client, List<ClientAccount>> clients, Map<ClientAccount, Client> accounts) {
        this.clients = clients;
        this.accounts = accounts;
    }

    public List<ClientAccount> getAccounts(Client client) {
        return client.getClientAccounts();
    }

    public Client findClient(ClientAccount accountNumber) {
        Client showClient = null;
        System.out.println("Поиск клиента по номеру счета(use HashMap): " + accounts.get(accountNumber));
        return showClient;
    }

    public void addClientAccount(Client client, ClientAccount account) {
        accounts.put(account, client);
        List<ClientAccount> clientAccountAddition = clients.get(client);
        if (clientAccountAddition!=null) {
            clientAccountAddition.add(account);
            clients.put(client, clientAccountAddition);
        } else {clientAccountAddition = new ArrayList<>();
            clientAccountAddition.add(account);
            clients.put(client, clientAccountAddition);
        }
    }


    @Override
    public String  toString () {
        return "clients "+String.valueOf(clients); // +"accounts " + String.valueOf(accounts);
    }
}
