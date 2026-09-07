package com.yandex.mobile.ads.impl;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class h30 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n82 f9057a;

    public h30(hh1 tracker) {
        Intrinsics.checkNotNullParameter(tracker, "tracker");
        this.f9057a = tracker;
    }

    public final void a(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        String queryParameter = uri.getQueryParameter("trackingUrl");
        if (queryParameter == null || queryParameter.length() <= 0) {
            return;
        }
        this.f9057a.a(queryParameter);
    }
}
