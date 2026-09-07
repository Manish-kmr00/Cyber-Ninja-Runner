package com.mbridge.msdk.newinterstitial.out;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.report.metrics.d;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.newreward.function.common.MBridgeGlobalCommon;
import com.mbridge.msdk.out.BaseExtraInterfaceForHandler;
import com.mbridge.msdk.reward.controller.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
@Deprecated
public class MBBidInterstitialVideoHandler implements BaseExtraInterfaceForHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5308a;
    private String b;
    private String c;
    private String d;
    private String e;
    private a f;
    private NewInterstitialListener g;
    private int h = 2;
    private boolean i = false;
    private boolean j = false;
    private boolean k = false;
    private int l;
    private int m;
    public String mUnitId;
    private int n;

    public MBBidInterstitialVideoHandler(Context context, String str, String str2) {
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
        this.mUnitId = str2;
        this.f5308a = str;
        a();
    }

    private void b(String str, String str2) {
        try {
            if (this.f == null) {
                a aVar = new a();
                this.f = aVar;
                aVar.d(true);
                this.f.e(true);
                this.f.c(str, str2);
            }
        } catch (Throwable th) {
            o0.b("MBBidInterstitialVideoHandler", th.getMessage(), th);
        }
    }

    private void c() {
        a aVar = this.f;
        if (aVar != null) {
            aVar.a(this.l, this.n, this.m);
        }
    }

    public void clearVideoCache() {
        try {
            a aVar = this.f;
            if (aVar != null) {
                aVar.e();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getCreativeIdWithUnitId() {
        a aVar = this.f;
        return aVar != null ? aVar.j() : "";
    }

    public String getRequestId() {
        a aVar = this.f;
        return aVar != null ? aVar.m() : "";
    }

    public boolean isBidReady() {
        a();
        a aVar = this.f;
        if (aVar != null) {
            return aVar.c(true);
        }
        return false;
    }

    public void loadFormSelfFilling() {
        a();
        if (this.f != null) {
            this.f.a(false, d.b().a(1, 287, this.mUnitId, true, 1));
        }
    }

    public void loadFromBid(String str) {
        a();
        if (this.f != null) {
            this.f.a(true, str, d.b().a(1, 287, this.mUnitId, true, 2));
        }
    }

    public void playVideoMute(int i) {
        this.h = i;
        a aVar = this.f;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    public void setAlertDialogText(String str, String str2, String str3, String str4) {
        this.c = str;
        this.b = str2;
        this.d = str3;
        this.e = str4;
        this.j = true;
        MBridgeGlobalCommon.setAlertDialogText(this.mUnitId, str, str2, str3, str4);
    }

    @Override // com.mbridge.msdk.out.BaseExtraInterfaceForHandler
    public void setExtraInfo(JSONObject jSONObject) {
        c.m().a(this.mUnitId, jSONObject);
    }

    public void setIVRewardEnable(int i, int i2) {
        this.l = i;
        this.m = i2;
        this.n = com.mbridge.msdk.foundation.same.a.K;
        this.k = true;
        c();
    }

    public void setInterstitialVideoListener(NewInterstitialListener newInterstitialListener) {
        this.g = newInterstitialListener;
        this.i = true;
        a aVar = this.f;
        if (aVar == null || aVar.u()) {
            return;
        }
        this.f.a(new com.mbridge.msdk.newinterstitial.listener.a(newInterstitialListener));
        this.i = false;
    }

    @Deprecated
    public void setRewardVideoListener(NewInterstitialListener newInterstitialListener) {
        this.g = newInterstitialListener;
        this.i = true;
        a aVar = this.f;
        if (aVar == null || aVar.u()) {
            return;
        }
        this.f.a(new com.mbridge.msdk.newinterstitial.listener.a(newInterstitialListener));
        this.i = false;
    }

    public void showFromBid() {
        a();
        if (this.f != null) {
            this.f.a((String) null, (String) null, (String) null, d.b().a(1, 287, this.mUnitId, false, -1));
        }
    }

    public void setIVRewardEnable(int i, double d) {
        this.l = i;
        this.m = (int) (d * 100.0d);
        this.n = com.mbridge.msdk.foundation.same.a.J;
        this.k = true;
        c();
    }

    private void a() {
        if (this.f == null) {
            b(this.f5308a, this.mUnitId);
        }
        b();
    }

    private void b() {
        a aVar;
        if (this.i) {
            a aVar2 = this.f;
            if (aVar2 != null) {
                aVar2.a(new com.mbridge.msdk.newinterstitial.listener.a(this.g));
            }
            this.i = false;
        }
        if (this.j) {
            a aVar3 = this.f;
            if (aVar3 != null) {
                aVar3.a(this.c, this.b, this.d, this.e);
            }
            this.j = false;
        }
        if (!this.k || (aVar = this.f) == null) {
            return;
        }
        aVar.a(this.l, this.n, this.m);
        this.k = false;
    }

    public MBBidInterstitialVideoHandler(String str, String str2) {
        a(str, str2);
    }
}
