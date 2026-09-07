package com.five_corp.ad;

/* JADX INFO: loaded from: classes12.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1257a = 0;
    public final /* synthetic */ f b;

    public b(f fVar) {
        this.b = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f1257a;
        this.f1257a = i + 1;
        if (i > 25) {
            return;
        }
        if (f.a(this.b.f1259a)) {
            this.b.d.postDelayed(this, 200L);
            return;
        }
        try {
            this.b.j();
        } catch (Exception e) {
            f fVar = this.b;
            fVar.a(fVar.h.getCurrentPositionMs(), new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.e4, null, e, null));
        }
    }
}
