package com.bytedance.sdk.component.pA;

/* JADX INFO: loaded from: classes11.dex */
public abstract class ZZv<P, R> extends com.bytedance.sdk.component.pA.Og<P, R> {
    private JG KZx;
    private pA Og;
    private boolean pA = true;

    public interface Og {
        ZZv pA();
    }

    interface pA {
        void pA(Object obj);

        void pA(Throwable th);
    }

    protected abstract void pA(P p, JG jg) throws Exception;

    @Override // com.bytedance.sdk.component.pA.Og
    public /* bridge */ /* synthetic */ String pA() {
        return super.pA();
    }

    protected final void pA(R r) {
        if (JG()) {
            this.Og.pA(r);
            ZZv();
        }
    }

    protected final void pA(Throwable th) {
        if (JG()) {
            this.Og.pA(th);
            ZZv();
        }
    }

    protected final void KZx() {
        pA((Throwable) null);
    }

    protected void ZZv() {
        this.pA = false;
        this.KZx = null;
    }

    void pA(P p, JG jg, pA pAVar) throws Exception {
        this.KZx = jg;
        this.Og = pAVar;
        pA(p, jg);
    }

    void ML() {
        ZZv();
    }

    private boolean JG() {
        if (this.pA) {
            return true;
        }
        Bzk.pA(new IllegalStateException("Jsb async call already finished: " + pA() + ", hashcode: " + hashCode()));
        return false;
    }
}
