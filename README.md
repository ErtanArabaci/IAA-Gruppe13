# Übung Raumverwaltung

Inhalt dieser Übung ist die Implementierung einer kleinen Anwendung mit Konsolen-Frontend. Die Anwendung
dient zur Verwaltung von Räumen, Kursen und Vorlesungen und bietet die Standard-CRUD-Funktionen für diese
Entitäten an. Die Anwendung wird dabei im Laufe des nächsten Vorlesungen immer weiter erweitert.

## Erweiterung für Spring (4. Teil)

Nachdem nun der Spring-Backendaufbau abgeschlossen ist, geht es nun darum, dass Angular-Frontend an das
Spring-Backend anzuschließen.

Das Projekt enthält die Struktur und den Quellcode des Angular-Projekts, das im fünften Semester gebaut wurde. 
Nun geht es darum, die REST-Endpoints unter Verwendung des Spring-Frameworks zu bauen, um das bestehende 
Angular-Frontend anzubinden.

Die Struktur des Angular-Projekt weicht von der Struktur des Projekts mit dem Struts-Client ab. Während
bei Struts alle Bestandteile in ein großes Java-Web-Modul integriert sind, besteht das Projekt nun
aus zwei unabhängigen Modulen:

* `backend`: Das Backend-Modul enthält eine Java Web Anwendung und das in diesem Semester gebaute
Spring-Backend.
* `frontend`: Das Frontend-Modul enthält die Angular CLI-basierte Angular-Anwendung aus dem fünften
Semester.

### Erforderliche REST-Endpoints

Der Angular-Client ist schon fertig entwickelt und braucht im Rahmen der Übung nicht angepasst werden.
Die Anpassungen bestehen dagegen daraus, die vom Angular-Client erwarteten REST-Endpoints zu implementieren.
Im letzten Semester gab es hierfür Mock-Endpoints - nun sind die richtigen an der Reihe.

Die folgenden REST-Endpoints werden vom Angular-Frontend erwartet:

* Lesen aller Räume: `GET /rest/rooms`
* Anlegen/Aktualisieren eines Raums: `PUT /rest/rooms`
* Löschen eines Raums: `DELETE /rest/rooms/{id}`

## Übungsschritte

Es geht in dieser Übung darum, den REST-Endpoint für die Räume zu implementieren. Hierfür sind die folgenden Schritte 
notwendig:

1. Erweitern Sie die Spring-Konfiguration um die notwendigen Elemente für die Konfiguration des Spring MVC Frameworks.
Die Folien bieten hier Hilfestellung.
2.  Konfigurieren Sie das _Dispatcher Servlet_ in der `web.xml`, die Sie im Ordner `src/main/webapp/WEB-INF` finden. 
Die Konfiguration entspricht dem Beispiel in den Folien.
3. Erzeugen Sie im Java-Package `de.nordakademie.iaa.roommgmt.controller` eine neue Klasse
`RoomController`.
4. Die Klasse muss die Annotation `@RestController` bekommen, um von Spring als REST-Endpoint erkannt zu werden.
5. Legen Sie in der Klasse ein Attribut `roomService` vom Typ `RoomService` an und generieren Sie den
Setter für dieses Attribut.
6. Lassen Sie den Room Service durch die Annotation `@Inject` injizieren.
7. Versuchen Sie einmal, die Methoden für die oben aufgeführte REST-API zu implementieren.
8. Zum Starten und Testen der Applikation müssen Sie eine neue _Run Configuration_ für einen lokalen Tomcat-Server
anlegen. Sollte Sie die Tomcat-Installation nicht mehr aus dem letzten Semester haben, steht der Tomcat weiterhin
im Moodle-Kurs zur Verfügung.
9. Beim Anlegen der Run Configuration achten Sie bitte darauf, das Deployment-Artefakt aufzuwählen, das nach dem
Start auf dem Tomcat deployed werden soll. Beim Anlegen der Konfiguration macht Sie ein entsprechender Fehler darauf
aufmerksam. Sie bekommen hierbei mehrere Artefakte angeboten - das `exploded`-Artefakt ist das richtige.

### Testen der Anwendung

Zum Testen der Anwendung müssen zwei Bestandteile gestartet werden. Zum einen der Tomcat-Server,
der die Spring-Web-Anwendung mit den REST-Endpoints bereitstellt. Die REST-Endpoints werden unter
der Adresse http://localhost:8080/rest bereitgestellt.

Darüber hinaus muss dann noch der Angular CLI Server für das Angular-Frontend gestartet werden.
Dieser stellt anschließend das Frontend bereit, dass unter der Adresse http://localhost:4200 im Browser
aufgerufen werden kann.
