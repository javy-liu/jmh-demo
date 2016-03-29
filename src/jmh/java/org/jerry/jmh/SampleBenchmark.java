package org.jerry.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author liuzhenyuan
 * @version Last modified 16/3/29
 */
public class SampleBenchmark {

    @State(Scope.Thread)
    public static class Point {

        private static final double MAX_VALUE = 10_000;
        public final double a, b;

        public Point() {
            a = ThreadLocalRandom.current().nextDouble(MAX_VALUE);
            b = ThreadLocalRandom.current().nextDouble(MAX_VALUE);
        }
    }

    @Benchmark
    public double measureHypot_baseline(Point p) {
        return Math.sqrt(p.a * p.a + p.b * p.b);
    }

}
