package com.five_corp.ad.internal.http;

import com.five_corp.ad.internal.context.l;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f1379a;
    public final WeakReference b;
    public final int c;

    public a(com.five_corp.ad.internal.ad.a aVar, l lVar, int i) {
        this.f1379a = new WeakReference(aVar);
        this.b = new WeakReference(lVar);
        this.c = i;
    }

    public final boolean a() {
        return (this.f1379a.get() == null && this.b.get() == null) ? false : true;
    }
}
