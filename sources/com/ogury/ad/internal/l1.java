package com.ogury.ad.internal;

import android.net.NetworkInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class l1 {
    public static final boolean a(NetworkInfo networkInfo) {
        Intrinsics.checkNotNullParameter(networkInfo, "<this>");
        return networkInfo.isConnected() && networkInfo.getType() == 1;
    }
}
