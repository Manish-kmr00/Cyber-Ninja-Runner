package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class cr implements ou0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ou0.a f8633a;
    private final ou0[] b;

    public cr(ou0... measureSpecProviders) {
        Intrinsics.checkNotNullParameter(measureSpecProviders, "measureSpecProviders");
        this.f8633a = new ou0.a();
        this.b = measureSpecProviders;
    }

    @Override // com.yandex.mobile.ads.impl.ou0
    public final ou0.a a(int i, int i2) {
        ou0[] ou0VarArr = this.b;
        int length = ou0VarArr.length;
        int i3 = 0;
        while (i3 < length) {
            ou0.a aVarA = ou0VarArr[i3].a(i, i2);
            int i4 = aVarA.f9859a;
            i3++;
            i2 = aVarA.b;
            i = i4;
        }
        ou0.a aVar = this.f8633a;
        aVar.f9859a = i;
        aVar.b = i2;
        return aVar;
    }
}
