package io.bidmachine.media3.common.util;

import android.os.Trace;

/* JADX INFO: loaded from: classes11.dex */
public final class TraceUtil {
    private TraceUtil() {
    }

    public static void beginSection(String str) {
        Trace.beginSection(str);
    }

    public static void endSection() {
        Trace.endSection();
    }
}
