package com.yandex.mobile.ads.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class zh0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10817a;
    private final List<hf0> b;
    private final int c;
    private final InputStream d;
    private final byte[] e;

    public zh0(int i, ArrayList arrayList, int i2, InputStream inputStream) {
        this.f10817a = i;
        this.b = arrayList;
        this.c = i2;
        this.d = inputStream;
        this.e = null;
    }

    public zh0(int i, ArrayList arrayList, byte[] bArr) {
        this.f10817a = i;
        this.b = arrayList;
        this.c = bArr.length;
        this.e = bArr;
        this.d = null;
    }

    public final int d() {
        return this.f10817a;
    }

    public final List<hf0> c() {
        return Collections.unmodifiableList(this.b);
    }

    public final int b() {
        return this.c;
    }

    public final InputStream a() {
        InputStream inputStream = this.d;
        if (inputStream != null) {
            return inputStream;
        }
        if (this.e != null) {
            return new ByteArrayInputStream(this.e);
        }
        return null;
    }
}
