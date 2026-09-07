package com.bytedance.adsdk.Og;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes12.dex */
public class Wx<T> {
    public static Executor pA = Executors.newCachedThreadPool();
    private final Set<BSW<Throwable>> KZx;
    private volatile WV<T> ML;
    private final Set<BSW<T>> Og;
    private final Handler ZZv;

    public Wx(Callable<WV<T>> callable) {
        this(callable, false);
    }

    Wx(Callable<WV<T>> callable, boolean z) {
        this.Og = new LinkedHashSet(1);
        this.KZx = new LinkedHashSet(1);
        this.ZZv = new Handler(Looper.getMainLooper());
        this.ML = null;
        if (z) {
            try {
                pA((WV) callable.call());
                return;
            } catch (Throwable th) {
                pA((WV) new WV<>(th));
                return;
            }
        }
        pA.execute(new pA(callable));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(WV<T> wv) {
        if (this.ML != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.ML = wv;
        pA();
    }

    public synchronized Wx<T> pA(BSW<T> bsw) {
        WV<T> wv = this.ML;
        if (wv != null && wv.pA() != null) {
            bsw.pA(wv.pA());
        }
        this.Og.add(bsw);
        return this;
    }

    public synchronized Wx<T> Og(BSW<T> bsw) {
        this.Og.remove(bsw);
        return this;
    }

    public synchronized Wx<T> KZx(BSW<Throwable> bsw) {
        WV<T> wv = this.ML;
        if (wv != null && wv.Og() != null) {
            bsw.pA(wv.Og());
        }
        this.KZx.add(bsw);
        return this;
    }

    public synchronized Wx<T> ZZv(BSW<Throwable> bsw) {
        this.KZx.remove(bsw);
        return this;
    }

    private void pA() {
        this.ZZv.post(new Runnable() { // from class: com.bytedance.adsdk.Og.Wx.1
            @Override // java.lang.Runnable
            public void run() {
                WV wv = Wx.this.ML;
                if (wv == null) {
                    return;
                }
                if (wv.pA() != null) {
                    Wx.this.pA(wv.pA());
                } else {
                    Wx.this.pA(wv.Og());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void pA(T t) {
        Iterator it = new ArrayList(this.Og).iterator();
        while (it.hasNext()) {
            ((BSW) it.next()).pA(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void pA(Throwable th) {
        ArrayList arrayList = new ArrayList(this.KZx);
        if (arrayList.isEmpty()) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((BSW) it.next()).pA(th);
        }
    }

    private class pA extends FutureTask<WV<T>> {
        pA(Callable<WV<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            if (isCancelled()) {
                return;
            }
            try {
                Wx.this.pA((WV) get());
            } catch (InterruptedException | ExecutionException e) {
                Wx.this.pA(new WV(e));
            }
        }
    }
}
