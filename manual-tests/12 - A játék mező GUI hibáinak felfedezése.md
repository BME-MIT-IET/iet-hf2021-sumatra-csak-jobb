# 12 - A játék mezők megjelenítése GUI hibáinak felfedezése

Az a célja ennek a tesztnek, hogy a tesztelő megpróbálja valahogyan elrontani a mezők megjelenítését.

## Bemeneti adatok
*Bizonyos lépéseknél szükség van nagyobb mennyiségű bemeneti adatra.
Ezek az átláthatóság kedvéért ebben a részben vannak felsorolva.*

1. [smallWorld.txt](resources/smallWorld.txt), mint szöveges fájl.

## Előkészítés

1. Indítsd el az alkalmazás grafikus felületét!
2. Töltsd be a pályát: `File -> Load`, keresd meg és válaszd ki a resources/smallWorld.txt-t, `Open`.

## Lépések

| Lépés # | Leírás | Várt eredmény |
| ------- | ------ | ------------- |
| 1. | Próbáld ki hogy el tudod-e mozdítani a mezőket a bal egér gomb lenyomásával a mező fölött és húzással. | Elmozdulnak a húzott mező. |
| 2. | Próbáld meg úgy elmozdítani a mezőket hogy nem kattintasz rájuk csak melléjük, vagy valahova máshova az interface-en. | Csak akkor mozdulnak el a mezők ha rajtuk nyomod le az egérgombot. |
| 3. | Próbálj több részén lenyomni a gombot a mezőknek, olyat részt keresve, ahol nem működik az elmozdítás. | Mindig elmozdulnak a mezők bárhol van rajtuk az egér. |
| 4. | Próbáld meg úgy elmozdítani a mezőket hogy az összekötő vonalak nem elvártan viselkednek. | Mindig össze kell legyenek kötve egy látható fekete vonallal a szomszédos mezők. |
| 5. | Próbáld kimozdítani a mezőket a játéktérből. Minden irányba próbáld meg kihúzni őket (fel, le, balra, jobbra) | Ki lehet mozdítani a mezőket a játéktérből, és olyankor megjelennek oldalt Scrollbar-ok, melyekkel a kimozdított mezőkhöz lehet mozdítani a játékteret. |
| 6. | Próbáld átméretezni a játék ablak méretét. | Át lehet méretezni a játékablakot és különböző méretekben is játszható marad a játék. |


## Megjegyzések

* Ezeknél a teszteknél egy kicsi próbálgatás/felfedezés is elvárt a tesztelőtől.