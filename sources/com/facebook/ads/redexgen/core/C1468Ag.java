package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import com.facebook.ads.internal.protocol.AdErrorType;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ag, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1468Ag {
    public final AdErrorType A00;
    public final String A01;

    public C1468Ag(int i, String str) {
        this(AdErrorType.adErrorTypeFromCode(i), str);
    }

    public C1468Ag(AdErrorType adErrorType, String str) {
        str = TextUtils.isEmpty(str) ? adErrorType.getDefaultErrorMessage() : str;
        this.A00 = adErrorType;
        this.A01 = str;
    }

    public static C1468Ag A00(AdErrorType adErrorType) {
        return new C1468Ag(adErrorType, (String) null);
    }

    public static C1468Ag A01(AdErrorType adErrorType, String str) {
        return new C1468Ag(adErrorType, str);
    }

    public static C1468Ag A02(C1469Ah c1469Ah) {
        return new C1468Ag(c1469Ah.A00(), c1469Ah.A01());
    }

    public final AdErrorType A03() {
        return this.A00;
    }

    public final String A04() {
        return this.A01;
    }
}
