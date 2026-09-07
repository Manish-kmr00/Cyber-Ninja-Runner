package com.fyber.inneractive.sdk.model.vast;

import android.text.TextUtils;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.model.vast.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes12.dex */
public final class C3117a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1873a;
    public final String b;
    public final String c;
    public final boolean d;

    public C3117a(String str, String str2, String str3) {
        String strTrim = str != null ? str.trim() : null;
        this.f1873a = strTrim;
        String strTrim2 = str2 != null ? str2.trim() : null;
        this.b = strTrim2;
        String strTrim3 = str3 != null ? str3.trim() : null;
        this.c = strTrim3;
        this.d = (TextUtils.isEmpty(strTrim) || TextUtils.isEmpty(strTrim2) || TextUtils.isEmpty(strTrim3) || !strTrim3.contains("[TIME]")) ? false : true;
    }
}
