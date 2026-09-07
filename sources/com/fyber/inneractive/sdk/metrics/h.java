package com.fyber.inneractive.sdk.metrics;

import java.util.UUID;

/* JADX INFO: loaded from: classes13.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1871a = UUID.randomUUID().toString();
    public final String b;

    public h(String str) {
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        return this.f1871a.equals(((h) obj).f1871a);
    }

    public final int hashCode() {
        return this.f1871a.hashCode();
    }
}
