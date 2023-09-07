# SP 01 - 3. semester 

## Business idea
En app hvor man kan finde og møde andre mennesker med de samme hobbyer som man selv har. 
Appen skal indeholde de forskellige hobbyer og have dem delt ind i kategorier som fx vandsport. 
Hvilket før det nemmere for en bruger, at blive inspireret af andre brugeres hobbyer

Ideer til videre udvikling:
Events - både faste og andre
Vi kan have målrettede reklamer 


## Domain Model
![img.png](img.png)

## EE-diagram
![eer_sp01_3semester](https://github.com/FrederikGJ/hobby_sp1/assets/113090989/eb79cf60-e987-451f-b444-deb036813b3e)





## Grupeparbejdet
Vi startede arbejdet med at lave et domænediagram. Det hjalp os til at få et overblik over projektet. 
Domænemodellen blev godkendt af projektejer (Jon og Jörg agerede projektejer for opgaven).
Da vi havde et overblik over domænet hentede vi en startkode, som var lavet af en fra vores studiegruppe og fik lavet entiteterne. 
Herefter fik vi aftalt hvordan relationerne mellem de forskellige entiteter skulle være.
Først da vi havde en fælles kodebase med entitier og relationer gik vi i gang med at programmere. 
Her delte vi projektets forskellige userstories ud på gruppemedlemmerne, men havde selvfølgelig mulighed for at spørge om hjælp hos hinanden.
Vi mødtes fysisk mandag, onsdag og torsdag. Da vi i gruppen finder det nemmere at arbejde som team, når vi er fysisk til stede på samme matrikel. Tirsdag arbejdede vi hjemme fra. 
De dage vi mødtes afholdt vi daily standup, sådan at vi var med på hvad alle i gruppen arbejdede på og hvilke udfordringer der var med opgaverne. 
På den måde kunne vi hjælpe hinanden, og få sparring på de opgaver vi arbejdede med. 
Til løbende dokumentation valgte vi google docs. Vi valgte ikke at bruge kanban (Trello), da projektet var meget kort og havde et ret lille scope. 

## tekniske krav    
Vi skulle i projektet bruge JPA, Hibernate og Maven. Samtidig skulle vi bruge en database Postgres.
Vi har ikke nogen frontend på projektet, så der er pt ingen brugergrænseflade. Programmeringssproget er Java. 
Vi har Lombok i vores projekt, som gør det nemmere at skabe getters og setters og NoArgsConstructor og NoArgsConstructor, hvilket gør at vi skal skrive mindre "boilerplate" kode.

Til versionsstyring har vi brugt Git og GitHub, både desktop versionen og Git integrationen i Intellij til at løse merge konflikter. 
Intellij Ultimate var vores IDE og vi anvendte 2023 versionen.

Til at administrere vores database bruge vi både pgAdmin og IntelliJ integrationen af databasen. 
Grunden til at vi også anvendte den version der er indbygget i Intellij er, at det gør den mere tilgængelig i samme vindue som vi koder.
Vi har brugt JUnit 5 til at teste vores kode. Og på den måde kan vi også vise at 

Vi har valgt at anvende Docker til vores database. 
Det gør vi for at drage fordel af de funktioner der er ved containerization. 
Det er blandt andet stærk versionsstyring på databasen og isolering, 
så databasen ikke påvirkes af handlinger i andre udviklingsmiljøer.




