package com.five_corp.ad.internal.http;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1392a;
    public final String b;
    public final byte[] c;

    public c(int i) {
        this.f1392a = i;
        this.b = null;
        this.c = null;
    }

    public final String a() {
        String str = this.b;
        if (str != null) {
            return str;
        }
        byte[] bArr = this.c;
        if (bArr != null) {
            return new String(bArr, StandardCharsets.UTF_8);
        }
        return null;
    }

    public c(int i, byte[] bArr) {
        this.f1392a = i;
        this.b = null;
        this.c = bArr;
    }

    public c(String str, int i) {
        this.f1392a = i;
        this.b = str;
        this.c = null;
    }
}
