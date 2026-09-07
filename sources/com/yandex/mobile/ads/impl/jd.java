package com.yandex.mobile.ads.impl;

import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes2.dex */
public final class jd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile hd f9306a;

    @JvmStatic
    public static final le a() {
        hd hdVar;
        hd hdVar2 = f9306a;
        if (hdVar2 != null) {
            return hdVar2;
        }
        synchronized (hd.b) {
            hdVar = f9306a;
            if (hdVar == null) {
                int i = is0.f;
                hdVar = new hd(is0.a.a().c());
                f9306a = hdVar;
            }
        }
        return hdVar;
    }
}
