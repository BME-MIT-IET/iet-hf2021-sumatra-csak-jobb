# 13 - Játékmenet teszt

Teszteli a játékmenet különböző aspektusainak a grafikus megjelenítését.

## Bemeneti adatok
*Bizonyos lépéseknél szükség van nagyobb mennyiségű bemeneti adatra.
Ezek az átláthatóság kedvéért ebben a részben vannak felsorolva.*

1. [bigWorld.txt](resources/bigWorld.txt), mint szöveges fájl.

## Előkészítés

1. Indítsd el az alkalmazás grafikus felületét!
2. Töltsd be a pályát: `File -> Load`, keresd meg és válaszd ki a resources/bigWorld.txt-t, `Open`.
3. Indítsd el a játékot: `Start automated game`.

## Lépések

| Lépés # | Leírás | Várt eredmény |
| ------- | ------ | ------------- |
| 1. | Kattints a `Move` gombra és válaszd ki az `1`-es mezőt. | A `0`-ás számú téglalap áthelyeződik az `1`-es számú mezőre. Az `Eskimo 0` játékos alatti `WU:` mellett levő érték 1-el csökkent. |
| 2. | Kattints a `Dig` gombra. | Az `1`-es mezőn eltűnik a középső négyzetből a szám és helyette megjelenik egy `I` betű. Az `Eskimo 0` játékos alatti `WU:` mellett levő érték 1-el csökkent.|
| 3. | Kattints a `Pick up item from current tile` gombra. | Az `1`-es mezőn eltűnik a középső négyzetből az `I` betű és baloldalt a `Flareparts` felirat alatt megjelenik a `cartridge`. Az `Eskimo 0` játékos alatti `WU:` mellett levő érték 1-el csökkent.|
| 4. | Kattints a `Use character ability` gombra. | Az `1`-es mezőn a jobb oldali négyzetben egy `I` betű jelenik meg. Az `Eskimo 0` játékos alatti `WU:` mellett levő érték 1-el csökkent.|
| 5. | Próbáld ki az összes lehetőséget jobb oldalról, kivéve a `Finish round` és `Stop game`-et. | Egyik cselekvés se kéne sikerüljön, mert nincs elég work unit-ja a játékosnak. |
| 6. | Kattints a `Finish round`-ra. | Alul megjelenik hogy `Player 1, you're up!` |
| 7. | Most az `1`-es játékost irányítod. Menj el vele egymás után több move-al a `4`-es mezőre, az `1`-es mező fele indulva. | Az `1`-es számú téglalap mindig átlép a következő mezőre. |
| 8. | Nyomd meg kétszer a `Finish round`-ot. | Átvált a `0`-ás játékosra, majd vissza az `1`-esre. |
| 9. | Menj át az `1`-es játékossal a 6-os mezőre. | Ahogy eddig is, a téglalap helyet vált. |
| 10. | Nyomd meg a `Use character ability` gombot. | A `6`-os mezőn eltűnik a `??` és helyébe `s(-1)` lesz. |
| 11. | Menj át a `7`-es mezőre az `1`-es játékossal. | Az `1`-es játékos átkerül a `7`-es mezőre. |
| 12. | Nyomd meg kétszer a `Finish round`-ot. | Átvált a `0`-ás játékosra, majd vissza az `1`-esre. |
| 13. | Nyomd meg a `Use character ability` gombot. | A `7`-es mezőn eltűnik a `??` és helyébe `u(3)` lesz. |
| 14. | Áss addig a `Dig` gombbal, amíg elfogy a hó. | A `7`-es mezőn először csökken a középső négyzetben az érték, majd eltűnik és egy `I` betű lesz helyette. |
| 15. | Nyomd meg a `Pick up item from current tile` gombot. | Az `1`-es mezőn eltűnik a középső négyzetből az `I` betű és baloldalt a `Researcher 1` alatt megjelenik a `tentequipment` |
| 16. | Nyomd meg kétszer a `Finish round`-ot. | Átvált a `0`-ás játékosra, majd vissza az `1`-esre. |
| 17. | Nyomd meg a `Use manual tool` gombot, majd az `Ok`-t. | A `7`-es mezőn a jobb oldali négyzetben egy `T` betű jelenik meg. |


## Megjegyzések

* Mivel a hóviharok véletlenszerűen érkeznek ezért más lehet minden teszteléskor egy kicsit a pálya. Egyes mezőkön több hó lehet. Ilyenkor a tesztekben ha havat kell ásni, akkor addig áss, amíg elfogy az összes. Ez elronthatja a következő lépéseket is, mert kevesebb WU-ja lesz a játékosnak, ilyenkor a `Finish round` kétszeri megnyomásával visszakerülünk az eredeti játékoshoz, de most már tele WU-val.

* A WU fogyásának a vizsgálását csak az elejére írtam le, de ez később is kell működjön.

* Az is megtörténhet hogy a teszt során a hóviharok megölnek egy játékost és vége lesz a játéknak. Ilyenkor kezdd elölről a tesztet, egy idő után túl fognak élni.