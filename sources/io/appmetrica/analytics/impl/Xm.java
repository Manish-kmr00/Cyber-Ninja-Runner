package io.appmetrica.analytics.impl;

import android.os.Looper;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class Xm implements Zm {
    @Override // io.appmetrica.analytics.impl.Zm
    public final Thread a() {
        return Looper.getMainLooper().getThread();
    }

    @Override // io.appmetrica.analytics.impl.Zm
    public final StackTraceElement[] b() {
        return null;
    }

    @Override // io.appmetrica.analytics.impl.Zm
    public final Map c() {
        return Thread.getAllStackTraces();
    }
}
