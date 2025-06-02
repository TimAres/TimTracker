# TimTracker

**TimTracker** ist eine schlanke und erweiterbare Web-Anwendung zur Erfassung und Auswertung von Arbeitssitzungen. Das Ziel ist es, ein praxisnahes Zeiterfassungstool mit moderner Java-Technologie zu entwickeln, das als Grundlage für persönliche Nutzung, Erweiterungen oder als Referenzprojekt dient.

## Projektbeschreibung

Dieses Projekt entsteht neben meinem Studium der Wirtschaftsinformatik an der HAW Hamburg und verfolgt zwei Hauptziele:

- Entwicklung eines nützlichen Werkzeugs zur strukturierten Zeiterfassung
- Vertiefung und Anwendung aktueller Backend-Technologien in einem Fullstack-Umfeld

## Technologiestack

- **Backend**: Java 17, Spring Boot 3 (Web, Data JPA, Mail)
- **Build-Tool**: Gradle
- **Datenbank**: PostgreSQL
- **ORM**: Hibernate (JPA)
- **Code-Unterstützung**: Lombok
- **Testing**: JUnit 5, AssertJ, Rest-Assured
- **API-Design**: RESTful

## Funktionsübersicht

| Status   | Funktion                           |
|----------|----------------------------------|
| Geplant  | CRUD für Arbeitssitzungen (TrackedSession) |
| Geplant  | Dauerberechnung anhand Zeitstempel |
| Geplant  | Analyseansicht vergangener Sessions |
| Geplant  | Authentifizierung (z. B. JWT)     |
| Geplant  | Deployment auf eigener Domain |

## Vorraussetzungen und Einrichtung der Datenbank (Es könnten hier eigentlich ein paat Dinge doppelt sein)
1. PostgreSQL installieren
   sudo apt update
   sudo apt install postgresql postgresql-contrib
2. PostgreSQL-Dienst starten (falls nicht aktiv)
   sudo systemctl start postgresql
   sudo systemctl enable postgresql
3. Konsole öffnen
   sudo -u postgres psql
4. Benutzer erstellen
   CREATE USER th WITH PASSWORD '1234';
5. Datenbank erstellen
   CREATE DATABASE timtrackerdb;
6. Berechtigungen vergeben
GRANT ALL PRIVILEGES ON DATABASE timtrackerdb TO th;
7. Schema Besitz anpassen
   ALTER SCHEMA public OWNER TO th;
   GRANT USAGE, CREATE ON SCHEMA public TO th;
8. Standard Berechtigungen
   ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL ON TABLES TO th;
   ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL ON SEQUENCES TO th;


## Allgemeine Befehle für den Umgang mit PostgreSQL
sudo systemctl start postgresql
sudo systemctl stop postgresql
sudo systemctl restart postgresql
sudo systemctl status postgresql

## Wenn es bei Systemstart laufen soll und wie man es deaktiviert
sudo systemctl enable postgresql
sudo systemctl disable postgresql



