package io.appmetrica.analytics.impl;

import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.text.Charsets;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.pa, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4362pa implements U9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final N8 f11718a = new N8();

    public final C4187i9[] a(byte[] bArr) {
        int i = 0;
        if (bArr == null) {
            return new C4187i9[0];
        }
        Map<String, byte[]> model = this.f11718a.toModel(bArr);
        C4187i9[] c4187i9Arr = new C4187i9[model.size()];
        for (Object obj : model.entrySet()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Map.Entry entry = (Map.Entry) obj;
            C4187i9 c4187i9 = new C4187i9();
            c4187i9.f11599a = ((String) entry.getKey()).getBytes(Charsets.UTF_8);
            c4187i9.b = (byte[]) entry.getValue();
            c4187i9Arr[i] = c4187i9;
            i = i2;
        }
        return c4187i9Arr;
    }
}
