package com.safedk.android.analytics.brandsafety;

import android.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkConfiguration;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: loaded from: classes6.dex */
public class n extends c {
    public boolean V;
    Set<String> W;
    boolean X;
    boolean Y;
    long Z;
    boolean aa;
    public String ab;
    public String ac;
    public long ad;
    public boolean ae;
    public long af;
    public BrandSafetyUtils.ScreenShotOrientation ag;
    public boolean ah;
    public h ai;
    public boolean aj;
    public ScheduledFuture<?> ak;
    public boolean al;
    public boolean am;
    public boolean an;
    public boolean ao;
    public WeakReference<Activity> ap;
    boolean aq;
    String ar;
    boolean as;
    public final Object at;
    public final Object au;

    public boolean H() {
        return this.aq;
    }

    public void g(boolean z) {
        this.aq = z;
    }

    public n(String str, int i, Bundle bundle) {
        super(i, bundle, null, str, null, BrandSafetyUtils.ScreenShotOrientation.NOT_INITIALIZED, BrandSafetyUtils.AdType.INTERSTITIAL);
        this.V = false;
        this.X = true;
        this.Y = true;
        this.aa = false;
        this.ab = null;
        this.ac = null;
        this.ad = 0L;
        this.ae = false;
        this.af = 0L;
        this.ag = BrandSafetyUtils.ScreenShotOrientation.NOT_INITIALIZED;
        this.ah = false;
        this.ai = null;
        this.aj = false;
        this.ak = null;
        this.al = false;
        this.am = false;
        this.an = false;
        this.ao = true;
        this.aq = false;
        this.ar = null;
        this.as = false;
        this.at = new Object();
        this.au = new Object();
        this.W = new HashSet();
        if (str != null) {
            this.aj = CreativeInfoManager.a(str, AdNetworkConfiguration.SDK_INTERSTITIALS_RUN_ON_APP_ACTIVITY, false);
        }
    }

    public n(String str, String str2, String str3, BrandSafetyUtils.ScreenShotOrientation screenShotOrientation, String str4, String str5) {
        super(str, str2, str3, screenShotOrientation, str4, BrandSafetyUtils.AdType.INTERSTITIAL);
        this.V = false;
        this.X = true;
        this.Y = true;
        this.aa = false;
        this.ab = null;
        this.ac = null;
        this.ad = 0L;
        this.ae = false;
        this.af = 0L;
        this.ag = BrandSafetyUtils.ScreenShotOrientation.NOT_INITIALIZED;
        this.ah = false;
        this.ai = null;
        this.aj = false;
        this.ak = null;
        this.al = false;
        this.am = false;
        this.an = false;
        this.ao = true;
        this.aq = false;
        this.ar = null;
        this.as = false;
        this.at = new Object();
        this.au = new Object();
        this.q = str5;
    }

    public void I() {
        this.X = true;
    }

    @Override // com.safedk.android.analytics.brandsafety.c
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("maxSdk: ").append(this.v != null ? this.v : "").append(", activity address: ").append(this.B != null ? this.B : "").append(", view address: ").append(this.K != null ? this.K : "").append(", interstitial activity name: ").append(this.ac != null ? this.ac : "").append(", eventId: ").append(this.L != null ? this.L : "").append(", isAdFinished: ").append(this.U).append(", number of CIs: ").append(k().size());
        return sb.toString();
    }

    public boolean J() {
        return ((this.ap == null || this.ap.get() == null) && (!this.aj || j() == null || j().f() == null)) ? false : true;
    }

    public View K() {
        if (this.ap != null && this.ap.get() != null) {
            return this.ap.get().getWindow().getDecorView().findViewById(R.id.content);
        }
        if (this.aj && j() != null) {
            return j().f();
        }
        return null;
    }

    public void a(String str, boolean z) {
        if (str != null) {
            if (this.ar == null) {
                this.ar = str;
            } else if (!z || !this.ar.contains(str)) {
                this.ar += l.ac + str;
            }
        }
    }

    public void L() {
        d(this.ar);
    }

    public void e(String str) {
        i().k = true;
        this.as = true;
        b(l.p, new l.a(l.P, str));
    }
}
