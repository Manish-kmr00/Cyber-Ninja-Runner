package com.yandex.mobile.ads.impl;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class gv implements jm {
    public static final /* synthetic */ int b = 0;

    static {
        new gv(hk0.h());
        new jm.a() { // from class: com.yandex.mobile.ads.impl.gv$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.jm.a
            public final jm fromBundle(Bundle bundle) {
                return gv.a(bundle);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final gv a(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(Integer.toString(0, 36));
        return new gv(parcelableArrayList == null ? hk0.h() : km.a(ev.t, parcelableArrayList));
    }

    public gv(List<ev> list) {
        hk0.a((Collection) list);
    }
}
