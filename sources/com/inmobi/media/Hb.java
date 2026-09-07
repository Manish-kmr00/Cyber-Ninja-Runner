package com.inmobi.media;

import android.net.ConnectivityManager;
import android.net.Network;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class Hb extends ConnectivityManager.NetworkCallback {
    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        ConcurrentHashMap concurrentHashMap = Ib.f3099a;
        Intrinsics.checkNotNullExpressionValue("Ib", "access$getTAG$p(...)");
        super.onAvailable(network);
        Intrinsics.checkNotNullExpressionValue("Ib", "access$getTAG$p(...)");
        C3517pb.f().b(new N1(10, "available", null, 4));
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        ConcurrentHashMap concurrentHashMap = Ib.f3099a;
        Intrinsics.checkNotNullExpressionValue("Ib", "access$getTAG$p(...)");
        super.onLost(network);
        C3517pb.f().b(new N1(10, "lost", null, 4));
    }
}
