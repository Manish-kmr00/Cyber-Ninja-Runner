package com.iab.omid.library.amazon.utils;

import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: classes8.dex */
public final class d {
    public static void a(String str) {
        if (!com.iab.omid.library.amazon.a.f2441a.booleanValue() || TextUtils.isEmpty(str)) {
            return;
        }
        Log.i("OMIDLIB", str);
    }

    public static void a(String str, Exception exc) {
        if ((!com.iab.omid.library.amazon.a.f2441a.booleanValue() || TextUtils.isEmpty(str)) && exc == null) {
            return;
        }
        Log.e("OMIDLIB", str, exc);
    }

    public static void b(String str) {
        if (!com.iab.omid.library.amazon.a.f2441a.booleanValue() || TextUtils.isEmpty(str)) {
            return;
        }
        Log.w("OMIDLIB", str);
    }
}
