package com.yandex.mobile.ads.impl;

import android.view.View;

/* JADX INFO: loaded from: classes10.dex */
public final class b50 implements ou0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ou0.a f8475a = new ou0.a();

    @Override // com.yandex.mobile.ads.impl.ou0
    public final ou0.a a(int i, int i2) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        ou0.a aVar = this.f8475a;
        aVar.f9859a = iMakeMeasureSpec;
        aVar.b = iMakeMeasureSpec;
        return aVar;
    }
}
