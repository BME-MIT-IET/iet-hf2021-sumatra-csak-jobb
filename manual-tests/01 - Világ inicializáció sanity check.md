# 01 - Világ inicializáció sanity check

A világ inicializálás alapvető működésést ellenőrzi. Ha ez a teszt nem sikeres,
akkor a többi inicializáló teszttel nem érdemes foglalkozni.

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

## Lépések

| Lépés # | Leírás | Várt eredmény |
| ------- | ------ | ------------- |
| 1. | Kattints a menüsorban az `Initializaton -> Init World` menüpontra! | Megnyílik egy inicializáló ablak három oszloppal. |
| 2. | Írd be a fenti bemeneti adatokat! Mindegyik elem után kattints rá az adott oszlopban lévő, `Add`-dal kezdődő gombra! | Az oszlopok szövegmezőiben megjelennek a beütött adatok. |
| 3. | Kattints az `OK` gombra! | Az ablak bezárul, a főablakban megjelenik három mező. A mezőket kattintással és húzással lehet átrendezni, rendezd át őket, és győződj meg róla, hogy mind a három mező össze van kötve a másik kettővel! |
