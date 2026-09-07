package com.five_corp.ad.internal.cache;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes13.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f1345a;

    public k(o oVar) {
        this.f1345a = oVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f1345a.f1347a) {
            o oVar = this.f1345a;
            ArrayList arrayList = oVar.g;
            boolean z = oVar.f;
            if (arrayList.isEmpty()) {
                return;
            }
            this.f1345a.g = new ArrayList();
            if (z) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((m) it.next()).a(new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.U5, null, null, null));
                }
            } else {
                String strC = this.f1345a.c();
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ((m) it2.next()).a(strC);
                }
            }
        }
    }
}
