package com.yandex.mobile.ads.impl;

import java.io.IOException;

/* JADX INFO: loaded from: classes7.dex */
public final class fh0 extends a42 {
    final /* synthetic */ eh0 e;
    final /* synthetic */ lh0 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fh0(String str, eh0 eh0Var, lh0 lh0Var) {
        super(str, true);
        this.e = eh0Var;
        this.f = lh0Var;
    }

    @Override // com.yandex.mobile.ads.impl.a42
    public final long e() {
        try {
            this.e.e().a(this.f);
            return -1L;
        } catch (IOException e) {
            int i = nh1.c;
            nh1 nh1VarA = nh1.a.a();
            String str = "Http2Connection.Listener failure for " + this.e.c();
            nh1VarA.getClass();
            nh1.a(4, str, e);
            try {
                this.f.a(q50.e, e);
                return -1L;
            } catch (IOException unused) {
                return -1L;
            }
        }
    }
}
