# 09 - Játék elindítása betöltött pályából

Annak a tesztelése hogy sikeresen el lehet-e indítani a játékot. Ezúttal úgy hogy a pályát nem kézzel készítjük el, hanem betöltjük egy mentésből.

## Bemeneti adatok
*Bizonyos lépéseknél szükség van nagyobb mennyiségű bemeneti adatra.
Ezek az átláthatóság kedvéért ebben a részben vannak felsorolva.*

1. [smallWorld.txt](resources/smallWorld.txt), mint szöveges fájl.

## Előkészítés

1. Indítsd el az alkalmazás grafikus felületét!
2. Töltsd be a pályát: `File -> Load`, keresd meg és válaszd ki a resources/savedWorld.txt-t, `Open`.

## Lépések

| Lépés # | Leírás | Várt eredmény |
| ------- | ------ | ------------- |
| 1. | Kattints a játék jobb oldalán a `Start automated game` gombra | A játék jobb oldalán megjelenik egy lista a lehetséges cselekvésekkel: `Move`, `Dig`, `Use manual tool`, `Use character ability`, `Pick up item from current tile`, `Build flare`, `Finish round`, `Stop game`. Alul megjelenik a `Game Started` és a `Player 0, yout're up!` üzenet  |