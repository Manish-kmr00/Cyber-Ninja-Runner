package io.appmetrica.analytics.impl;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class P7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f11292a;
    public final String b;
    public final String c;

    public P7(String str, HashMap map, String str2) {
        this.b = str;
        this.f11292a = map;
        this.c = str2;
    }

    public final String toString() {
        return "DeferredDeeplinkState{mParameters=" + this.f11292a + ", mDeeplink='" + this.b + "', mUnparsedReferrer='" + this.c + "'}";
    }
}
