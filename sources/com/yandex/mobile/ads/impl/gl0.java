package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class gl0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9015a;

    public gl0(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f9015a = context;
    }

    public final File a() {
        File file = new File(this.f9015a.getCacheDir(), "debug_panel");
        file.mkdir();
        return new File(file, "monetization_ads_debug_panel_report.txt");
    }
}
