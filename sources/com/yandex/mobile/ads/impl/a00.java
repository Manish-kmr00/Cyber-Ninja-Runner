package com.yandex.mobile.ads.impl;

import java.io.FileNotFoundException;

/* JADX INFO: loaded from: classes12.dex */
public final class a00 implements zr0 {
    @Override // com.yandex.mobile.ads.impl.zr0
    public final int a(int i) {
        return i == 7 ? 6 : 3;
    }

    public a00() {
        this(0);
    }

    public a00(int i) {
    }

    @Override // com.yandex.mobile.ads.impl.zr0
    public final long a(zr0.a aVar) {
        Throwable cause = aVar.f10847a;
        if (!(cause instanceof ag1) && !(cause instanceof FileNotFoundException) && !(cause instanceof nh0) && !(cause instanceof ds0.g)) {
            int i = rv.c;
            while (cause != null) {
                if (!(cause instanceof rv) || ((rv) cause).b != 2008) {
                    cause = cause.getCause();
                }
            }
            return Math.min((aVar.b - 1) * 1000, 5000);
        }
        return -9223372036854775807L;
    }
}
