# 11 - Új játék kezdése, amikor már fut egy

Azt teszteli, hogyha el van már indítva egy játék akkor jól működik-e egy újabb játék indítása.

## Bemeneti adatok
*Bizonyos lépéseknél szükség van nagyobb mennyiségű bemeneti adatra.
Ezek az átláthatóság kedvéért ebben a részben vannak felsorolva.*

1. [smallWorld.txt](resources/smallWorld.txt), mint szöveges fájl.

2. Paraméterek a világ inicializáló menü első oszlopához:
    * `Stable 0 0`
    * `Unstable 0 3`
    * `Hole 0 0`
3. Paraméterek a világ inicializáló menü második oszlopához:
    * `0 1`
    * `0 2`
    * `1 2`

## Előkészítés

1. Indítsd el az alkalmazás grafikus felületét!
2. Töltsd be a pályát: `File -> Load`, keresd meg és válaszd ki a resources/smallWorld.txt-t, `Open`.
3. Indítsd el a játékot: `Start automated game`.

## Lépések

| Lépés # | Leírás | Várt eredmény |
| ------- | ------ | ------------- |
| 1. | A `File -> Load`-al töltsd be újra a resources/smallWorld.txt-t. | Eltűnnek jobboldalról a cselekvés gombok, már nem fut a játék és a pálya a kezdeti helyzetbe kerül. |
| 2. | Indítsd el a játékot: `Start automated game`. | Elindul a játék, megjelennek a cselekvés gombok. |
| 3. | Kézzel készítsd el a pályát `Initialization -> Init World`, `Initialization -> Init Creatures`-el és a fent megadott adatokkal. | Eltűnnek jobboldalról a cselekvés gombok, már nem fut a játék és a pálya a kezdeti helyzetbe kerül. |
| 4. | Indítsd el a játékot: `Start automated game`. | Elindul a játék, megjelennek a cselekvés gombok. |