# 04 - Élőlény inicializáció lehetséges hibái

Az élőlény inicializálás működését ellenőrzi a lehetséges hibákon keresztül. A teszt lépései körülbelül függetlenek, többségük önmagában is egy valid teszt. Azért lettek egyesítve, mert ugyanahhoz a felületegységhez tartoznak.

## Előkészítés

1. Indítsd el az alkalmazás grafikus felületét!
2. Végezd el a [01 - Világ inicializáció sanity check](01%20-%20Világ%20inicializáció%20sanity%20check.md) tesztet a pálya létrehozásához!
3. Kattints a menüsorban az `Initialization -> Init Creatures` menüpontra!

## Lépések

| Lépés # | Leírás | Várt eredmény |
| ------- | ------ | ------------- |
| 1. | Hozz létre értelmes keretek között sok eszkimó példányt! (`Eskimo 0`, majd `Add Creature` sokszor, 20-30-szor.) Végül kattints az `OK` gombra! | Létrejön az összes példány: a bal oldali `Creatures` sávban görgetve látszik a sok példány, illetve a játéktérben a mezőn látszik a játékosok egy része. |
| 2. | Hozz létre példaélőlényeket, például az előző lépés elvégzésével! Ezután nyisd meg újra az élőlény inicializáló menüt, és kattints bármiféle egyéb beállítás nélkül az `OK` gombra! | A korábban létrehozott élőlények eltűnnek a játéktérről, az összes mező, illetve a bal oldali `Creatures` panel üres. |

## Megjegyzések

* A tesztek egymástól függetlenek, csak az előkészítés lépéseitől függenek. Ha viszont valamelyik teszt sikertelen, megeshet, hogy befolyásolni fogja a többi teszt sikerességét, így ilyenkor mindig indulj tiszta lappal, és végezd el ismét az előkészítő lépéseket!