package com.inmobi.media;

import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class T8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3203a;
    public byte[] b;
    public P8 c;
    public int d;
    public Map e;

    public final String a() {
        String str = this.f3203a;
        if (str != null) {
            return str;
        }
        String strA = Q8.a(this.b);
        this.f3203a = strA;
        return strA;
    }

    public final boolean b() {
        return this.c != null;
    }
}
