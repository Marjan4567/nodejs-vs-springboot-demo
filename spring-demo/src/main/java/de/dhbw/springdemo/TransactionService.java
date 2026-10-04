package de.dhbw.springdemo;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TransactionService {

    private List<Transaction> transactions = new ArrayList<>();

    public TransactionService() {
        transactions.add(new Transaction("Gehalt", 3000));
        transactions.add(new Transaction("Miete", -800));
        transactions.add(new Transaction("Netflix Abo", -10));
        transactions.add(new Transaction("Steuerrückzahlung", 1500));
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public Map<String, Integer> createReport() {
        // Jahresbericht: Auswertung dauert 5 Sekunden (der Server RECHNET)
        long end = System.currentTimeMillis() + 5000;
        while (System.currentTimeMillis() < end) {
            // rechnen ...
        }

        int income = 0;
        int expenses = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getAmount() >= 0) {
                income = income + transaction.getAmount();
            } else {
                expenses = expenses + transaction.getAmount();
            }
        }
        return Map.of("income", income, "expenses", expenses, "balance", income + expenses);
    }
}
