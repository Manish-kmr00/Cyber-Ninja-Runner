package com.yandex.mobile.ads.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class rh0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashMap f10107a = new HashMap();
    private Map<String, String> b;

    public final synchronized Map<String, String> a() {
        if (this.b == null) {
            this.b = Collections.unmodifiableMap(new HashMap(this.f10107a));
        }
        return this.b;
    }
}
