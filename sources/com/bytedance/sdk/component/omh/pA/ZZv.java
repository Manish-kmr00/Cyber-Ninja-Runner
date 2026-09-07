package com.bytedance.sdk.component.omh.pA;

import com.bytedance.sdk.component.omh.pA.KZx;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes13.dex */
public class ZZv<T extends KZx> {
    private BlockingQueue<T> Og = new LinkedBlockingQueue();
    private int pA;

    public static ZZv pA(int i) {
        return new ZZv(i);
    }

    private ZZv(int i) {
        this.pA = i;
    }

    public T pA() {
        return this.Og.poll();
    }

    public boolean pA(T t) {
        if (t == null) {
            return false;
        }
        t.pA();
        if (this.Og.size() >= this.pA) {
            return false;
        }
        return this.Og.offer(t);
    }
}
