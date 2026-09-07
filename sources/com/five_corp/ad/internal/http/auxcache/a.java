package com.five_corp.ad.internal.http.auxcache;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes10.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ArrayList f1380a;
    public final /* synthetic */ i b;

    public a(i iVar, ArrayList arrayList) {
        this.b = iVar;
        this.f1380a = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator it = this.f1380a.iterator();
        boolean z = false;
        while (it.hasNext()) {
            k kVarA = i.a(this.b, new com.five_corp.ad.internal.http.a((com.five_corp.ad.internal.ad.a) it.next(), null, 1));
            if (kVarA != null) {
                this.b.i.b.addLast(kVarA);
                z = true;
            }
        }
        if (z) {
            i.a(this.b);
        }
    }
}
