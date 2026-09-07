package com.yandex.mobile.ads.impl;

import java.util.UUID;

/* JADX INFO: loaded from: classes7.dex */
public final class oc0 implements cv {
    public static final boolean d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UUID f9807a;
    public final byte[] b;
    public final boolean c;

    /* JADX WARN: Code duplicated, block: B:9:0x001e  */
    static {
        boolean z;
        if ("Amazon".equals(x82.c)) {
            String str = x82.d;
            if ("AFTM".equals(str) || "AFTB".equals(str)) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        d = z;
    }

    public oc0(UUID uuid, byte[] bArr, boolean z) {
        this.f9807a = uuid;
        this.b = bArr;
        this.c = z;
    }
}
