# 02 - Világ inicializáció lehetséges hibái

A világ inicializálás működését ellenőrzi a lehetséges hibákon keresztül. A teszt lépései körülbelül függetlenek, többségük önmagában is egy valid teszt. Azért lettek egyesítve, mert ugyanahhoz a felületegységhez tartoznak.

## Előkészítés

1. Indítsd el az alkalmazás grafikus felületét!
2. Kattints a menüsorban az `Initialization -> Init World` menüpontra!
3. Kiindulásként adj hozzá a pályához két stabil mezőt! (`Stable 0 0` a bal oszlopban, majd az `Add Tile` gomb kétszer.)

## Lépések

| Lépés # | Leírás | Várt eredmény |
| ------- | ------ | ------------- |
| 1. | A középső oszlopban hozz létre egy olyan linket, aminek mindkét végén ugyanaz a mező szerepel! (Például `0 0`, majd `Add Link`) | Nem történik semmi, vagy egy felugró ablak jelzi, hogy ilyet nem szabad csinálni. A teszt sikertelen, ha az alkalmazás összeomlik, vagy valamelyik outputon megjelenik egy exception. |
| 2. | A bal oszlopban hozz létre egy olyan instabil mezőt, aminek 0 a kapacitása! (`Unstable 0 0`, `Add Tile`) | Nem történik semmi, vagy egy felugró ablak jelzi, hogy ilyet nem szabad csinálni. A teszt sikertelen, ha sikerül ilyen mezőt létrehozni (hiszen 0 kapacitású instabil mezőnek nincs értelme, az egy lyukas mezővel érne fel). |
| 3. | Próbálj meg a bal oszlopban helytelen értékeket beírni a szám mezőkbe: Negatív számok, szöveg, tizedespont / vessző, speciális karakterek! | Nem sikerül egyiket sem beírni, a mezőkben mindig érvényes nemnegatív egész szám látszódik. |
| 4. | A jobb oszlopban próbálj meg ugyanahhoz a mezőhöz több ugyanolyan, vagy különböző itemet is hozzáadni! (Például `0 Gun`, `0 Gun`, `0 Cartridge`, `0 Beacon`, mindegyik után egy `Add Item`-et nyomva.) | Csak egyet sikerül létrehozni a mezőn, többet nem enged az alkalmazás. A teszt sikertelen, ha ugyanarra a mezőre több tárgyat is le lehet tenni. |
| 5. | Hozd létre az eddigi pályát! (`OK` gomb), majd nyisd meg ismét a világ inicializáló menüt, és kattints bármiféle egyéb beállítás nélkül az `OK` gombra! | A korábban létrehozott mezők eltűnnek a játéktérről, az összes panel üres. |


## Megjegyzések

* A tesztek egymástól függetlenek, csak az előkészítés lépéseitől függenek. Ha viszont valamelyik teszt sikertelen, megeshet, hogy befolyásolni fogja a többi teszt sikerességét, így ilyenkor mindig indulj tiszta lappal, és végezd el ismét az előkészítő lépéseket!