package com.five_corp.ad.internal.bgtask;

/* JADX INFO: loaded from: classes12.dex */
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1334a;
    public final com.five_corp.ad.internal.j b;

    public m(int i) {
        this.f1334a = i;
        this.b = null;
    }

    public final void a() {
        com.five_corp.ad.internal.j jVar = this.b;
        if (jVar != null) {
            synchronized (jVar.g) {
                jVar.h = false;
            }
        }
    }

    public abstract boolean b();

    public m(com.five_corp.ad.internal.j jVar) {
        this.f1334a = 3;
        this.b = jVar;
    }
}
