
# Node.js vs. Spring Boot

**Zweck:** Dieselbe kleine Konto-App zweimal gebaut (node-demo und spring-demo), um zu zeigen, wie Node.js (ein Thread) und Spring Boot (ein Thread pro Anfrage) mehrere Anfragen gleichzeitig behandeln.

---

## Starten (lokal)

### Spring Boot

Application in IntelliJ starten → http://localhost:8080

### Node.js

Im Ordner node-demo npm install und npm start → http://localhost:3000

---

## Demo / Verhaltenstest
1. Öffne zwei Browser-Tabs.
2. In beiden Tabs kurz nacheinander auf **„Jahresbericht erstellen“** klicken.
3. Erwartetes Verhalten:
   - **Node.js:** Der zweite Bericht braucht ca. **10 Sekunden** (serielle Verarbeitung / Event-Loop simuliert blockierende Arbeit).
   - **Spring Boot:** Beide Anfragen sind nach ca. **5 Sekunden** fertig (je Anfrage eigener Thread).

