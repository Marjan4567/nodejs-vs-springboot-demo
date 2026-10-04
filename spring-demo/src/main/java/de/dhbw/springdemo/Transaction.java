package de.dhbw.springdemo;

public class Transaction {

    private String title;
    private int amount;

    // Leerer Konstruktor: Spring braucht ihn, um das JSON vom Formular umzuwandeln
    public Transaction() {
    }

    public Transaction(String title, int amount) {
        this.title = title;
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }

    public int getAmount() {
        return amount;
    }

}
