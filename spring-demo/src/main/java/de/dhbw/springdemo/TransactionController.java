package de.dhbw.springdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class TransactionController {

    private TransactionService transactionService;

    // Spring gibt den TransactionService automatisch hier rein
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/transactions")
    public List<Transaction> viewTransactions() {
        System.out.println("Transaktionen -> Thread: " + Thread.currentThread().getName());
        return transactionService.getTransactions();
    }

    @PostMapping("/transactions")
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        System.out.println("Neue Transaktion -> Thread: " + Thread.currentThread().getName());
        transactionService.addTransaction(transaction);
        return transaction;
    }

    @GetMapping("/report")
    public Map<String, Integer> viewReport() {
        String thread = Thread.currentThread().getName();
        System.out.println("Jahresbericht gestartet -> Thread: " + thread);
        Map<String, Integer> report = transactionService.createReport();
        System.out.println("Jahresbericht fertig -> Thread: " + thread);
        return report;
    }
}
