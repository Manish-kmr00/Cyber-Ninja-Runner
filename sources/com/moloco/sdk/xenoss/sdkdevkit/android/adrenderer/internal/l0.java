package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l0 f6576a = new l0();
    public static final Map<Integer, d> b = new LinkedHashMap();
    public static final int c = 8;

    public final void b(int i) {
        b.remove(Integer.valueOf(i));
    }

    public final int a(d wv) {
        Intrinsics.checkNotNullParameter(wv, "wv");
        int iHashCode = wv.hashCode();
        b.put(Integer.valueOf(iHashCode), wv);
        return iHashCode;
    }

    public final /* synthetic */ <T> T a(int i) {
        T t = (T) b.get(Integer.valueOf(i));
        Intrinsics.reifiedOperationMarker(2, "T");
        return t;
    }
}
