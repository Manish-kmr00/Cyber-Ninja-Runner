package com.ogury.ad.internal;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class p4 {
    public static p4 b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f7383a;

    public p4(Context context) {
        this.f7383a = context.getSharedPreferences("ogury_mraid", 0);
    }

    public final void a(String mraidDownloadUrl) {
        Intrinsics.checkNotNullParameter(mraidDownloadUrl, "mraidDownloadUrl");
        this.f7383a.edit().putString("mraid_download_url", mraidDownloadUrl).apply();
    }

    public final void b(String mraidJs) {
        Intrinsics.checkNotNullParameter(mraidJs, "mraidJs");
        this.f7383a.edit().putString("mraid_js", mraidJs).commit();
    }
}
