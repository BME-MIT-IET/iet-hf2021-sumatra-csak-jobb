# Tile - unit test

## Lény lép a mezőre

### Követelmény: 
Lény lép a hagyományos jégmezőre, akkor a mezőn levő lények között megjelenik az a lény.

### Tesztelt függvény:

Tile.accept(Creature)

### Esetek:

* A jégmezőn alapértelmezetten nem tartózkodik senki sem. 
* A jégmezőre egy lény lép.
* A jégmezőre több lény lép, és mindegyiket fogadja a jégmezőn.

## Lény eltávolítása a mezőről

### Követelmény:

Ha egy, a jégmezőn levő lényt eltávolítunk onnan, akkor ez eltűnik róla.

### Tesztelt függvény:

Tile.remove(Creature)

### Esetek:

* A lény a mezőn van
* A lény nincs a mezőn


