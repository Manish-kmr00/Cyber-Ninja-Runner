package com.bytedance.sdk.component.Og.pA;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes11.dex */
public abstract class BSW implements Cloneable {
    public long JG;
    public TimeUnit KZx;
    public TimeUnit ML;
    public long Og;
    public TimeUnit SD;
    public long ZZv;
    public List<omh> pA;

    public abstract Og pA(Wx wx);

    public abstract ZZv pA();

    public BSW(pA pAVar) {
        this.Og = pAVar.Og;
        this.ZZv = pAVar.ZZv;
        this.JG = pAVar.JG;
        this.pA = pAVar.pA;
        this.KZx = pAVar.KZx;
        this.ML = pAVar.ML;
        this.SD = pAVar.SD;
        this.pA = pAVar.pA;
    }

    public static final class pA {
        public long JG;
        public TimeUnit KZx;
        public TimeUnit ML;
        public long Og;
        public TimeUnit SD;
        public long ZZv;
        public final List<omh> pA;

        public pA() {
            this.pA = new ArrayList();
            this.Og = 10000L;
            this.KZx = TimeUnit.MILLISECONDS;
            this.ZZv = 10000L;
            this.ML = TimeUnit.MILLISECONDS;
            this.JG = 10000L;
            this.SD = TimeUnit.MILLISECONDS;
        }

        public pA(String str) {
            this.pA = new ArrayList();
            this.Og = 10000L;
            this.KZx = TimeUnit.MILLISECONDS;
            this.ZZv = 10000L;
            this.ML = TimeUnit.MILLISECONDS;
            this.JG = 10000L;
            this.SD = TimeUnit.MILLISECONDS;
        }

        public pA(BSW bsw) {
            this.pA = new ArrayList();
            this.Og = 10000L;
            this.KZx = TimeUnit.MILLISECONDS;
            this.ZZv = 10000L;
            this.ML = TimeUnit.MILLISECONDS;
            this.JG = 10000L;
            this.SD = TimeUnit.MILLISECONDS;
            this.Og = bsw.Og;
            this.KZx = bsw.KZx;
            this.ZZv = bsw.ZZv;
            this.ML = bsw.ML;
            this.JG = bsw.JG;
            this.SD = bsw.SD;
        }

        public pA pA(long j, TimeUnit timeUnit) {
            this.Og = j;
            this.KZx = timeUnit;
            return this;
        }

        public pA Og(long j, TimeUnit timeUnit) {
            this.ZZv = j;
            this.ML = timeUnit;
            return this;
        }

        public pA KZx(long j, TimeUnit timeUnit) {
            this.JG = j;
            this.SD = timeUnit;
            return this;
        }

        public pA pA(omh omhVar) {
            this.pA.add(omhVar);
            return this;
        }

        public BSW pA() {
            return com.bytedance.sdk.component.Og.pA.pA.pA.pA(this);
        }
    }

    public pA Og() {
        return new pA(this);
    }
}
