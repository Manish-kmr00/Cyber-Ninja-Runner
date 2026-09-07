package com.yandex.mobile.ads.impl;

import android.net.Uri;
import android.util.Base64;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.io.IOException;
import java.net.URLDecoder;

/* JADX INFO: loaded from: classes5.dex */
public final class ov extends ik {
    private uv e;
    private byte[] f;
    private int g;
    private int h;

    public ov() {
        super(false);
    }

    @Override // com.yandex.mobile.ads.impl.qv
    public final long a(uv uvVar) throws IOException {
        b(uvVar);
        this.e = uvVar;
        Uri uri = uvVar.f10424a;
        String scheme = uri.getScheme();
        hg.a("Unsupported scheme: " + scheme, "data".equals(scheme));
        String schemeSpecificPart = uri.getSchemeSpecificPart();
        int i = x82.f10629a;
        String[] strArrSplit = schemeSpecificPart.split(StringUtils.COMMA, -1);
        if (strArrSplit.length == 2) {
            String str = strArrSplit[1];
            if (strArrSplit[0].contains(";base64")) {
                try {
                    this.f = Base64.decode(str, 0);
                } catch (IllegalArgumentException e) {
                    throw ag1.a("Error while parsing Base64 encoded string: " + str, e);
                }
            } else {
                this.f = x82.c(URLDecoder.decode(str, ko.f9439a.name()));
            }
            long j = uvVar.f;
            byte[] bArr = this.f;
            if (j <= bArr.length) {
                int i2 = (int) j;
                this.g = i2;
                int length = bArr.length - i2;
                this.h = length;
                long j2 = uvVar.g;
                if (j2 != -1) {
                    this.h = (int) Math.min(length, j2);
                }
                c(uvVar);
                long j3 = uvVar.g;
                return j3 != -1 ? j3 : this.h;
            }
            this.f = null;
            throw new rv(2008);
        }
        throw ag1.a("Unexpected URI format: " + uri, (IllegalArgumentException) null);
    }

    @Override // com.yandex.mobile.ads.impl.nv
    public final int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.h;
        if (i3 == 0) {
            return -1;
        }
        int iMin = Math.min(i2, i3);
        byte[] bArr2 = this.f;
        int i4 = x82.f10629a;
        System.arraycopy(bArr2, this.g, bArr, i, iMin);
        this.g += iMin;
        this.h -= iMin;
        c(iMin);
        return iMin;
    }

    @Override // com.yandex.mobile.ads.impl.qv
    public final Uri getUri() {
        uv uvVar = this.e;
        if (uvVar != null) {
            return uvVar.f10424a;
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.qv
    public final void close() {
        if (this.f != null) {
            this.f = null;
            e();
        }
        this.e = null;
    }
}
