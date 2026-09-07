package com.yandex.mobile.ads.impl;

import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes9.dex */
public final class x22 extends np1<String> {
    private final Object s;
    private qq1.b<String> t;

    public x22(String str, qq1.b bVar, qq1.a aVar) {
        super(0, str, aVar);
        this.s = new Object();
        this.t = bVar;
    }

    @Override // com.yandex.mobile.ads.impl.np1
    public final void a() {
        super.a();
        synchronized (this.s) {
            this.t = null;
        }
    }

    @Override // com.yandex.mobile.ads.impl.np1
    protected final void a(String str) {
        qq1.b<String> bVar;
        String str2 = str;
        synchronized (this.s) {
            bVar = this.t;
        }
        if (bVar != null) {
            bVar.a(str2);
        }
    }

    @Override // com.yandex.mobile.ads.impl.np1
    protected final qq1<String> a(tc1 tc1Var) {
        String str;
        try {
            str = new String(tc1Var.b, th0.a(tc1Var.c));
        } catch (UnsupportedEncodingException unused) {
            str = new String(tc1Var.b);
        }
        return qq1.a(str, th0.a(tc1Var));
    }
}
