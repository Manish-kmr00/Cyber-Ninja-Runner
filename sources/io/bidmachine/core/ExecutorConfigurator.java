package io.bidmachine.core;

/* JADX INFO: loaded from: classes13.dex */
class ExecutorConfigurator {
    public static final float DEFAULT_CPU_USAGE_FRACTION = 0.25f;
    public static final float DEFAULT_SERVICE_TIME_RATIO = 0.100000024f;
    public static final float DEFAULT_WAIT_TIME_RATIO = 0.9f;
    public static final float MIN_CPU_USAGE_FRACTION = 1.0E-4f;
    private final int corePoolSize;
    private final int maximumPoolSize;

    public ExecutorConfigurator() {
        this(0.25f, 0.9f);
    }

    public ExecutorConfigurator(float f) {
        this(f, 0.9f);
    }

    public ExecutorConfigurator(float f, float f2) {
        float fEnsureMinimumCpuUsage = ensureMinimumCpuUsage(f);
        float fEnsureValidWaitTimeRatio = ensureValidWaitTimeRatio(f2);
        int iCalculateCorePoolSize = calculateCorePoolSize(availableProcessors(), fEnsureMinimumCpuUsage);
        this.corePoolSize = iCalculateCorePoolSize;
        this.maximumPoolSize = calculateMaximumPoolSize(iCalculateCorePoolSize, 1.0f - fEnsureValidWaitTimeRatio, fEnsureValidWaitTimeRatio);
    }

    public int getCorePoolSize() {
        return this.corePoolSize;
    }

    public int getMaximumPoolSize() {
        return this.maximumPoolSize;
    }

    int availableProcessors() {
        return Runtime.getRuntime().availableProcessors();
    }

    static float ensureMinimumCpuUsage(float f) {
        return Math.max(f, 1.0E-4f);
    }

    static float ensureValidWaitTimeRatio(float f) {
        return Math.max(0.0f, Math.min(1.0f, f));
    }

    static int calculateCorePoolSize(int i, float f) {
        return Math.max(1, Math.round(i * f));
    }

    static int calculateMaximumPoolSize(int i, float f, float f2) {
        if (f <= 0.0f) {
            return Integer.MAX_VALUE;
        }
        return Math.round(i * ((f2 / f) + 1.0f));
    }
}
