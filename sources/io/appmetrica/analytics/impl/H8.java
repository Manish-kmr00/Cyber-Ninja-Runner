package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class H8 implements Qn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final L8 f11173a;

    public H8() {
        this(new L8());
    }

    @Override // io.appmetrica.analytics.impl.Qn
    public final byte[] a(R8 r8, C4045ch c4045ch) {
        String str = r8.b;
        return ((K8) this.f11173a.f11240a.a(r8.o)).a(str != null ? StringUtils.getUTF8Bytes(str) : new byte[0]);
    }

    public H8(L8 l8) {
        this.f11173a = l8;
    }
}
