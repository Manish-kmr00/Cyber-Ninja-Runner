package com.bytedance.sdk.component.JG.pA.pA.Og;

import com.bytedance.sdk.component.JG.pA.ZZv.pA;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes11.dex */
public abstract class ZZv<T extends com.bytedance.sdk.component.JG.pA.ZZv.pA> {
    private Queue<String> KZx;
    private Queue<T> Og = new ConcurrentLinkedQueue();
    private String ZZv;
    private com.bytedance.sdk.component.JG.pA.ZZv.Og.pA pA;

    public ZZv(com.bytedance.sdk.component.JG.pA.ZZv.Og.pA pAVar, Queue<String> queue, String str) {
        this.pA = pAVar;
        this.KZx = queue;
        this.ZZv = str;
    }

    public void pA(T t) {
        Queue<T> queue = this.Og;
        if (queue == null || t == null) {
            return;
        }
        queue.offer(t);
    }

    public synchronized List<com.bytedance.sdk.component.JG.pA.ZZv.pA> pA(int i, int i2) {
        if (!Og(i, i2)) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.pA.pA());
        do {
            T tPoll = this.Og.poll();
            if (tPoll == null) {
                break;
            }
            arrayList.add(tPoll);
        } while (arrayList.size() != this.pA.Og());
        return arrayList;
    }

    public synchronized void pA(int i, List<T> list) {
        try {
            if (i == -1 || i == 200 || i == 509) {
                this.Og.size();
            } else {
                this.Og.addAll(list);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized boolean Og(int i, int i2) {
        int size = this.Og.size();
        int iPA = this.pA.pA();
        if (i != 2 && i != 1) {
            return size >= iPA;
        }
        if (com.bytedance.sdk.component.JG.pA.KZx.pA.KZx()) {
            return size > 0;
        }
        return size >= iPA;
    }
}
