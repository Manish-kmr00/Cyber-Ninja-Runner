package com.yandex.mobile.ads.impl;

import android.os.Bundle;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class km {
    public static hk0 a(jm.a aVar, ArrayList arrayList) {
        int i = hk0.d;
        hk0.a aVar2 = new hk0.a();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            Bundle bundle = (Bundle) arrayList.get(i2);
            bundle.getClass();
            aVar2.b(aVar.fromBundle(bundle));
        }
        return aVar2.a();
    }

    private km() {
    }
}
