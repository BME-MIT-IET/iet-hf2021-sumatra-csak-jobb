# Unit tesztek

 A dokumentum célja összefoglalni, hogy milyen módon járult hozzá a unit tesztelés a projekt minőségének javítására, és hogy kifejtse az alapvető alapelveket, amik mentén a tesztek készültek.

## Alkalmazott tesztelési technikák

* Mind fehér-, mind feketedoboz technikákat alkalmaztunk a unit tesztek elkészítésénél.

* A tesztesetek elkészítésénél alkalmaztuk az ekvivalencia partícionálás és határérték-analízis technikákat.

* A legfőbb metrikáink a metódus- és sorlefedettség voltak. Az általunk használt IntelliJ fejlesztő környezet nyújtott számunkra e téren segítséget.

## Alkalmazott technológia

Mivel a házi feladat által vizsgált projekt Java nyelven íródott, így JUnit teszteket készítettünk.

## A Unit tesztek konklúziói 

* A unit tesztek automatizáltak, így sok könnyebbséget ad a fejlesztőknek.

* Sikerült elérni .......%-os kódsor lefedettségi metrikát. Ez az eredmény és a tudatos teszttervezés nagyobb bizonyosságot ad arról, hogy az osztályok implemetációja helyes.

* A projekthez korábbi félévekben készült dokumentáció illetve a kódban lévő kommentezés több helyen hiányos volt. Így a szerződések nem voltak többször egyértelműek. A tesztelés segített egyértelműsíteni, hogy milyen szerződései legyenek egyes osztályok bizonyos függvényeinek.

* A unit tesztek segítségével könnyebb refaktorálásokat elvégezni a projekten a későbbiekben.

## Ajánlások

* A World jelenleg isten-osztály. Ennek az az oka, hogy ebben az osztályban (és több másik osztályban is) jelentősen keveredik a betöltés logikája a modell logikájával. Érdemes lenne ezeket különválasztani. 

