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

* Sikerült elérni .......%-os kódsor lefedettségi metrikát. Ez az arány azért nem magas, mivel a kódban jelentősen keverednek a betöltési/mentési funkciók és a modell logikája. Ez nem jó, a projektnek talán ez a legnagyobb hátulütője. A modell függvényeinek tesztelése részletes és tudatos tervezés eredménye, ami nagyobb bizonyosságot ad arról, hogy az osztályok implementációja helyes. A unit tesztekkel nem tesztelhető részeket manuális illetve félautomatizált módon teszteltük.

* A projekthez korábbi félévekben készült dokumentáció illetve a kódban lévő kommentezés több helyen hiányos volt. Így a szerződések nem voltak többször egyértelműek. A tesztelés segített egyértelműsíteni, hogy milyen szerződései legyenek egyes osztályok bizonyos függvényeinek.

* A projekt több helyen nem tartja be az OOP alapelveket, ez a unit tesztelést jelentős mértékben hátráltatta

* A unit tesztek segítségével könnyebb refaktorálásokat elvégezni a projekten a későbbiekben.

* A unit tesztek egyben példakódok is, amik használhatósági hiányosságokra rávilágítottak.

* A World osztály eredetileg semmilyen szinten nem volt unit tesztelhető. Ehhez kisebb átalakításokat kellett eszközölni.

## Ajánlások 

* A World jelenleg isten-osztály. Ennek az az oka, hogy ebben az osztályban (és több másik osztályban is) jelentősen keveredik a betöltés logikája a modell logikájával. Érdemes lenne ezeket különválasztani. Ez a megállapítás több más modellbeli osztályra is érvényes lehet.

* A projektben rengetes string konstans van, ezeket is érdemes lenne kiszervezni egy helyre az SCP elvnek megfelelően.

* A kommentek sok helyen elnagyoltak, nagyobb hangsúlyt kell fektetni a megfelelő kommentezésre és dokumentációra. A metódusoknak precízebben definiált szerződésekkel kell rendelkezniük. 

* Az OOP elvek betartása nagyban segítené a tesztelők munkáját is, miközben a fejlesztőknek is könnyebb dolga lenne, így ajánljuk azok betartását.

