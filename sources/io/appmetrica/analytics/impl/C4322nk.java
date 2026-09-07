package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.Map;
import kotlin.collections.MapsKt;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.nk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4322nk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4421rk f11689a;
    public final Map b;

    public C4322nk(Context context, C4108f5 c4108f5) {
        c4108f5.a();
        C4421rk c4421rk = new C4421rk(context, c4108f5);
        this.f11689a = c4421rk;
        this.b = MapsKt.toMutableMap(c4421rk.a());
    }
}
