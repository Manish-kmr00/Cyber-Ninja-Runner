package com.yandex.mobile.ads.impl;

import android.net.Uri;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class on0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<String> f9837a = CollectionsKt.listOf((Object[]) new String[]{"adsdk.yandex.ru", "mobile.yandexadexchange.net"});

    public static boolean a(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return CollectionsKt.contains(f9837a, uri.getHost());
    }
}
