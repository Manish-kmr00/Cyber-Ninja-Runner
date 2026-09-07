package com.mbridge.msdk.mbbid.out;

import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.k0;

/* JADX INFO: loaded from: classes10.dex */
public class SplashBidRequestParams extends BannerBidRequestParams {
    private static int g = 1;
    private static int h;
    private static int i;
    private boolean f;

    public SplashBidRequestParams(String str, String str2) {
        this(str, str2, "");
    }

    protected boolean a() {
        return this.f;
    }

    public int getOrientation() {
        return g;
    }

    public SplashBidRequestParams(String str, String str2, String str3) {
        this(str, str2, str3, false, g, i, h);
    }

    private void a(int i2, int i3) {
        int iN = k0.n(c.m().d());
        int iM = k0.m(c.m().d());
        int i4 = g;
        if (i4 == 1) {
            if (iM > i3 * 4) {
                setHeight(iM - i3);
                setWidth(iN);
                return;
            } else {
                setHeight(0);
                setWidth(0);
                return;
            }
        }
        if (i4 == 2) {
            if (iN > i2 * 4) {
                setWidth(iN - i2);
                setHeight(iM);
            } else {
                setHeight(0);
                setWidth(0);
            }
        }
    }

    public SplashBidRequestParams(String str, String str2, boolean z, int i2, int i3, int i4) {
        this(str, str2, "", z, i2, i4, i3);
    }

    public SplashBidRequestParams(String str, String str2, String str3, boolean z, int i2, int i3, int i4) {
        super(str, str2, str3, 0, 0);
        this.f = false;
        g = i2;
        a(i3, i4);
        this.f = z;
    }
}
