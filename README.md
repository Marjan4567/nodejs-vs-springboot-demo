Mein Konto – Node.js vs. Spring Boot
Dieselbe kleine Konto-App zweimal gebaut (node-demo und spring-demo), um zu zeigen, wie Node.js (ein Thread) und Spring Boot (ein Thread pro Anfrage) mehrere Anfragen gleichzeitig behandeln.
Starten

Spring Boot: KontoApplication in IntelliJ starten → http://localhost:8080
Node.js: im Ordner node-demo npm install und npm start → http://localhost:3000
Demo
Zwei Tabs öffnen und in beiden kurz nacheinander „Jahresbericht erstellen“ klicken.

Node.js: der zweite Bericht braucht ca. 10 Sekunden (ein Thread, alles nacheinander)
Spring Boot: beide sind nach ca. 5 Sekunden fertig (ein Thread pro Anfrage)
