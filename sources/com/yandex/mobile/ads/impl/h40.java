package com.yandex.mobile.ads.impl;

import android.media.DeniedByServerException;
import android.media.NotProvisionedException;

/* JADX INFO: loaded from: classes12.dex */
final class h40 {
    public static boolean b(Throwable th) {
        return th instanceof NotProvisionedException;
    }

    public static boolean a(Throwable th) {
        return th instanceof DeniedByServerException;
    }
}
