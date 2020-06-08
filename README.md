# 09-06-2020

Übungsaufgabe vom 08.06.2020 für die Studierenden des Java II Seminars der Universität zu Köln

### 📝 Aufgabe:

Die Idee dieser Aufgabe ist es eine kleine [CLI](https://de.wikipedia.org/wiki/Kommandozeile) Live-Wetter-App zu entwickeln, in die man über die Konsole Orte eintragen/entfernen kann und über einen Befehl alle Wetterdaten der eingetragenen Orte angezeigt bekommt.
Falls ihr eine andere Idee habt, wie man Live-Wetter-Daten verarbeiten könnte tobt euch gerne aus.

Um an die Live Wetterdaten zu kommen habe ich euch eine kleine Java-Bibliothek der Online-Schnittstelle [Weatherstack](https://weatherstack.com/) gebaut und in dieses GitHub Repository eingefügt. Ihr müsst also nur dieses Repo in Eclipse importieren und könnt damit arbeiten.

Meine Java-Weatherstack-Library ist ziemlich simpel gehalten. Die Klasse ```WeatherStack``` hat nur eine Methode ```getWeatherFromLocation(String location)``` die euch ein ```Weather``` Objekt mit verschiedensten ```int```, ```double``` und ```String``` Daten zurückgibt. 

Die Nutzung von Weatherstack ist in der Kostenlosen Variante auf 1000-Anfragen pro Monat begrenzt und wird durch einen sogenannten API-key kontrolliert (in meiner E-Mail an euch findet ihr meinen API-Key, den ihr gerne verwenden dürft).  Verwendet die Methode ```getWeatherFromLocation(String location)``` also am besten sparsam. Falls ihr feststellt, das der Key aus der E-Mail für diesen Monat aufgebraucht wurde, könnt ihr euch auch ganz einfach einen kostenlosen Account unter https://weatherstack.com/product machen und bekommt dann euren eigenen Key.

Eine WetterVORHERSAGE ist leider mit einem Kostenlosen Zugang nicht möglich.

    
### ℹ️ Resourcen:
Hier noch ein paar nützliche 📃Artikel, 🖊️Threads und 🎥Videos

- [🎥 Börges Seminar Video](https://uni-koeln.sciebo.de/s/CnL5Cg1opl8QceE)
- [📃 Java Scanner](https://www.w3schools.com/java/java_user_input.asp)


