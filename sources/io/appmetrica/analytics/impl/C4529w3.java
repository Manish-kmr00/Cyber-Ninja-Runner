package io.appmetrica.analytics.impl;

import android.util.Base64;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.w3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4529w3 implements Qn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final L8 f11825a;

    public C4529w3() {
        this(new L8());
    }

    @Override // io.appmetrica.analytics.impl.Qn
    public final byte[] a(R8 r8, C4045ch c4045ch) {
        byte[] bArrDecode = new byte[0];
        String str = r8.b;
        if (str != null) {
            try {
                bArrDecode = Base64.decode(str, 0);
            } catch (Throwable unused) {
            }
        }
        L8 l8 = this.f11825a;
        return ((K8) l8.f11240a.a(r8.o)).a(bArrDecode);
    }

    public C4529w3(L8 l8) {
        this.f11825a = l8;
    }
}
