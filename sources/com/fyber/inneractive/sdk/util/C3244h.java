package com.fyber.inneractive.sdk.util;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.util.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class C3244h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f2363a;

    public C3244h(String str) {
        Long lValueOf;
        try {
            lValueOf = Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException unused) {
            lValueOf = null;
        }
        this.f2363a = lValueOf;
    }
}
