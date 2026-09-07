package com.yandex.mobile.ads.impl;

import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class h21 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f9054a = Pattern.compile("(<script)(.*)(src=\"mraid\\.js\")(.*)(<\\/script>)");

    public static boolean a(String htmlResponse) {
        Intrinsics.checkNotNullParameter(htmlResponse, "htmlResponse");
        return f9054a.matcher(htmlResponse).find();
    }
}
