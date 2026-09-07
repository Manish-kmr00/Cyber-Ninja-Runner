package com.mbridge.msdk.tracker;

import android.util.Log;

/* JADX INFO: compiled from: ProcessorWrapper.java */
/* JADX INFO: loaded from: classes7.dex */
class q implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g f5660a;

    public q(g gVar) {
        this.f5660a = gVar;
    }

    @Override // com.mbridge.msdk.tracker.l
    public void a(e eVar) {
        if (y.b(this.f5660a)) {
            return;
        }
        this.f5660a.a(eVar);
    }

    @Override // com.mbridge.msdk.tracker.l
    public void b(e eVar) {
        if (y.b(this.f5660a)) {
            return;
        }
        try {
            h hVarE = eVar.e();
            if (y.a(hVarE)) {
                eVar.a(hVarE.a(eVar));
            }
            this.f5660a.b(eVar);
        } catch (Exception e) {
            if (a.f5612a) {
                Log.e("TrackManager", "process event error", e);
            }
        }
    }

    @Override // com.mbridge.msdk.tracker.l
    public long[] a() {
        if (y.b(this.f5660a)) {
            return new long[]{0, 0};
        }
        return this.f5660a.a();
    }
}
