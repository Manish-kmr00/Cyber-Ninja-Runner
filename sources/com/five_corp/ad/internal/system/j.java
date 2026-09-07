package com.five_corp.ad.internal.system;

import java.util.ArrayList;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes12.dex */
public final class j extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f1547a;

    public j(l lVar) {
        this.f1547a = lVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        ArrayList arrayList;
        l lVar = this.f1547a;
        synchronized (lVar.f1549a) {
            com.five_corp.ad.internal.util.h hVar = lVar.d;
            hVar.getClass();
            arrayList = new ArrayList();
            hVar.a(arrayList);
            if (lVar.e != null && arrayList.isEmpty()) {
                lVar.e.cancel();
                lVar.e = null;
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        lVar.b.post(new k(arrayList));
    }
}
