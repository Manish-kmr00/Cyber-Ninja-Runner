package com.yandex.mobile.ads.impl;

import java.net.InetAddress;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class fg0 {
    private static final ConcurrentHashMap<String, Boolean> b = new ConcurrentHashMap<>();
    public static final /* synthetic */ int c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, Boolean> f8891a = b;

    public final boolean a(int i, String host) {
        Object objM7904constructorimpl;
        Intrinsics.checkNotNullParameter(host, "host");
        ConcurrentHashMap<String, Boolean> concurrentHashMap = this.f8891a;
        Boolean boolValueOf = concurrentHashMap.get(host);
        if (boolValueOf == null) {
            o82.f9793a.getClass();
            Intrinsics.checkNotNullParameter(host, "host");
            try {
                Result.Companion companion = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(Boolean.valueOf(InetAddress.getByName(host).isReachable(i)));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m7910isFailureimpl(objM7904constructorimpl)) {
                objM7904constructorimpl = null;
            }
            Boolean bool = (Boolean) objM7904constructorimpl;
            boolValueOf = Boolean.valueOf(bool != null ? bool.booleanValue() : false);
            Boolean boolPutIfAbsent = concurrentHashMap.putIfAbsent(host, boolValueOf);
            if (boolPutIfAbsent != null) {
                boolValueOf = boolPutIfAbsent;
            }
        }
        Intrinsics.checkNotNullExpressionValue(boolValueOf, "getOrPut(...)");
        return boolValueOf.booleanValue();
    }
}
