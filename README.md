# 🧩 Programmiertechnik Projektarbeit – IMUK-1 (WiSe 2025/26)

**Hochschule Neu-Ulm**  
**Modul:** Programmiertechnik (IMUK-1)  
**Dozent:** Prof. Dr. D. Meyer  

---

## 📘 Projektbeschreibung

Dieses Repository enthält die Projektarbeit des Moduls **Programmiertechnik** im **Wintersemester 2025/26**.  
Ziel ist es, ein **Java-Programm mit grafischer Benutzeroberfläche (Swing)** zu entwickeln, das die Erstellung, Speicherung und Auswertung von Objekten einer selbst definierten Klasse ermöglicht.

---

## 🎯 Aufgabenübersicht

### **Aufgabe 1 – Java-Applikation mit GUI**
Erstelle ein Java-Programm, das:
- Objekte einer selbst definierten Klasse (z. B. `Tasche`, `Auto`, `Student`) verwaltet  
- mindestens **3 Attribute unterschiedlicher Datentypen** besitzt  
- über eine GUI (Swing) Eingabe, Speicherung und Filterung der Objekte erlaubt  
- eine Methode zur **Berechnung oder Filterung** implementiert, die mit **JUnit** getestet wird  
- eine **Methode `initObjekte()`** enthält, die beim Programmstart mindestens 3 Beispiel-Objekte erzeugt  
- Fehlerhafte Eingaben mit **Exception-Handling** behandelt  
- Objekte im GUI-Bereich anzeigt, inklusive **Filter- und Sortierfunktion**

---

### **Aufgabe 2 – Präsentationsvideo**
- Erstelle ein **max. 3-minütiges Lehrvideo**, in dem das Programm vorgestellt wird  
- Alle Gruppenmitglieder müssen erscheinen  
- Erkläre anhand eines **UML-Klassendiagramms** den Aufbau des Projekts  
- Beachte **fachliche Richtigkeit**, **Originalität** und **filmische Qualität**

---

### **Aufgabe 3 – (Optional) GitHub-Integration**
Zur Verbesserung der Zusammenarbeit wird das Projekt über **GitHub** verwaltet:
1. Neues Repository anlegen  
2. Quellcode, Swing-Formulare (`.java`, `.frm`), JUnit-Tests etc. hochladen  
3. Sinnvolle Ordnerstruktur (z. B. `/src`, `/test`, `/resources`)  
4. Regelmäßige Commits mit aussagekräftigen Nachrichten  
5. Nutzung von GitHub-Features wie **Pull Requests**  
6. Dokumentation in dieser **README.md**

---

## 📂 Projektstruktur

```
├── src/                # Haupt-Quellcode (Java-Klassen, GUI)
│   ├── model/          # Datenklassen (z. B. Tasche.java)
│   ├── view/           # Swing-Formulare (.java / .frm)
│   └── controller/     # Logik und Event-Handling
│
├── test/               # JUnit-Tests
│   └── modelTest.java
│
├── uml/                # UML-Klassendiagramm (PDF)
│
├── video/              # Präsentationsvideo oder Link-Dokument
│
├── README.md           # Projektdokumentation
└── LICENSE             # (optional)
```

---

## ⚙️ Installation & Ausführung

1. Repository klonen  
   ```bash
   git clone https://github.com/<username>/<repository-name>.git
   ```
2. Projekt in **IntelliJ IDEA** öffnen  
3. Falls `.frm`-Dateien vorhanden sind, GUI-Designer aktivieren  
4. Hauptklasse ausführen (z. B. `Main.java`)  

---

## 🧪 Testen

JUnit-Tests befinden sich im Ordner `/test`.  
Zum Ausführen in IntelliJ:
```
Rechtsklick → Run 'All Tests'
```

---

## 🧠 Bewertungskriterien (Auszug)

| Kriterium | Punkte |
|------------|---------|
| mind. 2 Klassen, 3 Attribute (versch. Datentypen) | 5 |
| Methode zur Berechnung/Filterung | 3 |
| JUnit-Test | 4 |
| GUI funktionsfähig & sinnvoll | 2 |
| Exception-Handling | 3 |
| UML-Diagramm | 3 |
| Lehrvideo | 3 |
| Originelle Idee | 1 |
| GitHub-Integration (Bonus) | +5 |
| **Gesamt:** max. 35 Punkte |   |

---

## 🧾 Hinweise

- Alle Gruppenmitglieder müssen an der Erstellung beteiligt sein  
- Quellen und verwendete KI-Tools sind anzugeben  
- Abgabe erfolgt elektronisch über **Moodle** bis **16. Januar 2026**  
- Befragungen finden ab **19. Januar 2026** via **Zoom** statt

---

## 🧑‍💻 Autoren

| Name | Matrikelnummer | Beitrag |
|------|----------------|----------|
| ...  | ...            | ... |
| ...  | ...            | ... |

---

## 📚 Lizenz

Dieses Projekt wurde im Rahmen des Moduls *Programmiertechnik (IMUK-1)* an der Hochschule Neu-Ulm erstellt.  
Nutzung ausschließlich zu Lehr- und Demonstrationszwecken.
