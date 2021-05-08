# 05 - Pálya mentése

A pálya mentés funkció működését ellenőrzi. Ha ez a teszt sikertelen, a pálya betöltés teszttel nem érdemes foglalkozni.

## Bemeneti adatok

1. Világ inicializálásához:
    * 1. oszlop: `Stable 0 0`, `Unstable 0 3`, `Hole 0 0`.
    * 2. oszlop: `0 1`, `1 2`, `0 2`.
    * 3. oszlop: `0 Beacon`, `1 Rope`.
2. Élőlények inicializálásához: `Eskimo 0`, `Researcher 0`, `Polarbear 1`.

## Előkészítés

1. Indítsd el az alkalmazás grafikus felületét!
2. Végezd el a világ inicializálását az `Initialization -> Init World` menüpont alatt a bemeneti adatokkal! Mindegyik adat után meg kell nyomni a releváns oszlopban lévő `Add` gombot, majd legvégül az `OK` gombot.
3. Végezd el az élőlények inicializálását az `Initialization -> Init Creatures` menüpont alatt a bemeneti adatokkal! Mindegyik adat után meg kell nyomni az `Add Creature` gombot, majd legvégül az `OK` gombot.
4. Ezek után a játéktéren látnod kell három összekötött mezőt, rajtuk 2, 1, illetve 0 élőlénnyel.

## Lépések

| Lépés # | Leírás | Várt eredmény |
| ------- | ------ | ------------- |
| 1. | Kattints a `File -> Save` menüpontra. Válassz egy tetszőleges mappát és fájlnevet (például `world.txt`), majd kattints a `Save` gombra! | A grafikus felületen lent középen egy visszaigazoló üzenet kell megjelenjen, ami szerint `World saved successfully!`. Ha ez nem jelenik meg, a teszt sikertelen - ez nem egy életbevágóan fontos funkció, de a felhasználó örül minden visszajelzésnek. |
| 2. | Győződj meg arról, hogy ott, ahol elmentetted a fájlt, tényleg létrejött egy vagy több új fájl! Nyisd meg őket! | A fájl(ok) léteznek, nem üresek, és a tartalmuk érzésre megegyezik azzal, amik az előkészítés fázisban létrejöttek. |

## Megjegyzések

* A mentés helyes működésének ellenőrzéséhez érdemes a betöltés tesztet is megcsinálni.