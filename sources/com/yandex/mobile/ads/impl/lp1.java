package com.yandex.mobile.ads.impl;

import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public interface lp1 {
    void a(hp1 hp1Var);

    void a(boolean z);

    void reportAnr(Map<Thread, StackTraceElement[]> map);

    void reportError(String str, Throwable th);

    void reportUnhandledException(Throwable th);
}
