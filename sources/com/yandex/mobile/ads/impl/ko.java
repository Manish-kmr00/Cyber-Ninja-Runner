package com.yandex.mobile.ads.impl;

import com.google.android.exoplayer2.C;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public final class ko {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f9439a = Charset.forName("US-ASCII");
    public static final Charset b = Charset.forName(C.ISO88591_NAME);
    public static final Charset c = Charset.forName("UTF-8");
    public static final Charset d;
    public static final Charset e;

    static {
        Charset.forName("UTF-16BE");
        d = Charset.forName(C.UTF16LE_NAME);
        e = Charset.forName("UTF-16");
    }
}
