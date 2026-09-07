package com.yandex.mobile.ads.impl;

import android.net.Uri;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public interface a80 {
    static {
        new a80() { // from class: com.yandex.mobile.ads.impl.a80$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.a80
            public final w70[] a() {
                return a80.lambda$static$0();
            }
        };
    }

    w70[] a();

    static /* synthetic */ w70[] lambda$static$0() {
        return new w70[0];
    }

    default w70[] a(Uri uri, Map<String, List<String>> map) {
        return a();
    }
}
