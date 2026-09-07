package com.fyber.inneractive.sdk.network.timeouts.content;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.global.features.k;
import com.fyber.inneractive.sdk.config.global.r;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes13.dex */
public final class a extends com.fyber.inneractive.sdk.network.timeouts.a {
    public final int h;

    public a(String str, String str2, int i, boolean z, String str3, r rVar) {
        int iIntValue;
        k kVar = (k) rVar.a(k.class);
        this.h = 0;
        Boolean boolC = kVar.c("reverse_retries");
        this.g = boolC != null ? boolC.booleanValue() : true;
        if (z) {
            iIntValue = kVar.b(str, str3);
        } else if (TextUtils.isEmpty(str3)) {
            String str4 = str + "_global_timeout";
            int i2 = k.d(str) ? 30000 : 10000;
            Integer numA = kVar.a(str4);
            iIntValue = numA != null ? numA.intValue() : i2;
        } else {
            iIntValue = kVar.c(str, str3);
        }
        if (iIntValue > i) {
            if (TextUtils.isEmpty(str3)) {
                Integer numA2 = kVar.a(k.a(str, str2, "retry_interval"));
                this.e = numA2 != null ? numA2.intValue() : 100;
                Integer numA3 = kVar.a(k.a("timeout", "threshold"));
                this.f = numA3 != null ? numA3.intValue() : 300;
                String strA = k.a(str, str2, "ilat");
                int i3 = k.d(str) ? 20000 : 10000;
                Integer numA4 = kVar.a(strA);
                this.d = numA4 != null ? numA4.intValue() : i3;
            } else {
                String strA2 = k.a(str, str2, "retry_interval", k.e(str3));
                Integer numA5 = kVar.a(k.a("retry_interval", "all_mediators"));
                int iIntValue2 = numA5 != null ? numA5.intValue() : 100;
                Integer numA6 = kVar.a(strA2);
                this.e = numA6 != null ? numA6.intValue() : iIntValue2;
                String strA3 = k.a("timeout", "threshold", k.e(str3));
                Integer numA7 = kVar.a(k.a("timeout", "threshold", "all_mediators"));
                int iIntValue3 = numA7 != null ? numA7.intValue() : 300;
                Integer numA8 = kVar.a(strA3);
                this.f = numA8 != null ? numA8.intValue() : iIntValue3;
                String strA4 = k.a(str, str2, "ilat", k.e(str3));
                String strA5 = k.a(str, str2, "ilat", "all_mediators");
                int iIntValue4 = k.d(str) ? 20000 : 10000;
                Integer numA9 = kVar.a(strA5);
                iIntValue4 = numA9 != null ? numA9.intValue() : iIntValue4;
                Integer numA10 = kVar.a(strA4);
                this.d = numA10 != null ? numA10.intValue() : iIntValue4;
            }
        }
        int i4 = iIntValue - (this.f + i);
        IAlog.a("%s : LoadAdContentTimeout resolveLoadAdTimeout : usedTime: %d, global timeout: %d, timeout: %d", IAlog.a(a.class), Integer.valueOf(i), Integer.valueOf(iIntValue), Integer.valueOf(i4));
        this.c = Math.max(i4, 0);
        int iA = a();
        this.f1932a = iA;
        if (iA == 0) {
            this.d = this.c;
        }
        IAlog.a("%s : LoadAdContentTimeout onFixedLoadAdTimeoutUpdated : Calculated: %d attempts with LeftoverTime: %d", IAlog.a(this), Integer.valueOf(this.f1932a), 0);
        int i5 = this.f1932a;
        if (i5 > 0) {
            int i6 = this.c;
            int i7 = this.f;
            int i8 = this.e;
            for (int i9 = 0; i9 <= i5; i9++) {
                i6 -= (this.b * i9) + this.d;
            }
            this.h = Math.max(0, i6 - ((i8 * i5) + (i7 * i5)));
        }
    }
}
