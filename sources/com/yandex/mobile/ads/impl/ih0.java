package com.yandex.mobile.ads.impl;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;

/* JADX INFO: loaded from: classes10.dex */
public final class ih0 extends a42 {
    final /* synthetic */ eh0 e;
    final /* synthetic */ int f;
    final /* synthetic */ Buffer g;
    final /* synthetic */ int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ih0(String str, eh0 eh0Var, int i, Buffer buffer, int i2, boolean z) {
        super(str, true);
        this.e = eh0Var;
        this.f = i;
        this.g = buffer;
        this.h = i2;
    }

    @Override // com.yandex.mobile.ads.impl.a42
    public final long e() {
        try {
            ym1 ym1Var = this.e.l;
            Buffer source = this.g;
            int i = this.h;
            ((xm1) ym1Var).getClass();
            Intrinsics.checkNotNullParameter(source, "source");
            source.skip(i);
            this.e.k().a(this.f, q50.i);
            synchronized (this.e) {
                this.e.B.remove(Integer.valueOf(this.f));
            }
            return -1L;
        } catch (IOException unused) {
            return -1L;
        }
    }
}
