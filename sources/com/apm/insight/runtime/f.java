package com.apm.insight.runtime;

import com.apm.insight.nativecrash.NativeImpl;
import java.util.Comparator;

/* JADX INFO: compiled from: CpuInfo.java */
/* JADX INFO: loaded from: classes4.dex */
public final class f {
    public static long a(int i) {
        return NativeImpl.c(i) * o.a.a();
    }

    static {
        new Comparator<Object>() { // from class: com.apm.insight.runtime.f.1
            @Override // java.util.Comparator
            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                return 0;
            }
        };
    }
}
