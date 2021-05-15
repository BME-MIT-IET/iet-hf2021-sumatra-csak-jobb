# Nem funckionális tesztek tervezése, vizsgálata és dokumentálása

A feladat során vizsgáltam a grafikus felület használhatóságát és a program teljesítményét nem funkcionális követelmények alapján. 

## Felület használhatósága
A feladat a hibák kimerítő keresése miatt nehézkes volt, sokági tartott, átvizsgáltam a grafikus felület funkcióit, vizsgáltam a Java SWING alkalmazásából származó bug-okat is. 

A grafikus felületet teljesítmény szempontjábólk is vizsgáltam, készítettem egy pálya generáló script-et, amivel tetszőleges nagyságú map betölthető a grafikus felületen keresztül. 

## Teljesítménymérés
A feladatot hosszú keresés előzte meg a megfelelő benchmark/mérő program kiválasztásához. Nagyon sok már részben vagy egészben nem támogatott volt, vagy csak megvásárolható volt. 

Végül a JMH rendszer mellett döntöttem, ezt viszonylag könnyen be tudtam konfigurálni. Illetve nagyon sok online leírás elérhető volt hozzá. A JUnit tesztekhez hasonló, annotációkkal megadható tesztkörnyezetet lehet vele létrehozni, és ezen méréseket lehet elvégezni. A kapott eredmények egy sima fájlba, xml-be, JSON-ba ... is lementhetőek.  