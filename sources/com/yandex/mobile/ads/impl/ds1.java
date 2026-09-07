package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class ds1 implements wr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f8728a;
    private final bq b;
    private final wr c;
    private boolean d;

    public ds1(Context context, w20 closeVerificationDialogController, wr contentCloseListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(closeVerificationDialogController, "closeVerificationDialogController");
        Intrinsics.checkNotNullParameter(contentCloseListener, "contentCloseListener");
        this.f8728a = context;
        this.b = closeVerificationDialogController;
        this.c = contentCloseListener;
    }

    @Override // com.yandex.mobile.ads.impl.wr
    public final void f() {
        if (this.d) {
            this.c.f();
        } else {
            this.b.a(this.f8728a);
        }
    }

    public final void a() {
        this.d = true;
        this.b.a();
    }
}
