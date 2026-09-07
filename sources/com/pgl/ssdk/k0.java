package com.pgl.ssdk;

import android.content.Context;
import com.vungle.ads.internal.protos.Sdk;

/* JADX INFO: loaded from: classes8.dex */
public class k0 extends m0 {
    private Context p;

    public k0(Context context, String str) {
        super(context, str);
        this.p = context;
        this.f7522a = l0.a() + b();
    }

    @Override // com.pgl.ssdk.m0
    public boolean a(int i, byte[] bArr) {
        if (i == 200 && bArr != null) {
            try {
                if (bArr.length > 0) {
                    if (((Integer) com.pgl.ssdk.ces.a.meta(Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, null, bArr)).intValue() == 0) {
                        com.pgl.ssdk.ces.b.f7505a = true;
                    } else {
                        com.pgl.ssdk.ces.b.f7505a = false;
                    }
                }
            } catch (Throwable unused) {
                com.pgl.ssdk.ces.b.f7505a = false;
            }
        }
        return true;
    }

    public String b() {
        return ((("?os=0&ver=6.5.0.0.overseas-rc.1&mode=1&app_ver=" + String.valueOf(z.g(this.p))) + "&region=" + b0.a()) + "&did=" + com.pgl.ssdk.ces.b.e()) + "&aid=" + com.pgl.ssdk.ces.b.d();
    }
}
