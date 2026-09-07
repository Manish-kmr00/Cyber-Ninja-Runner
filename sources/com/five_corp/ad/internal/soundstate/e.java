package com.five_corp.ad.internal.soundstate;

import com.five_corp.ad.internal.cache.x;

/* JADX INFO: loaded from: classes11.dex */
public final class e implements com.five_corp.ad.internal.hub.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f1524a = new Object();
    public d b;

    public e(int i, com.five_corp.ad.internal.hub.a aVar) {
        this.b = new d(i, 1);
    }

    public final d a() {
        d dVar;
        synchronized (this.f1524a) {
            dVar = this.b;
        }
        return dVar;
    }

    @Override // com.five_corp.ad.internal.hub.c
    public final void a(x xVar) {
        int i;
        com.five_corp.ad.internal.media_config.a aVar = xVar.b;
        if (aVar == null) {
            i = 1;
        } else {
            i = aVar.c ? 2 : 3;
        }
        synchronized (this.f1524a) {
            this.b = new d(this.b.f1523a, i);
        }
    }
}
