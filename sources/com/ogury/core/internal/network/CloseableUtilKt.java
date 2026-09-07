package com.ogury.core.internal.network;

import java.io.Closeable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CloseableUtil.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"closeSafely", "", "Ljava/io/Closeable;", "sdk-core_prodRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CloseableUtilKt {
    public static final void closeSafely(Closeable closeable) {
        Intrinsics.checkNotNullParameter(closeable, "<this>");
        try {
            closeable.close();
        } catch (Throwable unused) {
        }
    }
}
