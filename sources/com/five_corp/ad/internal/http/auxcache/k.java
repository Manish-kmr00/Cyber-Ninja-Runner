package com.five_corp.ad.internal.http.auxcache;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes10.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.five_corp.ad.internal.http.a f1390a;
    public final String b;
    public final com.five_corp.ad.internal.logger.a c;
    public final com.five_corp.ad.internal.storage.d d;
    public final ArrayDeque e;
    public ArrayList f;
    public final ArrayList g;
    public HashMap h;
    public int i;
    public boolean j;

    public k(String str, com.five_corp.ad.internal.http.a aVar, com.five_corp.ad.internal.storage.d dVar, ArrayList arrayList, com.five_corp.ad.internal.logger.a aVar2) {
        this.f1390a = aVar;
        this.d = dVar;
        this.c = aVar2;
        ArrayDeque arrayDeque = new ArrayDeque();
        this.e = arrayDeque;
        arrayDeque.addAll(arrayList);
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = null;
        this.i = 0;
        this.j = false;
        this.b = str;
    }
}
