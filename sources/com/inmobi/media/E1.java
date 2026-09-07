package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class E1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3054a;
    public long b;
    public int c;
    public String d;

    public E1(String eventType, String str) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        this.f3054a = eventType;
        this.d = str;
        this.b = System.currentTimeMillis();
    }

    public final String a() {
        String str = this.d;
        return str == null ? "" : str;
    }
}
