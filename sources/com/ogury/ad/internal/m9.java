package com.ogury.ad.internal;

import java.net.URLDecoder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class m9 {
    public static final String a(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (Exception unused) {
            return "";
        }
    }
}
