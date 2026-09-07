package com.five_corp.ad.internal.http.movcache;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ArrayList f1397a;
    public final /* synthetic */ h b;

    public a(h hVar, ArrayList arrayList) {
        this.b = hVar;
        this.f1397a = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator it = this.f1397a.iterator();
        boolean z = false;
        while (it.hasNext()) {
            com.five_corp.ad.internal.util.f fVarA = h.a(this.b, new com.five_corp.ad.internal.http.a((com.five_corp.ad.internal.ad.a) it.next(), null, 1));
            if (fVarA.f1560a && ((Boolean) fVarA.c).booleanValue()) {
                z = true;
            }
        }
        if (z) {
            h.a(this.b);
        }
    }
}
