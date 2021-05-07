package sumatra;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.All)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 2, jvmArgs = {"-Xms2G", "-Xmx2G"})
@State(Scope.Thread)
@Measurement(iterations = 3)
@Warmup(iterations = 2)
public class LoadBenchmark {
    ArrayList<String> configure;
    @Param({"10", "100", "500", "1000"})
    int size = 0;
    World w;
    @Setup(Level.Trial)
    public void generateMap() {
        System.out.println("Generate Map: " + size);
        w = World.getInstance();
        configure = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            configure.add("S 1 none 1");
        }
        for(int i = 0; i < size; i++) {
            for (int k = 0; k < i; k++) {
                configure.add(k + " " + i);
            }
        }
    }

    @Benchmark
    public void LoadMap() {
        w.generateTilesFrom(configure, size, size*(size-1)/2);
    }
}
