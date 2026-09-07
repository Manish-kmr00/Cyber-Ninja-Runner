package com.yandex.mobile.ads.impl;

import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class me {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final pe f9629a;

    public me(TextView textView, pe appCompatTextViewAutoSizeHelper) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(appCompatTextViewAutoSizeHelper, "appCompatTextViewAutoSizeHelper");
        this.f9629a = appCompatTextViewAutoSizeHelper;
    }

    public final void a() {
        this.f9629a.a();
    }

    public final void b() {
        this.f9629a.a();
    }

    public final void a(int i) {
        this.f9629a.a(i);
    }

    public final void a(int i, float f) {
        if (this.f9629a.b()) {
            return;
        }
        this.f9629a.a(i, f);
    }
}
