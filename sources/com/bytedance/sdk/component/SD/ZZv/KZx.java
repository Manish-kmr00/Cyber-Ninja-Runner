package com.bytedance.sdk.component.SD.ZZv;

/* JADX INFO: loaded from: classes3.dex */
public class KZx {
    private Og Og;
    private pA pA;

    public interface Og {
    }

    public enum pA {
        DEBUG,
        INFO,
        ERROR,
        OFF
    }

    private KZx() {
        this.pA = pA.OFF;
        this.Og = new com.bytedance.sdk.component.SD.ZZv.Og();
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.SD.ZZv.KZx$KZx, reason: collision with other inner class name */
    private static class C0195KZx {
        private static final KZx pA = new KZx();
    }

    public static void pA(pA pAVar) {
        synchronized (KZx.class) {
            C0195KZx.pA.pA = pAVar;
        }
    }
}
