package com.yandex.mobile.ads.impl;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class qh2 {

    public interface a {
        boolean b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return ((a) view).b() && view.hasWindowFocus() && !oh2.d(view);
    }
}
