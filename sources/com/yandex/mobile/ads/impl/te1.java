package com.yandex.mobile.ads.impl;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.net.MalformedURLException;
import java.net.URL;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class te1 {
    public static wa2 a(oa2 verification) throws IllegalArgumentException, pa2 {
        Intrinsics.checkNotNullParameter(verification, "verification");
        kq0 kq0VarB = verification.b();
        if (kq0VarB == null || !Intrinsics.areEqual(kq0VarB.c(), CampaignEx.KEY_OMID)) {
            throw new pa2(verification, pa2.a.c);
        }
        try {
            URL url = new URL(kq0VarB.d());
            String strD = verification.d();
            String strC = verification.c();
            if (strC == null || strC.length() == 0) {
                wa2 wa2VarA = wa2.a(url);
                Intrinsics.checkNotNull(wa2VarA);
                return wa2VarA;
            }
            wa2 wa2VarA2 = wa2.a(strD, url, strC);
            Intrinsics.checkNotNull(wa2VarA2);
            return wa2VarA2;
        } catch (MalformedURLException unused) {
            throw new pa2(verification, pa2.a.d);
        }
    }
}
