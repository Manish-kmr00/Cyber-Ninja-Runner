package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes8.dex */
public abstract class U3 {
    public static final boolean a(String str) {
        return str == null || StringsKt.trim((CharSequence) str).toString().length() == 0 || !(StringsKt.startsWith$default(str, com.safedk.android.analytics.brandsafety.creatives.discoveries.d.v, false, 2, (Object) null) || StringsKt.startsWith$default(str, "https://", false, 2, (Object) null));
    }

    public static final void a(Thread thread, String name) {
        Intrinsics.checkNotNullParameter(thread, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        try {
            thread.start();
        } catch (InternalError e) {
            e.toString();
        }
    }
}
