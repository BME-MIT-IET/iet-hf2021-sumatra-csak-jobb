package sumatra;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@BenchmarkMode({Mode.Throughput, Mode.SingleShotTime, Mode.AverageTime})
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 2, jvmArgs = {"-Xms2G", "-Xmx2G"})
@State(Scope.Thread)
@Measurement(iterations = 3)
@Warmup(iterations = 2)
public class LoadBenchmark {
    Random r = new Random();
    ArrayList<String> mapconf;
    ArrayList<String> creaturesconf;
    @Param({"10", "100", "250", "500", "1000", "5000"})
    int tilescount = 0;
    @Param({"10", "100", "250", "500", "1000", "5000"})
    int creaturescount = 0;
    World w;
    @Setup(Level.Trial)
    public void generateMap() {
        w = World.getInstance();
        mapconf = new ArrayList<>();
        for(int i = 0; i < tilescount; i++) {
            mapconf.add("S 1 none 1");
        }
        for(int i = 0; i < tilescount; i++) {
            for (int k = 0; k < i; k++) {
                mapconf.add(k + " " + i);
            }
        }
        creaturesconf = new ArrayList<>();
        for(int i = 0; i < creaturescount; i++) {
            creaturesconf.add(r.nextInt(tilescount) + " researcher");
        }
    }

    @Benchmark
    public void LoadMap() {
        w.generateTilesFrom(mapconf, tilescount, tilescount*(tilescount-1)/2);
        w.generateCreaturesFrom(creaturesconf);
    }
}
