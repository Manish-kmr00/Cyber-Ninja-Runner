package com.ogury.ad.internal;

import android.content.Intent;

/* JADX INFO: loaded from: classes13.dex */
public final class s2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s2 f7398a = new s2();

    public static Intent a(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return Intent.parseUri(str, 0);
    }
}
