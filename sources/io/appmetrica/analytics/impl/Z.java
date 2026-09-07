package io.appmetrica.analytics.impl;

import android.os.Looper;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class Z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f11442a;
    public final Thread b = Looper.getMainLooper().getThread();

    public Z(InterfaceC3978a0 interfaceC3978a0, Map map) {
        this.f11442a = map;
    }
}
