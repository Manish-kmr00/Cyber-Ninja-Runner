package com.fyber.inneractive.sdk.flow.storepromo.model;

/* JADX INFO: loaded from: classes12.dex */
public final class a implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f1825a;
    public final String b;
    public final int c;

    public a(String str, b bVar) {
        this.b = str;
        this.f1825a = bVar;
        this.c = -1;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.c - ((a) obj).c;
    }

    public a(String str, b bVar, int i) {
        this.b = str;
        this.f1825a = bVar;
        this.c = i;
    }
}
