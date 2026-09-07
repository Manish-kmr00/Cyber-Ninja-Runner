package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import java.nio.charset.Charset;
import java.util.Map;
import kotlin.text.Charsets;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.xe, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C4565xe implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4084e6[] fromModel(Map<String, String> map) {
        int size = map.size();
        C4084e6[] c4084e6Arr = new C4084e6[size];
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            c4084e6Arr[i2] = new C4084e6();
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            C4084e6 c4084e6 = c4084e6Arr[i];
            String key = entry.getKey();
            Charset charset = Charsets.UTF_8;
            c4084e6.f11528a = key.getBytes(charset);
            c4084e6Arr[i].b = entry.getValue().getBytes(charset);
            i++;
        }
        return c4084e6Arr;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final Map<String, String> a(C4084e6[] c4084e6Arr) {
        throw new UnsupportedOperationException();
    }
}
