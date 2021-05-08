# 07 - Pálya betöltése GUI nélküli mentésből

A pálya betöltés funkció működését ellenőrzi. Az alkalmazás mentési mechanizmusa két fájlt hoz létre, egy olyat, ami a grafikus felülettől független,
tisztán a játékhoz szükséges adatokat tartalmazza, és egy olyat, ami a grafikus felülettől függ, és ahhoz kapcsolódó adatokat tartalmaz. A [06 - Pálya betöltése](06%20-%20Pálya%20betöltése.md) teszt azt ellenőrizte, hogy betölthető-e egy pálya az utóbbi típussal. Ez azt fogja ellenőrizni, hogy be lehet-e tölteni egy olyan
pályát, amihez csak GUI nélküli adatok tartoznak.

## Bemeneti adatok

1. [07-input-data.txt](resources/07-input-data.txt), mint szöveges fájl.

## Előkészítés

1. Töltsd le a fenti szövegfájlt egy elérhető helyre, és indítsd el az alkalmazás grafikus felületét!

## Lépések

| Lépés # | Leírás | Várt eredmény |
| ------- | ------ | ------------- |
| 1. | Kattints a `File -> Load` menüpontra. Keresd ki azt a fenti fájlt! Válaszd ki, majd kattints az `Open`-re. | A grafikus felület konzolján egy visszaigazoló üzenetet kell látnod, miszerint `World loaded successfully!`, Ezenfelül a játéktéren látnod kell három mezőt, bármely kettő között egy linket (a mezőkre kattintva húzással tudod őket átrendezni), valamint három élőlényt, egy eszkimót és egy kutatót a 0-ás mezőn, és egy jegesmedvét az 1-es mezőn. |
