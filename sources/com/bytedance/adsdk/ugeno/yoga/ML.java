package com.bytedance.adsdk.ugeno.yoga;

/* JADX INFO: loaded from: classes13.dex */
public enum ML {
    LEFT(0),
    TOP(1),
    RIGHT(2),
    BOTTOM(3),
    START(4),
    END(5),
    HORIZONTAL(6),
    VERTICAL(7),
    ALL(8);

    private final int SGo;

    ML(int i) {
        this.SGo = i;
    }

    public int pA() {
        return this.SGo;
    }
}
