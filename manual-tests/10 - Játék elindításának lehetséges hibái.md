# 10 - Játék elindításának lehetséges hibái.

Azt teszteli hogy lehetséges-e olyan pályát készíteni hogy a játék hibásan indul el.

## Előkészítés

1. Indítsd el az alkalmazás grafikus felületét!

## Lépések

| Lépés # | Leírás | Várt eredmény |
| ------- | ------ | ------------- |
| 1. | Próbáld meg úgy elindítani a játékot hogy nincs betöltve pálya. | Nem jelenik meg a `Start automated game` gomb. |
| 2. | Próbáld meg úgy elindítani a játékot hogy megnyitod a világ inicializálót (`Initializaion -> Init World`), de nem állítasz be semmit hanem egyből `Ok`-t nyomsz. | Nem jelenik meg a `Start automated game` gomb. |
| 3. | Próbáld meg úgy elindítani a játékot hogy inicializálod a világot valamivel (`Initializaion -> Init World`), de utána nem állítasz be élőlényeket. Próbálj ki különbözőféleképpen inicializált világokat. | Nem jelenik meg a `Start automated game` gomb. |
| 4. | Próbáld meg úgy elindítani a játékot hogy inicializálod a világot valamivel, mint az előző lépésben, utána elindítod az élőlény inicializálót (`Initialization -> Init Creatures`) és nem állítasz be semmit hanem egyből `Ok`-t nyomsz. | Nem jelenik meg a `Start automated game` gomb. |
| 5. | Próbáld meg úgy elindítani a játékot hogy inicializálod a világot valamivel, mint az előző lépésben, utána elindítod az élőlény inicializálót (`Initialization -> Init Creatures`) és csak jegesmedvét teszel be (`Polarbear` kiválasztása, majd `Add creature`).  | Nem jelenik meg a `Start automated game` gomb, vagy megjelenik és rákattintva elindul a játék, és lehet látni ahogy mozog a jegesmedve. |
