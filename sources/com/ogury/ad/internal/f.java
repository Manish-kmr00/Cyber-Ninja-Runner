package com.ogury.ad.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class f extends y3 {
    public final c b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(c ad, String url, String str, String str2) {
        super("ad_history");
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter("format", "source");
        this.b = ad;
        this.c = url;
        this.d = "format";
        this.e = str;
        this.f = str2;
    }
}
