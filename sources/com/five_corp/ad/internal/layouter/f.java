package com.five_corp.ad.internal.layouter;

import com.five_corp.ad.internal.ad.fullscreen.m;
import com.five_corp.ad.internal.ad.fullscreen.o;
import com.five_corp.ad.internal.ad.fullscreen.p;
import com.five_corp.ad.internal.ad.s;

/* JADX INFO: loaded from: classes10.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f1417a;
    public final com.five_corp.ad.internal.ad.fullscreen.f b;
    public final o c;
    public final p d;
    public final com.five_corp.ad.internal.ad.custom_layout.d e;
    public final com.five_corp.ad.internal.ad.custom_layout.d f;
    public final s g;
    public final s h;

    public f(com.five_corp.ad.internal.ad.fullscreen.h hVar) {
        this.f1417a = Boolean.valueOf(hVar.b);
        this.b = hVar.c;
        this.c = hVar.d;
        this.d = hVar.e;
        com.five_corp.ad.internal.ad.custom_layout.d dVar = hVar.g;
        this.e = dVar;
        com.five_corp.ad.internal.ad.custom_layout.d dVar2 = hVar.i;
        this.f = dVar2 != null ? dVar2 : dVar;
        s sVar = hVar.f;
        this.g = sVar;
        s sVar2 = hVar.h;
        this.h = sVar2 != null ? sVar2 : sVar;
    }

    public f(m mVar) {
        this.f1417a = Boolean.valueOf(mVar.f1299a);
        this.b = mVar.c;
        this.c = mVar.d;
        this.d = null;
        com.five_corp.ad.internal.ad.custom_layout.d dVar = mVar.f;
        this.e = dVar;
        com.five_corp.ad.internal.ad.custom_layout.d dVar2 = mVar.h;
        this.f = dVar2 != null ? dVar2 : dVar;
        s sVar = mVar.e;
        this.g = sVar;
        s sVar2 = mVar.g;
        this.h = sVar2 != null ? sVar2 : sVar;
    }
}
