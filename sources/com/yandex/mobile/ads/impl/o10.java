package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class o10 {
    public static File a(Context context, String cacheDirName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cacheDirName, "cacheDirName");
        return new File(context.getCacheDir().getPath() + File.separator + cacheDirName);
    }
}
