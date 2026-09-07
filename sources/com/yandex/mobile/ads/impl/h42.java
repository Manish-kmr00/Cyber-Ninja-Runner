package com.yandex.mobile.ads.impl;

import android.net.Uri;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public final class h42 implements qv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final qv f9061a;
    private final pv b;
    private boolean c;
    private long d;

    public h42(qv qvVar, um umVar) {
        this.f9061a = (qv) hg.a(qvVar);
        this.b = (pv) hg.a(umVar);
    }

    @Override // com.yandex.mobile.ads.impl.qv
    public final void a(w62 w62Var) {
        w62Var.getClass();
        this.f9061a.a(w62Var);
    }

    @Override // com.yandex.mobile.ads.impl.qv
    public final long a(uv uvVar) throws IOException {
        long jA = this.f9061a.a(uvVar);
        this.d = jA;
        if (jA == 0) {
            return 0L;
        }
        if (uvVar.g == -1 && jA != -1) {
            uvVar = uvVar.a(jA);
        }
        this.c = true;
        this.b.a(uvVar);
        return this.d;
    }

    @Override // com.yandex.mobile.ads.impl.nv
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.d == 0) {
            return -1;
        }
        int i3 = this.f9061a.read(bArr, i, i2);
        if (i3 > 0) {
            this.b.write(bArr, i, i3);
            long j = this.d;
            if (j != -1) {
                this.d = j - ((long) i3);
            }
        }
        return i3;
    }

    @Override // com.yandex.mobile.ads.impl.qv
    public final Uri getUri() {
        return this.f9061a.getUri();
    }

    @Override // com.yandex.mobile.ads.impl.qv
    public final Map<String, List<String>> getResponseHeaders() {
        return this.f9061a.getResponseHeaders();
    }

    @Override // com.yandex.mobile.ads.impl.qv
    public final void close() throws IOException {
        try {
            this.f9061a.close();
        } finally {
            if (this.c) {
                this.c = false;
                this.b.close();
            }
        }
    }
}
