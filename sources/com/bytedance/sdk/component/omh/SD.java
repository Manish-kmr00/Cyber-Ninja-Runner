package com.bytedance.sdk.component.omh;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes13.dex */
public class SD<V> extends FutureTask<V> implements Comparable<SD<V>> {
    private int Og;
    private int pA;

    public SD(Callable<V> callable, int i, int i2) {
        super(callable);
        this.pA = i == -1 ? 5 : i;
        this.Og = i2;
    }

    public SD(Runnable runnable, V v, int i, int i2) {
        super(runnable, v);
        this.pA = i == -1 ? 5 : i;
        this.Og = i2;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
    public int compareTo(SD sd) {
        if (pA() < sd.pA()) {
            return 1;
        }
        return pA() > sd.pA() ? -1 : 0;
    }

    public int pA() {
        return this.pA;
    }
}
