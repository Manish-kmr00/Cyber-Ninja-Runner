package com.ogury.ad.internal;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class i1 implements q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f7318a = new ArrayList();

    @Override // com.ogury.ad.internal.q1
    public final void a() {
        Iterator it = this.f7318a.iterator();
        while (it.hasNext()) {
            ((q1) it.next()).a();
        }
        this.f7318a.clear();
    }
}
