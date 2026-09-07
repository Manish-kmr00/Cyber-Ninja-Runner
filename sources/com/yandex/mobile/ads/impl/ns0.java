package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class ns0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<String, ls0> f9751a = new ConcurrentHashMap<>();
    public static final /* synthetic */ int b = 0;

    @JvmStatic
    public static final ls0 a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return a(context, "YadPreferenceFile");
    }

    @JvmStatic
    public static final ls0 a(Context context, String filename) {
        ls0 ls0VarPutIfAbsent;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(filename, "filename");
        ConcurrentHashMap<String, ls0> concurrentHashMap = f9751a;
        ls0 ms0Var = concurrentHashMap.get(filename);
        if (ms0Var == null && (ls0VarPutIfAbsent = concurrentHashMap.putIfAbsent(filename, (ms0Var = new ms0(context, filename, new ux1())))) != null) {
            ms0Var = ls0VarPutIfAbsent;
        }
        Intrinsics.checkNotNullExpressionValue(ms0Var, "getOrPut(...)");
        return ms0Var;
    }
}
