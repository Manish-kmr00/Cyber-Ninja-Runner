package com.yandex.mobile.ads.impl;

import android.app.Dialog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class zp implements cq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Dialog f10842a;
    private final wr b;

    public zp(Dialog dialog, wr contentCloseListener) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Intrinsics.checkNotNullParameter(contentCloseListener, "contentCloseListener");
        this.f10842a = dialog;
        this.b = contentCloseListener;
    }

    @Override // com.yandex.mobile.ads.impl.cq
    public final void a() {
        k10.a(this.f10842a);
        this.b.f();
    }

    @Override // com.yandex.mobile.ads.impl.cq
    public final void b() {
        k10.a(this.f10842a);
    }
}
