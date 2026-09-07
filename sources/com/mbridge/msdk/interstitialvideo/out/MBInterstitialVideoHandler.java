package com.mbridge.msdk.interstitialvideo.out;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.report.metrics.d;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.newreward.function.common.MBridgeGlobalCommon;
import com.mbridge.msdk.reward.controller.a;
import com.mbridge.msdk.setting.h;

/* JADX INFO: loaded from: classes13.dex */
@Deprecated
public class MBInterstitialVideoHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5126a;
    private a b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private InterstitialVideoListener h;
    private int i = 2;
    private boolean j = false;
    private boolean k = false;
    private boolean l = false;
    private int m;
    private int n;
    private int o;

    public MBInterstitialVideoHandler(Context context, String str, String str2) {
        if (c.m().d() == null && context != null) {
            c.m().b(context);
        }
        a(str, str2);
    }

    private void a(String str, String str2) {
        String strE = t0.e(str2);
        if (!TextUtils.isEmpty(strE)) {
            t0.b(str2, strE);
        }
        this.c = str2;
        this.f5126a = str;
        a();
    }

    private void b(String str, String str2) {
        try {
            if (this.b == null) {
                a aVar = new a();
                this.b = aVar;
                aVar.d(true);
                this.b.c(str, str2);
                h.b().g(str2);
            }
        } catch (Throwable th) {
            o0.b("MBRewardVideoHandler", th.getMessage(), th);
        }
    }

    public void clearVideoCache() {
        try {
            a aVar = this.b;
            if (aVar != null) {
                aVar.e();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getCreativeIdWithUnitId() {
        a aVar = this.b;
        return aVar != null ? aVar.j() : "";
    }

    public String getRequestId() {
        a aVar = this.b;
        return aVar != null ? aVar.m() : "";
    }

    public boolean isReady() {
        a();
        a aVar = this.b;
        if (aVar != null) {
            return aVar.c(true);
        }
        return false;
    }

    public void load() {
        a();
        if (this.b != null) {
            this.b.a(true, d.b().a(0, 287, this.c, true, 2));
        }
    }

    public void loadFormSelfFilling() {
        a();
        if (this.b != null) {
            this.b.a(false, d.b().a(0, 287, this.c, true, 1));
        }
    }

    public void playVideoMute(int i) {
        this.i = i;
        a aVar = this.b;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    public void setAlertDialogText(String str, String str2, String str3, String str4) {
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = str4;
        this.k = true;
        MBridgeGlobalCommon.setAlertDialogText(this.c, str, str2, str3, str4);
    }

    public void setIVRewardEnable(int i, int i2) {
        this.m = i;
        this.n = i2;
        this.o = com.mbridge.msdk.foundation.same.a.K;
        this.l = true;
        b();
    }

    public void setInterstitialVideoListener(InterstitialVideoListener interstitialVideoListener) {
        this.h = interstitialVideoListener;
        this.j = true;
        a aVar = this.b;
        if (aVar == null || aVar.u()) {
            return;
        }
        this.b.a(new com.mbridge.msdk.interstitialvideo.listener.a(interstitialVideoListener));
        this.j = false;
    }

    @Deprecated
    public void setRewardVideoListener(InterstitialVideoListener interstitialVideoListener) {
        this.h = interstitialVideoListener;
        this.j = true;
        a aVar = this.b;
        if (aVar == null || aVar.u()) {
            return;
        }
        this.b.a(new com.mbridge.msdk.interstitialvideo.listener.a(interstitialVideoListener));
        this.j = false;
    }

    public void show() {
        a();
        if (this.b != null) {
            this.b.a((String) null, (String) null, (String) null, d.b().a(0, 287, this.c, false, -1));
        }
    }

    public void setIVRewardEnable(int i, double d) {
        this.m = i;
        this.n = (int) (d * 100.0d);
        this.o = com.mbridge.msdk.foundation.same.a.J;
        this.l = true;
        b();
    }

    private void a() {
        a aVar;
        if (this.b == null) {
            b(this.f5126a, this.c);
        }
        if (this.j) {
            this.b.a(new com.mbridge.msdk.interstitialvideo.listener.a(this.h, this.c, false));
            this.j = false;
        }
        if (this.k) {
            this.b.a(this.d, this.e, this.f, this.g);
            this.k = false;
        }
        if (!this.l || (aVar = this.b) == null) {
            return;
        }
        aVar.a(this.m, this.o, this.n);
        this.l = false;
    }

    private void b() {
        a aVar = this.b;
        if (aVar != null) {
            aVar.a(this.m, this.o, this.n);
        }
    }

    public MBInterstitialVideoHandler(String str, String str2) {
        a(str, str2);
    }
}
