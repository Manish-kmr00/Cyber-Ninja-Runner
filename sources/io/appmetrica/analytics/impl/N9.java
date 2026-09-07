package io.appmetrica.analytics.impl;

import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes5.dex */
public abstract class N9 {
    public static final H9 a(int i, String str) {
        byte[] bytes;
        H9 h9 = new H9();
        h9.f11174a = i;
        if (str == null || (bytes = str.getBytes(Charsets.UTF_8)) == null) {
            bytes = h9.b;
        }
        h9.b = bytes;
        return h9;
    }
}
