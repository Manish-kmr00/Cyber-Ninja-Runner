package com.bytedance.sdk.component.JG.pA.ML;

import java.util.UUID;

/* JADX INFO: loaded from: classes13.dex */
public abstract class ML implements Comparable<ML>, Runnable {
    private String KZx;
    private int pA = 5;
    private String Og = UUID.randomUUID().toString() + "-" + String.valueOf(System.nanoTime());

    public ML(String str) {
        this.KZx = str;
    }

    public void pA(int i) {
        this.pA = i;
    }

    public int pA() {
        return this.pA;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
    public int compareTo(ML ml) {
        if (pA() < ml.pA()) {
            return 1;
        }
        return pA() >= ml.pA() ? -1 : 0;
    }
}
