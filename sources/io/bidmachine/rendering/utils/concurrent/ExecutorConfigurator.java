package io.bidmachine.rendering.utils.concurrent;

/* JADX INFO: loaded from: classes8.dex */
public class ExecutorConfigurator {
    public static final float DEFAULT_CPU_USAGE_FRACTION = 0.25f;
    public static final float DEFAULT_SERVICE_TIME_RATIO = 0.100000024f;
    public static final float DEFAULT_WAIT_TIME_RATIO = 0.9f;
    public static final float MIN_CPU_USAGE_FRACTION = 1.0E-4f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f12439a;
    private final int b;

    public ExecutorConfigurator() {
        this(0.25f, 0.9f);
    }

    static float b(float f) {
        return Math.max(0.0f, Math.min(1.0f, f));
    }

    int a() {
        return Runtime.getRuntime().availableProcessors();
    }

    public int getCorePoolSize() {
        return this.f12439a;
    }

    public int getMaximumPoolSize() {
        return this.b;
    }

    public ExecutorConfigurator(float cpuUsageFraction) {
        this(cpuUsageFraction, 0.9f);
    }

    static int a(int i, float f) {
        return Math.max(1, Math.round(i * f));
    }

    public ExecutorConfigurator(float cpuUsageFraction, float waitTimeRatio) {
        float fA = a(cpuUsageFraction);
        float fB = b(waitTimeRatio);
        int iA = a(a(), fA);
        this.f12439a = iA;
        this.b = a(iA, 1.0f - fB, fB);
    }

    static int a(int i, float f, float f2) {
        if (f <= 0.0f) {
            return Integer.MAX_VALUE;
        }
        return Math.round(i * ((f2 / f) + 1.0f));
    }

    static float a(float f) {
        return Math.max(f, 1.0E-4f);
    }
}
