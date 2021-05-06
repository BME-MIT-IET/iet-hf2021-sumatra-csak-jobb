package sumatra;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 2, jvmArgs = {"-Xms2G", "-Xmx2G"})
@State(Scope.Benchmark)
public class LoadBenchmark {
    ArrayList<String> configure;
    int size = 0;
    World w;
    @Setup(Level.Trial)
    public void generateMap() {
        final int size = 10;
        this.size = size;
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
    public void LoadMap10() {
        w.generateTilesFrom(configure, size, size*(size-1)/2);
    }
}
