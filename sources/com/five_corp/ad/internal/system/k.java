package com.five_corp.ad.internal.system;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes12.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ArrayList f1548a;

    public k(ArrayList arrayList) {
        this.f1548a = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator it = this.f1548a.iterator();
        while (it.hasNext()) {
            ((com.five_corp.ad.f) ((d) it.next())).p();
        }
    }
}
