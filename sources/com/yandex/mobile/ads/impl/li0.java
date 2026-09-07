package com.yandex.mobile.ads.impl;

import android.net.Uri;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
final class li0 implements qv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final qv f9522a;
    private final int b;
    private final a c;
    private final byte[] d;
    private int e;

    public interface a {
    }

    @Override // com.yandex.mobile.ads.impl.qv
    public final void close() {
        throw new UnsupportedOperationException();
    }

    public li0(l22 l22Var, int i, a aVar) {
        hg.a(i > 0);
        this.f9522a = l22Var;
        this.b = i;
        this.c = aVar;
        this.d = new byte[1];
        this.e = i;
    }

    @Override // com.yandex.mobile.ads.impl.qv
    public final void a(w62 w62Var) {
        w62Var.getClass();
        this.f9522a.a(w62Var);
    }

    @Override // com.yandex.mobile.ads.impl.qv
    public final long a(uv uvVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.yandex.mobile.ads.impl.nv
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.e == 0) {
            int i3 = 0;
            if (this.f9522a.read(this.d, 0, 1) != -1) {
                int i4 = (this.d[0] & 255) << 4;
                if (i4 != 0) {
                    byte[] bArr2 = new byte[i4];
                    int i5 = i4;
                    while (i5 > 0) {
                        int i6 = this.f9522a.read(bArr2, i3, i5);
                        if (i6 != -1) {
                            i3 += i6;
                            i5 -= i6;
                        }
                    }
                    while (i4 > 0 && bArr2[i4 - 1] == 0) {
                        i4--;
                    }
                    if (i4 > 0) {
                        ((am1.a) this.c).a(new wf1(i4, bArr2));
                    }
                }
                this.e = this.b;
            }
            return -1;
        }
        int i7 = this.f9522a.read(bArr, i, Math.min(this.e, i2));
        if (i7 != -1) {
            this.e -= i7;
        }
        return i7;
    }

    @Override // com.yandex.mobile.ads.impl.qv
    public final Uri getUri() {
        return this.f9522a.getUri();
    }

    @Override // com.yandex.mobile.ads.impl.qv
    public final Map<String, List<String>> getResponseHeaders() {
        return this.f9522a.getResponseHeaders();
    }
}
