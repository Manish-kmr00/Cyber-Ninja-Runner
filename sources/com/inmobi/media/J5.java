package com.inmobi.media;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public abstract class J5 {
    public static K5 a(Context context, String fileKey) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileKey, "fileKey");
        Intrinsics.checkNotNullParameter(fileKey, "fileKey");
        String str = "com.im.keyValueStore." + fileKey;
        K5 k5 = (K5) K5.b.get(str);
        if (k5 != null) {
            return k5;
        }
        K5 k6 = new K5(context, str);
        K5 k7 = (K5) K5.b.putIfAbsent(str, k6);
        return k7 != null ? k7 : k6;
    }
}
