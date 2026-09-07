package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import android.util.Base64;
import io.appmetrica.analytics.protobuf.nano.MessageNano;

/* JADX INFO: loaded from: classes13.dex */
public final class Af implements Qn {
    @Override // io.appmetrica.analytics.impl.Qn
    public final byte[] a(R8 r8, C4045ch c4045ch) {
        if (!TextUtils.isEmpty(r8.b)) {
            try {
                byte[] bArrDecode = Base64.decode(r8.b, 0);
                C4044cg c4044cg = (bArrDecode == null || bArrDecode.length == 0) ? null : new C4044cg(bArrDecode);
                If r4 = new If();
                String str = c4044cg.f11496a;
                r4.f11196a = str == null ? new byte[0] : str.getBytes();
                r4.c = c4044cg.b;
                r4.b = c4044cg.c;
                int iOrdinal = c4044cg.d.ordinal();
                int i = 1;
                if (iOrdinal != 1) {
                    i = 2;
                    if (iOrdinal != 2) {
                        i = 0;
                    }
                }
                r4.d = i;
                return MessageNano.toByteArray(r4);
            } catch (Throwable unused) {
            }
        }
        return new byte[0];
    }
}
