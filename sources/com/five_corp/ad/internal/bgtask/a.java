package com.five_corp.ad.internal.bgtask;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f1327a = new Object();
    public final ArrayList b = new ArrayList();
    public final com.five_corp.ad.internal.logger.a c;

    public a(com.five_corp.ad.internal.logger.a aVar) {
        this.c = aVar;
    }

    public final void a(g gVar) {
        synchronized (this.f1327a) {
            this.b.add(gVar);
        }
    }
}
