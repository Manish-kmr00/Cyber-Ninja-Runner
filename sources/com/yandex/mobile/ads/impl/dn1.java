package com.yandex.mobile.ads.impl;

import android.os.Bundle;

/* JADX INFO: loaded from: classes9.dex */
public abstract class dn1 implements jm {
    public static final jm.a<dn1> b = new jm.a() { // from class: com.yandex.mobile.ads.impl.dn1$$ExternalSyntheticLambda0
        @Override // com.yandex.mobile.ads.impl.jm.a
        public final jm fromBundle(Bundle bundle) {
            return dn1.a(bundle);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static dn1 a(Bundle bundle) {
        int i = bundle.getInt(Integer.toString(0, 36), -1);
        if (i == 0) {
            return (dn1) pf0.e.fromBundle(bundle);
        }
        if (i == 1) {
            return (dn1) og1.d.fromBundle(bundle);
        }
        if (i == 2) {
            return (dn1) g22.e.fromBundle(bundle);
        }
        if (i == 3) {
            return (dn1) s42.e.fromBundle(bundle);
        }
        throw new IllegalArgumentException(oe.a("Unknown RatingType: ", i));
    }

    dn1() {
    }
}
