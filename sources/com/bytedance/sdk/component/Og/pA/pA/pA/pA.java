package com.bytedance.sdk.component.Og.pA.pA.pA;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes13.dex */
public class pA extends com.bytedance.sdk.component.Og.pA.ZZv {
    public static volatile Bzk pA;
    private ExecutorService ZZv;
    private List<com.bytedance.sdk.component.Og.pA.Og> Og = new CopyOnWriteArrayList();
    private List<com.bytedance.sdk.component.Og.pA.Og> KZx = new CopyOnWriteArrayList();

    @Override // com.bytedance.sdk.component.Og.pA.ZZv
    public int pA() {
        return 0;
    }

    @Override // com.bytedance.sdk.component.Og.pA.ZZv
    public void pA(int i) {
    }

    public pA(ExecutorService executorService) {
        this.ZZv = executorService;
    }

    public static void pA(Bzk bzk) {
        pA = bzk;
    }

    @Override // com.bytedance.sdk.component.Og.pA.ZZv
    public ExecutorService Og() {
        ExecutorService executorServicePA = pA != null ? pA.pA() : null;
        return executorServicePA != null ? executorServicePA : this.ZZv;
    }

    public boolean ML() {
        return (pA == null || pA.pA() == null) ? false : true;
    }

    @Override // com.bytedance.sdk.component.Og.pA.ZZv
    public List<com.bytedance.sdk.component.Og.pA.Og> KZx() {
        return this.Og;
    }

    @Override // com.bytedance.sdk.component.Og.pA.ZZv
    public List<com.bytedance.sdk.component.Og.pA.Og> ZZv() {
        return this.KZx;
    }
}
