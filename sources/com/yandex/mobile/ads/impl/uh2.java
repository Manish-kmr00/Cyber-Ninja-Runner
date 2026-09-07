package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes11.dex */
public final class uh2 implements pq0 {
    private final boolean b;

    public uh2(boolean z) {
        this.b = z;
    }

    @Override // com.yandex.mobile.ads.impl.pq0
    public final String a() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        return z0.a(new Object[]{Boolean.valueOf(this.b)}, 1, "viewable: %s", "format(...)");
    }
}
