# Text based  adventure game
Schreibe ein text-based Adventure Game.
Wichtig in diesme Beispiel sind: Vererbung, Polymorphie und das Erkennen des richtigen Design Patterns

Wie immer sind Clean Code Rules, Design Patterns zu beachten! Logging kann, muss nicht sein.

Du kannst bei den Texten kreativ(er) sein.

## Player
Der:Die Heldin wird aus dem csv File ausgelesen und befüllt. Ist der Name leer, soll nach dem Namen gefragt werden,

Die maxHealthPoints dürfen nicht <=0 sein; wenn dies passiert, werden sie auf 12 gesetzt. 
example csvFile:
name;maxHealthPoints
Gandalf the Grey;14

## Spielablauf
Das Spiel läuft immer automatisch ab, außer, wenn von dem:der Spieler:in eine Eingabe verlangt wird.
Es müssen mindestens 3 Räume zwischen Start und Endraum liegen.

### Röume
Es gibt 5 Räume. 
1. Startroom
2. MagicRoom
3. OrdinaryRoom
4. Traproom
5. Tavern
6. Endroom

Ad 1:
Player Hero 123 has entered the game. Onwards the journey goes...!
Ad 2:
A wizards shows up and demand you say a magic spell!
Wenn der Spruch länger als 10 zeichen ist, gewinnt der:die Held:in 5 Punkte, ist er kürzer, 3. Ist der:die Held:in sprachlos, gibt es keinen Punkt
Ad 3:
Es gibt Personen (dazu später mehr) im Raum, die alle etwas sagen. 
Ad 4:
Hier muss eine Subtraktion ausgeführt werden. Das Spiel gibt die Subtraktion mittels Zufallszahlengenerator vor (zwischen 1 und 20), der:die Spieler:in muss es lösen.
Ist die Antwort richtig: Luck you have!
Ist die Antwort falsch, verliert der:die Heldin 5 Lebenspunkte
Achtung: Stirbt der:die Held:in, wird das Spiel abgebrochen (Tod: <= 0 Lebenspunkte)
Ad 5:
Ein Würfelspiel (max 20 Augen) um Zwergenbier. Wer verliert, muss Zwergenbier trinken und verliert 3 Lebenspunkte.
Achtung: Stirbt der:die Heldin, wird das Spiel abgebrochen (Tod = <= 0 Lebenspunkte)
Beispielablauf, alles automatisiert.
Hero123 enters the Tavern "The prancing pony". You must participate in a dice game. If you roll a number less than your opponent Mr Underberg, you must drink dwarve's beer and lose 3 health points
Rolling d20...
Result: 1
Opponent rolls their die
Result: 2
You loose. Deducting 3 HP

Ad 6:
Ist das Spiel gewonnen gibt es eine Überraschung (s.u.)



Die Räume werden mittels eines passenden Design Pattern und einem Zufallszahlengenerator bestimmt. Es muss immer einen Start- und Endraum, sowieso mindestens drei Spielräume geben.
Der:Die Spieler:in gibt zu Beginn an, wieviele Räume insgesamt vorhanden sein sollen.
### Raumentstehung
Ist die per Zufall generierte Zahl (bis max 21 inkl.) durch 3 ohne Rest teilbar, dann wird es ein Ordinary room, bei einer Divison durch 5 ohne Rest ein Magic room, Division durch 4 ohne Rest die Taverne.
Sonst ein Trap room.
Zufallszahl: ThreadLocalRandom.current().nextInt(lower, upper); (upper  = exklusiv)

#### Personen im Ordinary Room
Es gibt 2 Arten von Personen: Farmer und Villagers.
Spricht ein Farmer, ist folgendes auszugeben: "Die Ernte wird heuer gut werden", sagt der Farmer.
Spricht der Dorfbewohner: "Hier am Land ist doch zu ruhig", sagt der Villager.
Die übergeordnete Person-Klasse hat eine gemeinsame Methode dafür - hier soll mittels Vererbung und Polymorphie der richtige Output erzielt werden!
Der:Die Spielerin legt pro Ordinary room fest, wie viele Personen im Raum sind und davon, wie viele Villagers. Der Rest sind Farmer.
Wichtig: Der Räum muss mit den Personen zum Erzeugungszeitpunkt befüllt werden.

## Raumverteilung und -verknüpfung, Programmierhinweise
Jeder Raum weiß, ob es einen nächsten Raum gibt und der Raum "kennt" seinen Nachbarraum (Achtung: End room!). Es muss daher eine Methode vorhanden sein, die zwei Räume miteinander verbindet. 
Das Spiel läuft, solange es noch einen Raum gibt. Es muss eine Klasse geben, die die Räume verwaltet und auch die Erzeugung an die RoomFactory delegiert.

Der:Die Heldin beginnt im Startraum und bewegt sich von in den nächsten verknüpften Raum.
Die Hauptmethode jedes Raumes (Vererbung!) ist "boolean surviveRoom(Player)" - hier finden die Aktionen statt - wird von der Spiellogik aufgerufen.
Hat er:sie überlebt:
"Hero123 has survived in <hier Raumnamen einfügen>" (<room>.getClass().getSimpleName())
"Onto the next adventure...!"
Wenn nicht:

String graveyard = """
,-=-.       ______     _
/  +  \\     />----->  _|1|_
| ~~~ |    // -/- /  |_ H _|
|R.I.P|   //  /  /     |S|
\\vV,,|_____|V,//_____/VvV,v,|_|/,,vhjwv/,

""";

Ist der:die Heldin im End Room angekommen, gibt es ein Feuerwerk, wenn noch mind. 10 LP vorhanden sind.
String fireworks = """


                                                     .''.
                           .''.             *''*    :_\\/_:     .
                          :_\\/_:   .    .:.*_\\/_*   : /\\ :  .'.:.'.
                      .''.: /\\ : _\\(/_  ':'* /\\ *  : '..'.  -=:o:=-
                     :_\\/_:'.:::. /)\\*''*  .|.* '.\\'/.'_\\(/_'.':'.'
                     : /\\ : :::::  '*_\\/_* | |  -= o =- /)\\    '  *
                      '..'  ':::'   * /\\ * |'|  .'/.\\'.  '._____
                          *        __*..* |  |     :      |.   |' .---"|
                           _*   .-'   '-. |  |     .--'|  ||   | _|    |
                        .-'|  _.|  |    ||   '-__  |   |  |    ||      |
                        |' | |.    |    ||       | |   |  |    ||      |
                     ___|  '-'     '    ""       '-'   '-.'    '`      |____
                    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                                        
                    ------------------------------------------------
                    """;
Sonst eine einfache Ausgabe über den Zustand des:der Helden:in.