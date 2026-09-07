package com.bytedance.adsdk.Og.pA.Og;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class pA<K, A> {
    protected com.bytedance.adsdk.Og.SD.Og<A> KZx;
    private final KZx<K> ML;
    final List<InterfaceC0167pA> pA = new ArrayList(1);
    private boolean ZZv = false;
    protected float Og = 0.0f;
    private A JG = null;
    private float SD = -1.0f;
    private float omh = -1.0f;

    private interface KZx<T> {
        float KZx();

        com.bytedance.adsdk.Og.SD.pA<T> Og();

        boolean Og(float f);

        float ZZv();

        boolean pA();

        boolean pA(float f);
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.Og.pA.Og.pA$pA, reason: collision with other inner class name */
    public interface InterfaceC0167pA {
        void pA();
    }

    abstract A pA(com.bytedance.adsdk.Og.SD.pA<K> pAVar, float f);

    pA(List<? extends com.bytedance.adsdk.Og.SD.pA<K>> list) {
        this.ML = pA(list);
    }

    public void pA() {
        this.ZZv = true;
    }

    public void pA(InterfaceC0167pA interfaceC0167pA) {
        this.pA.add(interfaceC0167pA);
    }

    public void pA(float f) {
        if (this.ML.pA()) {
            return;
        }
        if (f < Bzk()) {
            f = Bzk();
        } else if (f > JG()) {
            f = JG();
        }
        if (f == this.Og) {
            return;
        }
        this.Og = f;
        if (this.ML.pA(f)) {
            Og();
        }
    }

    public void Og() {
        for (int i = 0; i < this.pA.size(); i++) {
            this.pA.get(i).pA();
        }
    }

    protected com.bytedance.adsdk.Og.SD.pA<K> KZx() {
        com.bytedance.adsdk.Og.ML.pA("BaseKeyframeAnimation#getCurrentKeyframe");
        com.bytedance.adsdk.Og.SD.pA<K> pAVarOg = this.ML.Og();
        com.bytedance.adsdk.Og.ML.Og("BaseKeyframeAnimation#getCurrentKeyframe");
        return pAVarOg;
    }

    float ZZv() {
        if (this.ZZv) {
            return 0.0f;
        }
        com.bytedance.adsdk.Og.SD.pA<K> pAVarKZx = KZx();
        if (pAVarKZx.ML()) {
            return 0.0f;
        }
        return (this.Og - pAVarKZx.KZx()) / (pAVarKZx.ZZv() - pAVarKZx.KZx());
    }

    protected float ML() {
        com.bytedance.adsdk.Og.SD.pA<K> pAVarKZx = KZx();
        if (pAVarKZx == null || pAVarKZx.ML()) {
            return 0.0f;
        }
        return pAVarKZx.KZx.getInterpolation(ZZv());
    }

    private float Bzk() {
        if (this.SD == -1.0f) {
            this.SD = this.ML.KZx();
        }
        return this.SD;
    }

    float JG() {
        if (this.omh == -1.0f) {
            this.omh = this.ML.ZZv();
        }
        return this.omh;
    }

    public A SD() {
        A aPA;
        float fZZv = ZZv();
        if (this.KZx == null && this.ML.Og(fZZv)) {
            return this.JG;
        }
        com.bytedance.adsdk.Og.SD.pA<K> pAVarKZx = KZx();
        if (pAVarKZx.ZZv != null && pAVarKZx.ML != null) {
            aPA = pA(pAVarKZx, fZZv, pAVarKZx.ZZv.getInterpolation(fZZv), pAVarKZx.ML.getInterpolation(fZZv));
        } else {
            aPA = pA(pAVarKZx, ML());
        }
        this.JG = aPA;
        return aPA;
    }

    public float omh() {
        return this.Og;
    }

    protected A pA(com.bytedance.adsdk.Og.SD.pA<K> pAVar, float f, float f2, float f3) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    private static <T> KZx<T> pA(List<? extends com.bytedance.adsdk.Og.SD.pA<T>> list) {
        if (list.isEmpty()) {
            return new Og();
        }
        if (list.size() == 1) {
            return new ML(list);
        }
        return new ZZv(list);
    }

    private static final class Og<T> implements KZx<T> {
        @Override // com.bytedance.adsdk.Og.pA.Og.pA.KZx
        public float KZx() {
            return 0.0f;
        }

        @Override // com.bytedance.adsdk.Og.pA.Og.pA.KZx
        public float ZZv() {
            return 1.0f;
        }

        @Override // com.bytedance.adsdk.Og.pA.Og.pA.KZx
        public boolean pA() {
            return true;
        }

        @Override // com.bytedance.adsdk.Og.pA.Og.pA.KZx
        public boolean pA(float f) {
            return false;
        }

        private Og() {
        }

        @Override // com.bytedance.adsdk.Og.pA.Og.pA.KZx
        public com.bytedance.adsdk.Og.SD.pA<T> Og() {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.bytedance.adsdk.Og.pA.Og.pA.KZx
        public boolean Og(float f) {
            throw new IllegalStateException("not implemented");
        }
    }

    private static final class ML<T> implements KZx<T> {
        private float Og = -1.0f;
        private final com.bytedance.adsdk.Og.SD.pA<T> pA;

        @Override // com.bytedance.adsdk.Og.pA.Og.pA.KZx
        public boolean pA() {
            return false;
        }

        ML(List<? extends com.bytedance.adsdk.Og.SD.pA<T>> list) {
            this.pA = list.get(0);
        }

        @Override // com.bytedance.adsdk.Og.pA.Og.pA.KZx
        public boolean pA(float f) {
            return !this.pA.ML();
        }

        @Override // com.bytedance.adsdk.Og.pA.Og.pA.KZx
        public com.bytedance.adsdk.Og.SD.pA<T> Og() {
            return this.pA;
        }

        @Override // com.bytedance.adsdk.Og.pA.Og.pA.KZx
        public float KZx() {
            return this.pA.KZx();
        }

        @Override // com.bytedance.adsdk.Og.pA.Og.pA.KZx
        public float ZZv() {
            return this.pA.ZZv();
        }

        @Override // com.bytedance.adsdk.Og.pA.Og.pA.KZx
        public boolean Og(float f) {
            if (this.Og == f) {
                return true;
            }
            this.Og = f;
            return false;
        }
    }

    private static final class ZZv<T> implements KZx<T> {
        private final List<? extends com.bytedance.adsdk.Og.SD.pA<T>> pA;
        private com.bytedance.adsdk.Og.SD.pA<T> KZx = null;
        private float ZZv = -1.0f;
        private com.bytedance.adsdk.Og.SD.pA<T> Og = KZx(0.0f);

        @Override // com.bytedance.adsdk.Og.pA.Og.pA.KZx
        public boolean pA() {
            return false;
        }

        ZZv(List<? extends com.bytedance.adsdk.Og.SD.pA<T>> list) {
            this.pA = list;
        }

        @Override // com.bytedance.adsdk.Og.pA.Og.pA.KZx
        public boolean pA(float f) {
            if (this.Og.pA(f)) {
                return !this.Og.ML();
            }
            this.Og = KZx(f);
            return true;
        }

        private com.bytedance.adsdk.Og.SD.pA<T> KZx(float f) {
            List<? extends com.bytedance.adsdk.Og.SD.pA<T>> list = this.pA;
            com.bytedance.adsdk.Og.SD.pA<T> pAVar = list.get(list.size() - 1);
            if (f >= pAVar.KZx()) {
                return pAVar;
            }
            for (int size = this.pA.size() - 2; size > 0; size--) {
                com.bytedance.adsdk.Og.SD.pA<T> pAVar2 = this.pA.get(size);
                if (this.Og != pAVar2 && pAVar2.pA(f)) {
                    return pAVar2;
                }
            }
            return this.pA.get(0);
        }

        @Override // com.bytedance.adsdk.Og.pA.Og.pA.KZx
        public com.bytedance.adsdk.Og.SD.pA<T> Og() {
            return this.Og;
        }

        @Override // com.bytedance.adsdk.Og.pA.Og.pA.KZx
        public float KZx() {
            return this.pA.get(0).KZx();
        }

        @Override // com.bytedance.adsdk.Og.pA.Og.pA.KZx
        public float ZZv() {
            List<? extends com.bytedance.adsdk.Og.SD.pA<T>> list = this.pA;
            return list.get(list.size() - 1).ZZv();
        }

        @Override // com.bytedance.adsdk.Og.pA.Og.pA.KZx
        public boolean Og(float f) {
            com.bytedance.adsdk.Og.SD.pA<T> pAVar = this.KZx;
            com.bytedance.adsdk.Og.SD.pA<T> pAVar2 = this.Og;
            if (pAVar == pAVar2 && this.ZZv == f) {
                return true;
            }
            this.KZx = pAVar2;
            this.ZZv = f;
            return false;
        }
    }
}
