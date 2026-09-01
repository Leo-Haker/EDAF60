
+ Leo Haker
+ Erik Åstrand
+ Kalle Skog    
+ Andreas Ekner

## Svar på designfrågor

Gammalt klassdiagram:
[!Klassdiagram](/bild.png)

Nytt klassdiagram:
[!Klassdiagram](/bild2.png)

+ **A3**: Förklara i bara några få ord vad var och en av klasserna
          `SlotLabel`, `SlotLabels`, `Editor`, `StatusLabel`,
          `CurrentLabel` och `XL` i den utdelade koden gör.

          Slotlabel beskriver en ruta. 
          Slotlabels beskriver ett rutnät (ett nät av Slotlabel)
          Editor där man kan skriva in text
          StatusLabel  Visar statusen på labeln man är på. Om A1 = 2 visas 2. 
                        Den ligger till höger om CurrentLabel, ovanför Editor.
          CurrentLabel  Visar vilken label man är på, ex A1. Vyn till vänster ovanför Editor.
                        Kör andra kontruktorn av ColoredLabel.
          XL  Skapar fönstret, hur många rader och kolonner. 

+ **A4**: Användningsfall: Någon skriver talet 42 i `Editor`, vad
          skall hända innan värdet syns i vyn (dvs vilken väg skall
          värdet gå genom M, V och C)?

          Användare -> 42 i Editor -> C -> M -> V

+ **B2**: En cell kan innehålla antingen en kommentar eller ett
          uttryck hur modellerar vi det i Javakod?

        Interface cell som implementeras av Expr Cell och Comment Cell

+ **B4**: Vilka klasser, förutom dem i `expr`-paketet, kommer vi att
          behöva i vår modell?

        - Interface cell
        - Klass Epxr cell
        - Klass Comment Cell 
        - La Bomba Cell
        - Sheet

+ **C1**: När ett uttryck som innehåller en adress beräknas använder
          vi en `Environment` -- varför?

        Dependency injection. Enviroment definerar vad en adress betyder.

+ **D1**: Vilka klasser i modellen måste vara kända av vårt GUI?

        Klassen Sheet

+ **D2**: När vårt GUI hämtar värden att skriva ut i `SlotLabel`
          eller `SlotLabels`, vilka värden, och vilken typ vill
          vi få tillbaka?

        Får och skickar strängar

+ **E4**: Allmänt: vilket paket bör upptäcka fel?

          Model upptäcker felen.

+ **E5**: Allmänt: vilket paket bör hantera fel, och hur gör vi det?

        View informerar. 
        Model hanterar så att systemet inte kraschar.

+ **F1**: Vilken slags synkronisering (_Flow Synchronization_ eller
          _Observer Synchronization_) vill gruppen använda för
          kommunikationen mellan M och V/C?

        Flow Synchronization

+ **F2**: Hur håller programet reda vilket som är den aktuella
          cellen? Svaret på denna fråga beror på hur ni
          implementerar er Controller.

        Controller tar info från editorn, skickar strängen först till Model och sedan till View 

+ **F3**: Hur triggas uppdateringar i ert GUI? Svaret på denna fråga
          beror av hur ni implementerar er Controller.

        Controllern updaterar GUI:n genom en eller flera metod/-er. 


## Att köra programmet

För att köra programmet kan man skriva:

~~~{.sh}
./gradlew run
~~~

i projektets rot-katalog.