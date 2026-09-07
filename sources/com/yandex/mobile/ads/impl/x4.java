package com.yandex.mobile.ads.impl;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class x4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f10621a = "yandex_ad_info";

    public static String a(mb2 videoAdExtensions) {
        Object next;
        Intrinsics.checkNotNullParameter(videoAdExtensions, "videoAdExtensions");
        Iterator<T> it = videoAdExtensions.a().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((r70) next).a(), f10621a));
        r70 r70Var = (r70) next;
        if (r70Var != null) {
            return r70Var.b();
        }
        return null;
    }
}
