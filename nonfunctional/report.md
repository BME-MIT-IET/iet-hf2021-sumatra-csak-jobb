# Nem-funkcionális tesztek értékelése

## Felület használhatósága
### Mezők hozzáadása
Az Initializatinon/Map menüpont esetén a következő megállapításokra jutottam a felület használhatósága és kezelhetőségével kapcsolatban.

Mezők hozzáadásánál mindkét számbeviteli mező esetén egy bug vehető észre: Ha az alapértelmezett nullás értéket felülírjuk valamilyen nullánál nagyobb számmal, akkor a továbbiakban a szám első számjegye már nem állítható be, nem törölhető. Csak a felugró ablak bezárása után. Ekkor nyilván valóan az addigi beállításaink elvesznek. 

A felhasználók szempontjából jobb lenne ha az előző bekezdésben említett beviteli mezők esetén megjeleníteni, melyik mire vonatkozik: az egyikkel a táblamezőt fedő hóvastagság, a másik beviteli mezővel pedig a teherbírását lehet beállítani. Ugyanakkor ez a lehetőség csak _unstable tile_ esetén kell, így be lehetne állítani, hogy csak ez esetben lehssen ezt az opciót megadni.

### Játéktér
A játik inicializálása után a felvett mezőktől függően előfordulhat olyan megjelenítés, amikor az egyes szomszédsági viszonyok nem láthatóak a mezők elhelyezkedése miatt. Érdemesebb valamilyen síkbarajzoló algoritmust felhasználni ezek elrendezésére. 

Ha a felhasználó maga akarja átrendezni a játékteret, akkor azt a szokványos egérmozdulatokkal megteheti. Viszont ha a felhasználó felfele vagy balra húzza a mezőket és kihúzza őket az ablakból, akkor azok már nem rendezhetőek vissza, mert a keret nem követi le a mozgásukat.

Ha a játékban 9-nél tőbb karakter van és ezek mind egy táblán vannak, akkor csak az utolsó 9 karakter jeleníthető meg a mezőn. Illetve a részletező oldalon sem látható, hogy a többi karakter pontosan hol, melyik mezően áll, esetleg ugyanazon. 

### Betöltés
A játék használhatóságát a grafikai rendszer teljesítményével is felmértem. A játék betöltéséhez létrehoztam egy segéd script-et, amivel könnyen lehet a játék inicializálásához szükséges konfigurációs fájlt előállítani. 

A segédprogram: `nonfunctional/bigmap/makemap.py`, melynek kettő paramétert kell megadni a parancssorból: `makemap.py {kimeneti fájl} {mezők száma}` A program egy bemeneti, a mezőket leíró fájlt készít, a mezők teljes gráfot alkotnak. Ez a fájl a `File/Load` menüvel betölthető

A kezelhetőség szempontjából az alábbi teszteket futtatam:
 * `python3 makemap.py big50.txt 50` a felület könnyedén használható
 * `python3 makemap.py big100.txt 100` a felület könnyedén használható, kicsi akadás
 * `python3 makemap.py big1000.txt 1000` a felület nem használható érdemben

## JMH
Java Microbenchmark Harness: [github](https://github.com/openjdk/jmh)

Az eszközzel néhány alapvető teljesítménymérést lehet elvégezni a kódon.
A JMH a következő adatokat tudja kiszámítani:
* Átbocsátás (Throughput) 
* Átlagos idő (Average time) 
* Mintaidő (Sample time) 
* Első futás (Single shot time)

Az eszközzel továbbá az alábbi opciókat tudjuk megadni a benchmark futtatásakor:
* Warmup iterációk száma (hányszor futtassa elő - a kód optimalizálását közben végzi a JIT)
* Fork iteráció (a háttérben futó egyéb CPU tevékenységek, GC viselkedés... tompitására)
* Tiszta iterációk száma
* a mérés elvégzése előtti inicializáló lépések

### A játék inicializálásának mérése
Az `src/jmh/java/sumatra/LoadBenchmark` a kódból történő játékbetöltést vizsgálja: a mezők hozzáadása és a szomszédsággi viszonyok kiépítése mennyi ideig tart különböző beállításokkal, továbbá néhány karaktert is elhelyez a mezőkön.

Ennek az eredménye látható a `nonfunctional/bigmap/results.txt` fájlban. Az átlagos futási időt szeretném kiemelni:
```text
Benchmark              (creaturescount)  (tilescount)   Mode  Cnt     Score     Error   Units
LoadBenchmark.LoadMap                10            10   avgt    6     0,010 ±   0,001   ms/op
LoadBenchmark.LoadMap                10           100   avgt    6     0,705 ±   0,143   ms/op
LoadBenchmark.LoadMap                10           250   avgt    6     4,351 ±   0,790   ms/op
LoadBenchmark.LoadMap                10           500   avgt    6    18,612 ±   5,423   ms/op
LoadBenchmark.LoadMap                10          1000   avgt    6    76,514 ±   6,156   ms/op
LoadBenchmark.LoadMap                10          5000   avgt    6  2704,988 ± 548,049   ms/op
LoadBenchmark.LoadMap               100            10   avgt    6     0,027 ±   0,003   ms/op
LoadBenchmark.LoadMap               100           100   avgt    6     0,655 ±   0,044   ms/op
LoadBenchmark.LoadMap               100           250   avgt    6     4,002 ±   0,246   ms/op
LoadBenchmark.LoadMap               100           500   avgt    6    16,612 ±   0,383   ms/op
LoadBenchmark.LoadMap               100          1000   avgt    6    72,511 ±  12,560   ms/op
LoadBenchmark.LoadMap               100          5000   avgt    6  2184,867 ± 210,179   ms/op
LoadBenchmark.LoadMap               250            10   avgt    6     0,072 ±   0,034   ms/op
LoadBenchmark.LoadMap               250           100   avgt    6     0,712 ±   0,050   ms/op
LoadBenchmark.LoadMap               250           250   avgt    6     4,060 ±   0,196   ms/op
LoadBenchmark.LoadMap               250           500   avgt    6    16,945 ±   1,294   ms/op
LoadBenchmark.LoadMap               250          1000   avgt    6    70,936 ±   2,729   ms/op
LoadBenchmark.LoadMap               250          5000   avgt    6  2175,963 ± 205,822   ms/op
LoadBenchmark.LoadMap               500            10   avgt    6     0,165 ±   0,022   ms/op
LoadBenchmark.LoadMap               500           100   avgt    6     0,776 ±   0,051   ms/op
LoadBenchmark.LoadMap               500           250   avgt    6     4,141 ±   0,619   ms/op
LoadBenchmark.LoadMap               500           500   avgt    6    16,220 ±   1,380   ms/op
LoadBenchmark.LoadMap               500          1000   avgt    6    66,604 ±   1,264   ms/op
LoadBenchmark.LoadMap               500          5000   avgt    6  2173,017 ± 219,286   ms/op
LoadBenchmark.LoadMap              1000            10   avgt    6     0,532 ±   0,014   ms/op
LoadBenchmark.LoadMap              1000           100   avgt    6     1,135 ±   0,009   ms/op
LoadBenchmark.LoadMap              1000           250   avgt    6     4,460 ±   0,023   ms/op
LoadBenchmark.LoadMap              1000           500   avgt    6    16,668 ±   0,487   ms/op
LoadBenchmark.LoadMap              1000          1000   avgt    6    66,908 ±   1,934   ms/op
LoadBenchmark.LoadMap              1000          5000   avgt    6  2040,818 ± 301,271   ms/op
LoadBenchmark.LoadMap              5000            10   avgt    6    20,133 ±   2,767   ms/op
LoadBenchmark.LoadMap              5000           100   avgt    6    22,203 ±   6,498   ms/op
LoadBenchmark.LoadMap              5000           250   avgt    6    26,105 ±   4,633   ms/op
LoadBenchmark.LoadMap              5000           500   avgt    6    43,156 ±   8,731   ms/op
LoadBenchmark.LoadMap              5000          1000   avgt    6   102,020 ±   6,710   ms/op
LoadBenchmark.LoadMap              5000          5000   avgt    6  2820,778 ± 252,380   ms/op
```

Jól látható hogy a mezők beállítása tartott nagyon sokáig a létrehozott karakterek számától függetlenül, hiszen a szomszédsággi viszonyok száma `n*n` komplexitású `n` db mező esetén. 


