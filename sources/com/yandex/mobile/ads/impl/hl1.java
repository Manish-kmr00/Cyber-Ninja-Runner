package com.yandex.mobile.ads.impl;

import android.app.Application;
import android.os.Build;

/* JADX INFO: loaded from: classes12.dex */
public final class hl1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final w0 f9110a = new w0();

    public final String a() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Application.getProcessName();
        }
        this.f9110a.getClass();
        return w0.b();
    }
}
