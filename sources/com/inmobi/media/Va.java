package com.inmobi.media;

import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class Va {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public P8 f3220a;
    public Map b;
    public byte[] c;
    public Integer d;
    public int e;

    public final String toString() {
        return "STATUS_CODE:" + this.d + " | ERROR:" + this.f3220a + " | HEADERS:" + this.b + " | RESPONSE: " + Q8.a(this.c);
    }
}
