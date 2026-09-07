package com.mbridge.msdk.foundation.entity;

import android.content.Context;
import android.os.Build;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.out.MBConfiguration;
import com.mbridge.msdk.system.NoProGuard;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.io.Serializable;

/* JADX INFO: loaded from: classes11.dex */
public class CampaignUnit extends b implements Serializable, NoProGuard {
    private static final String TAG = "CampaignUnit";

    @Override // com.mbridge.msdk.foundation.entity.b
    public String assembCParams() {
        String str;
        String strValueOf;
        StringBuffer stringBuffer = this.cParams;
        if (stringBuffer != null && stringBuffer.length() > 0) {
            return this.cParams.toString();
        }
        try {
            String strD = com.mbridge.msdk.foundation.tools.f.d();
            Context contextD = com.mbridge.msdk.foundation.controller.c.m().d();
            String strR = k0.r(contextD);
            String strQ = k0.q(contextD);
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                strValueOf = String.valueOf(k0.s(contextD));
                str = k0.n(contextD) + VastAttributes.HORIZONTAL_POSITION + k0.m(contextD);
            } else {
                str = "";
                strValueOf = str;
            }
            this.cParams = this.cParams.append(getAdType()).append(com.safedk.android.analytics.brandsafety.l.ad).append(nullToEmpty("1")).append(com.safedk.android.analytics.brandsafety.l.ad).append(nullToEmpty(Build.VERSION.RELEASE)).append(com.safedk.android.analytics.brandsafety.l.ad).append(nullToEmpty(MBConfiguration.SDK_VERSION)).append(com.safedk.android.analytics.brandsafety.l.ad).append(nullToEmpty(k0.n())).append(com.safedk.android.analytics.brandsafety.l.ad).append(nullToEmpty(str)).append(com.safedk.android.analytics.brandsafety.l.ad).append(nullToEmpty(Integer.valueOf(k0.F(com.mbridge.msdk.foundation.controller.c.m().d())))).append(com.safedk.android.analytics.brandsafety.l.ad).append(nullToEmpty(k0.p(com.mbridge.msdk.foundation.controller.c.m().d()))).append(com.safedk.android.analytics.brandsafety.l.ad).append(nullToEmpty(strValueOf)).append(com.safedk.android.analytics.brandsafety.l.ad).append(nullToEmpty(strQ)).append(nullToEmpty(strR)).append(com.safedk.android.analytics.brandsafety.l.ad).append(com.safedk.android.analytics.brandsafety.l.ad).append(com.safedk.android.analytics.brandsafety.l.ad).append(com.safedk.android.analytics.brandsafety.l.ad).append(nullToEmpty(strD)).append(com.safedk.android.analytics.brandsafety.l.ad).append(nullToEmpty("")).append(com.safedk.android.analytics.brandsafety.l.ad).append(nullToEmpty(k0.s())).append(com.safedk.android.analytics.brandsafety.l.ad).append(nullToEmpty("")).append(com.safedk.android.analytics.brandsafety.l.ad).append("").append(com.safedk.android.analytics.brandsafety.l.ad).append(nullToEmpty("")).append(com.safedk.android.analytics.brandsafety.l.ad).append(nullToEmpty(com.mbridge.msdk.foundation.same.a.V + StringUtils.COMMA + com.mbridge.msdk.foundation.same.a.g)).append(com.safedk.android.analytics.brandsafety.l.ad).append(k0.j()).append(com.safedk.android.analytics.brandsafety.l.ad);
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                o0.b(TAG, th.getMessage(), th);
            }
        }
        return this.cParams.toString();
    }
}
