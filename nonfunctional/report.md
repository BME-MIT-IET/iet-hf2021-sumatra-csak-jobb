# Nem-funkcionális tesztek értékelése

## Felület használhatósága
### Initialization/World Creator
 * a mezők hozzáadásánál ha a kezdeti 0 érték helyett más értéket írunk be, első számjegye már nem törölhető 
 * nem írja felület, hogy az egyes bemenetek, mire vonatkoznak
### Játéktér
 * a játéktéren nem ergonómikusan helyezkednek el a mezőket jelző téglalapok, a mezők között lévő szomszédsági kapcsolatokat könnyen kitakarhatják
 * ha a felhasználó felfele vagy balra kihúzza a mezőket, akkor azok már nem húzhatók vissza, az játéktér nem megfelelően scrollozható
 * egy mezőn maximum csak 9 karakter látható, a bal oldali sávban nem írja ki melyik mezőn áll

## Teljesítménytesztek
### Betöltés
Segédprogram: `nonfunctional/bigmap/makemap.py {kimeneti fájl} {mezők száma}` A program egy bemeneti, a mezőket leíró fájlt készít, a mezők teljes gráfot alkotnak. Ez a fájl a `File/Load` menüvel betölthető
 * `python3 makemap.py big50.txt 50` a felület könnyedén használható
 * `python3 makemap.py big100.txt 100` a felület könnyedén használható, kicsi akadás
 * `python3 makemap.py big1000.txt 1000` a felület nem használható érdemben


