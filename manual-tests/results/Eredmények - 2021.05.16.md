# Manuális tesztek eredményei

Ebben a fájlban táblázatos formában szerepel az, hogy az egyes tesztek sikeresek voltak-e, vagy nem.

* A tesztek végzője: *Kacsó Péter Gábor*
* A tesztelés időpontja: *2021. május 16.*

| Elvégzett teszteset neve | Sikeres? | Megjegyzések |
| ------------------------ | -------- | ------------ |
| [01 - Világ inicializáció sanity check](../01%20-%20Világ%20inicializáció%20sanity%20check.md) | Igen | |
| [02 - Világ inicializáció lehetséges hibái](../02%20-%20Világ%20inicializáció%20lehetséges%20hibái.md) | Nem | A 2. lépésben létre lehet hozni olyan instabil mezőt, aminek 0 a kapacitása, illetve a 4. lépésben több eszközt is létre lehet hozni ugyanazon a mezőn. Ezenkívül ha megpróbálok létrehozni tárgyat, még azelőtt hogy mezőket készítettem volna, akkor bár úgy tűnik hogy nem engedi, később ha beteszünk egy másik tárgyat, akkor megjelennek -1 index-el azok a tárgyak, melyeket mező nélkül hoztunk létre. |
| [03 - Élőlény inicializáció sanity check](../03%20-%20Élőlény%20inicializáció%20sanity%20check.md) | Igen | |
| [04 - Élőlény inicializáció lehetséges hibái](../04%20-%20Élőlény%20inicializáció%20lehetséges%20hibái.md) | Igen | |
| [05 - Pálya mentése és betöltése](../05%20-%20Pálya%20mentése%20és%20betöltése.md) | Igen | |
| [06 - Pálya betöltése GUI nélküli mentésből](../06%20-%20Pálya%20betöltése%20GUI%20nélküli%20mentésből.md) | Igen | |
| [07 - Pálya mentése és betöltése 2](../07%20-%20Pálya%20mentése%20és%20betöltése%202) | Nem | Bár úgy tűnik hogy jól elmenti, a betöltés nem sikerül, error-t ír ki: `> Error: Could not load savefile. The file either doesn't exist,or it's not a proper save file. > Cause: Invalid Tile config!` |
| [08 - Játék elindítása kézzel elkészített pályából](../08%20-%20Játék%20elindítása%20kézzel%20elkészített%20pályából.md) | Igen | |
| [09 - Játék elindítása betöltött pályából](../09%20-%20Játék%20elindítása%20betöltött%20pályából.md) | Igen | |
| [10 - Játék elindításának lehetséges hibái](../10%20-%20Játék%20elindításának%20lehetséges%20hibái.md) | Nem | Engedi hogy elindítsuk a játékot csak medvével, és utána egyből kifagy a program. |
| [11 - Új játék kezdése amikor már fut egy](../11%20-%20Új%20játék%20kezdése%20amikor%20már%20fut%20egy.md) | Nem | Ha kézzel próbáljuk elkészíteni a pályát, akkor semmi nem történik az `Ok`-ra kattintás után. Ezután egyáltalán nem megy a megmaradt játék sem, nincs hatása a gomboknak. |
| [12 - A játék mező GUI hibáinak felfedezése](../12%20-%20A%20játék%20mező%20GUI%20hibáinak%20felfedezése.md) | Nem | Ha balra vagy felfele kihúzunk egy mezőt és elengedjük, akkor azt már sose tudjuk elérni és látni. |
| [13 - Játékmenet teszt](../13%20-%20Játékmenet%20teszt.md) | Igen | |
| [14 - Medve tesztelése](../14%20-%20Medve%20tesztelése.md) | Igen | |