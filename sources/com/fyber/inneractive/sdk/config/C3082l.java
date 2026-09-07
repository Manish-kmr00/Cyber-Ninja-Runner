package com.fyber.inneractive.sdk.config;

import java.util.HashMap;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.config.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class C3082l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f1711a = new HashMap();

    public final boolean a() {
        try {
            if (this.f1711a.containsKey("dsos")) {
                return Boolean.parseBoolean((String) this.f1711a.get("dsos"));
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}
