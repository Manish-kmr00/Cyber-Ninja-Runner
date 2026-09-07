package com.yandex.mobile.ads.impl;

import android.net.Uri;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public final class l22 implements qv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final qv f9472a;
    private long b;
    private Uri c = Uri.EMPTY;

    @Override // com.yandex.mobile.ads.impl.qv
    public final void a(w62 w62Var) {
        w62Var.getClass();
        this.f9472a.a(w62Var);
    }

    public l22(qv qvVar) {
        this.f9472a = (qv) hg.a(qvVar);
        Collections.emptyMap();
    }

    public final long e() {
        return this.b;
    }

    public final Uri f() {
        return this.c;
    }

    @Override // com.yandex.mobile.ads.impl.qv
    public final long a(uv uvVar) throws IOException {
        this.c = uvVar.f10424a;
        Collections.emptyMap();
        long jA = this.f9472a.a(uvVar);
        Uri uri = this.f9472a.getUri();
        uri.getClass();
        this.c = uri;
        this.f9472a.getResponseHeaders();
        return jA;
    }

    @Override // com.yandex.mobile.ads.impl.nv
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.f9472a.read(bArr, i, i2);
        if (i3 != -1) {
            this.b += (long) i3;
        }
        return i3;
    }

    @Override // com.yandex.mobile.ads.impl.qv
    public final Uri getUri() {
        return this.f9472a.getUri();
    }

    @Override // com.yandex.mobile.ads.impl.qv
    public final Map<String, List<String>> getResponseHeaders() {
        return this.f9472a.getResponseHeaders();
    }

    @Override // com.yandex.mobile.ads.impl.qv
    public final void close() throws IOException {
        this.f9472a.close();
    }
}
