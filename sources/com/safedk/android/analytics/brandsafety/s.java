package com.safedk.android.analytics.brandsafety;

import android.app.Activity;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: loaded from: classes6.dex */
public class s extends c {
    boolean V;
    boolean W;
    boolean X;
    ScheduledFuture<?> Y;
    ScheduledFuture<?> Z;
    WeakReference<Activity> aa;
    public NativeFinder.a ab;
    boolean ac;
    long ad;
    long ae;
    float af;
    String ag;
    boolean ah;

    public s(String[] strArr, String str, int i, String str2, Bundle bundle, String str3) {
        this(strArr, str, i, str2, bundle, str3, BrandSafetyUtils.AdType.NATIVE);
    }

    public s(String str, long j) {
        super(str, j, BrandSafetyUtils.AdType.NATIVE);
        this.V = false;
        this.W = false;
        this.X = false;
        this.ab = null;
        this.ac = false;
        this.ad = 0L;
        this.ae = 0L;
        this.af = 0.0f;
        this.ag = null;
        this.ah = false;
    }

    public s(String str, String str2, String str3, BrandSafetyUtils.ScreenShotOrientation screenShotOrientation, String str4, String str5) {
        this(str, str2, str3, screenShotOrientation, str4, str5, BrandSafetyUtils.AdType.NATIVE);
    }

    protected s(String str, String str2, String str3, BrandSafetyUtils.ScreenShotOrientation screenShotOrientation, String str4, String str5, BrandSafetyUtils.AdType adType) {
        super(str, str2, str3, screenShotOrientation, str4, adType);
        this.V = false;
        this.W = false;
        this.X = false;
        this.ab = null;
        this.ac = false;
        this.ad = 0L;
        this.ae = 0L;
        this.af = 0.0f;
        this.ag = null;
        this.ah = false;
        this.q = str5;
    }

    private s(String[] strArr, String str, int i, String str2, Bundle bundle, String str3, BrandSafetyUtils.AdType adType) {
        super(strArr, i, bundle, null, str, null, BrandSafetyUtils.ScreenShotOrientation.NOT_INITIALIZED, adType);
        this.V = false;
        this.W = false;
        this.X = false;
        this.ab = null;
        this.ac = false;
        this.ad = 0L;
        this.ae = 0L;
        this.af = 0.0f;
        this.ag = null;
        this.ah = false;
        this.ag = str2;
        if (str3 != null) {
            this.L = str3;
        }
    }
}
