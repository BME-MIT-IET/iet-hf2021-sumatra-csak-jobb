# 08 - Játék elindítása kézzel elkészített pályából

Annak a tesztelése hogy sikeresen el lehet-e indítani a játékot.

## Bemeneti adatok
*Bizonyos lépéseknél szükség van nagyobb mennyiségű bemeneti adatra.
Ezek az átláthatóság kedvéért ebben a részben vannak felsorolva.*

1. Paraméterek a világ inicializáló menü első oszlopához:
    * `Stable 0 0`
    * `Unstable 0 3`
    * `Hole 0 0`
2. Paraméterek a világ inicializáló menü második oszlopához:
    * `0 1`
    * `0 2`
    * `1 2`

## Előkészítés

1. Indítsd el az alkalmazás grafikus felületét!
2. Végezd el a [01 - Világ inicializáció sanity check](01%20-%20Világ%20inicializáció%20sanity%20check.md) tesztet a pálya létrehozásához!
3. Végezd el a [02 - Előlény inicializáció sanity check](03%20-%20Élőlény%20inicializáció%20sanity%20check.md) tesztet a lények létrehozásához!

## Lépések

| Lépés # | Leírás | Várt eredmény |
| ------- | ------ | ------------- |
| 1. | Kattints a játék jobb oldalán a `Start automated game` gombra | A játék jobb oldalán megjelenik egy lista a lehetséges cselekvésekkel: `Move`, `Dig`, `Use manual tool`, `Use character ability`, `Pick up item from current tile`, `Build flare`, `Finish round`, `Stop game`. Alul megjelenik a `Game Started` és a `Player 0, yout're up!` üzenet  |