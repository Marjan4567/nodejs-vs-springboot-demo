const express = require('express');
const app = express();

app.use(express.json());            // JSON vom Browser lesen
app.use(express.static('public'));  // index.html aus dem Ordner "public" ausliefern

// Unsere Daten
const transactions = [
    { title: 'Gehalt', amount: 3000 },
    { title: 'Miete', amount: -800 },
    { title: 'Netflix Abo', amount: -10 },
    { title: 'Steuerrückzahlung', amount: 1500 },
];

// Alle Transaktionen anzeigen
app.get('/transactions', (req, res) => {
    console.log('Transaktionen -> Thread: main');
    res.json(transactions);
});

// Neue Transaktion speichern
app.post('/transactions', (req, res) => {
    console.log('Neue Transaktion -> Thread: main');
    transactions.push(req.body);
    res.json(req.body);
});

// Jahresbericht: der Server rechnet 5 Sekunden
app.get('/report', (req, res) => {
    console.log('Jahresbericht -> Thread: main');

    // Node hat nur EINEN Thread: solange er rechnet, müssen alle anderen warten
    const end = Date.now() + 5000;
    while (Date.now() < end) {
    }

    let income = 0;
    let expenses = 0;
    for (const transaction of transactions) {
        if (transaction.amount >= 0) {
            income = income + transaction.amount;
        } else {
            expenses = expenses + transaction.amount;
        }
    }
    res.json({ income: income, expenses: expenses, balance: income + expenses });
});

app.listen(3000, () => {
    console.log('Server läuft auf http://localhost:3000');
});