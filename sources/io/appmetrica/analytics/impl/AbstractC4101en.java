package io.appmetrica.analytics.impl;

import java.util.ArrayList;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.en, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractC4101en {
    /* JADX WARN: Code duplicated, block: B:16:0x0042  */
    public static C4076dn a(Throwable th, int i, int i2) {
        StackTraceElement[] stackTrace;
        C4076dn c4076dnA;
        ArrayList arrayList;
        String name = th.getClass().getName();
        String message = th.getMessage();
        try {
            stackTrace = th.getStackTrace();
        } catch (Throwable unused) {
            stackTrace = new StackTraceElement[0];
        }
        ArrayList arrayList2 = new ArrayList(stackTrace.length);
        for (StackTraceElement stackTraceElement : stackTrace) {
            arrayList2.add(new C4124fl(stackTraceElement));
        }
        Throwable cause = th.getCause();
        if (cause == null) {
            c4076dnA = null;
        } else {
            if (i2 >= i) {
                cause = null;
            }
            if (cause != null) {
                c4076dnA = a(cause, 30, i2 + 1);
            } else {
                c4076dnA = null;
            }
        }
        if (i2 < i) {
            Throwable[] suppressed = th.getSuppressed();
            arrayList = new ArrayList(suppressed.length);
            for (Throwable th2 : suppressed) {
                arrayList.add(a(th2, 1, i2));
            }
        } else {
            arrayList = null;
        }
        return new C4076dn(name, message, arrayList2, c4076dnA, arrayList);
    }
}
