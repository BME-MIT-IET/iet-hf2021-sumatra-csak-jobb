# 06 - Pálya betöltése

A pálya betöltés funkció működését ellenőrzi. Ha ez a teszt sikertelen, akkor probléma lehet mind a mentési, mind a betöltési fázissal.

## Előkészítés

1. Indítsd el az alkalmazás grafikus felületét!
2. Végezd el a [05 - Pálya mentése](05%20-%20Pálya%20mentése.md) tesztet a bemeneti adatfájl(ok) létrehozásához.
3. Indítsd el az alkalmazást egy újabb példányban!

## Lépések

| Lépés # | Leírás | Várt eredmény |
| ------- | ------ | ------------- |
| 1. | Kattints a `File -> Load` menüpontra. Keresd ki azt a fájlt, amit a mentési tesztben elmentettél! (Pontosan azt - előfordulhatnak hasonló nevű fájlok is, azokkal ne törődj!) Válaszd ki, majd kattints az `Open`-re. | A grafikus felület konzolján egy visszaigazoló üzenetet kell látnod, miszerint `World loaded successfully!`, illetve a játéktéren látnod kell az elmentett mezőket és élőlényeket. |
| 2. | Hasonlítsd össze az alkalmazás két példányának játékterét és `Creatures` paneljét! | A két példányban ugyanazokat a mezőket, élőlényeket, és adatokat kell látnod, ugyanabban az elrendezésben. |
