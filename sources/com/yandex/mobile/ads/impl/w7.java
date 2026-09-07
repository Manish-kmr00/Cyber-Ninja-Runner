package com.yandex.mobile.ads.impl;

import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes6.dex */
public final class w7 {
    public static final /* synthetic */ int A = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final w3 f10539a = new w3(1, "Received unsupported ad type", "Received unsupported ad type. We are already working on this issue.", null);
    private static final w3 b = new w3(5, "android.webkit.WebView database is inoperable", "android.webkit.WebViewDatabase is inoperable. Try using another device for testing.", null);
    private static final w3 c = new w3(1, "Internal state wasn't completely configured", "Internal state wasn't completely configured. Please try again later.", null);
    private static final w3 d = new w3(1, "Incorrect data in server response", "Failed to parse server's response. We are already working on this issue.", null);
    private static final w3 e = new w3(5, "android.webkit.WebView creation failed", "android.webkit.WebView creation failed. Try using another device for testing.", null);
    private static final w3 f = new w3(1, "Invalid server response code", "Unexpected server response code. We are already working on this issue.", null);
    private static final w3 g = new w3(1, "Service temporarily unavailable", "Service temporarily unavailable. Please try again later.", null);
    private static final w3 h = new w3(1, "The loaded banner can't fit in the container.", "The loaded banner can't fit in the container.", null);
    private static final w3 i = new w3(1, "Banner rendering failed with timeout", "Banner rendering failed with timeout. Please try again.", null);
    private static final w3 j = new w3(1, "Invalid SDK state.", "Invalid SDK state.", null);
    private static final w3 k = new w3(1, "Invalid SDK state.", "Invalid SDK state.", null);
    private static final w3 l = new w3(4, "Ad request completed successfully, but there are no ads available.", "Ad request completed successfully, but there are no ads available.", null);
    private static final w3 m;
    private static final w3 n;
    private static final w3 o;
    private static final w3 p;
    private static final w3 q;
    private static final w3 r;
    private static final w3 s;
    private static final w3 t;
    private static final w3 u;
    private static final w3 v;
    private static final w3 w;
    private static final w3 x;
    private static final w3 y;
    private static final w3 z;

    public static w3 a(String errorType, String description) {
        Intrinsics.checkNotNullParameter(errorType, "errorType");
        Intrinsics.checkNotNullParameter(description, "description");
        return a(1, errorType, description);
    }

    public static w3 b() {
        return h;
    }

    public static w3 c() {
        return x;
    }

    public static w3 d() {
        return z;
    }

    public static w3 e() {
        return p;
    }

    public static w3 f() {
        return o;
    }

    public static w3 g() {
        return k;
    }

    public static w3 h() {
        return q;
    }

    public static w3 i() {
        return j;
    }

    public static w3 j() {
        return f;
    }

    public static w3 k() {
        return d;
    }

    public static w3 l() {
        return i;
    }

    public static w3 m() {
        return c;
    }

    public static w3 n() {
        return t;
    }

    public static w3 o() {
        return r;
    }

    public static w3 p() {
        return u;
    }

    public static w3 q() {
        return l;
    }

    public static w3 r() {
        return y;
    }

    public static w3 s() {
        return s;
    }

    public static w3 t() {
        return m;
    }

    public static w3 u() {
        return n;
    }

    public static w3 v() {
        return g;
    }

    public static w3 w() {
        return v;
    }

    public static w3 x() {
        return f10539a;
    }

    public static w3 y() {
        return e;
    }

    public static w3 z() {
        return b;
    }

    public static w3 a(String str) {
        String str2;
        String errorType;
        if (str != null && str.length() != 0) {
            str2 = "Provided AdUnitId '%s' does not exist! Please set the AdUnitId using the setAdUnitId method. AdUnitId is a unique identifier in R-M-XXXXXX-Y format, which is assigned in the Partner Interface.";
            errorType = "Provided ad unit id doesn't exist";
        } else {
            str2 = "Invalid AdUnitId. Please set the AdUnitId using the setAdUnitId method. AdUnitId is a unique identifier in R-M-XXXXXX-Y format, which is assigned in the Partner Interface.";
            errorType = "Invalid Ad Unit Id. AdUnitId should be not empty string";
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String description = String.format(Locale.US, str2, Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(description, "format(...)");
        Intrinsics.checkNotNullParameter(errorType, "errorType");
        Intrinsics.checkNotNullParameter(description, "description");
        return new w3(2, errorType, description, null);
    }

    static {
        Intrinsics.checkNotNullParameter("Ad request configured incorrectly", "errorType");
        Intrinsics.checkNotNullParameter("Ad request configured incorrectly", "description");
        m = new w3(2, "Ad request configured incorrectly", "Ad request configured incorrectly", null);
        Intrinsics.checkNotNullParameter("Invalid request parameters", "errorType");
        Intrinsics.checkNotNullParameter("Invalid request parameters", "description");
        n = new w3(2, "Invalid request parameters", "Invalid request parameters", null);
        Intrinsics.checkNotNullParameter("Invalid Ad Unit Id. AdUnitId should be not empty string", "errorType");
        Intrinsics.checkNotNullParameter("Invalid AdUnitId. Please set the AdUnitId using the setAdUnitId method. AdUnitId is a unique identifier in R-M-XXXXXX-Y format, which is assigned in the Partner Interface.", "description");
        o = new w3(2, "Invalid Ad Unit Id. AdUnitId should be not empty string", "Invalid AdUnitId. Please set the AdUnitId using the setAdUnitId method. AdUnitId is a unique identifier in R-M-XXXXXX-Y format, which is assigned in the Partner Interface.", null);
        Intrinsics.checkNotNullParameter("Invalid ad size. Please, specify AdSize excplicitly", "errorType");
        Intrinsics.checkNotNullParameter("Invalid ad size. Set the ad size using the 'setAdSize' method.", "description");
        p = new w3(2, "Invalid ad size. Please, specify AdSize excplicitly", "Invalid ad size. Set the ad size using the 'setAdSize' method.", null);
        q = new w3(1, "Invalid sdk configuration. Please request another ad.", "Invalid sdk configuration. Please request another ad.", null);
        r = new w3(5, "Device hasn't enough free memory.", "Device has not enough free memory.", null);
        s = new w3(2, "Feed ad preloading has already started", "Feed ad preloading was already started. You should use preloadAd method only once", null);
        t = new w3(3, "Ad request failed with network error", "Ad request failed with network error. Please try again later.", null);
        u = new w3(3, "Ad request failed with no connection error", "Ad request failed with network error. Please try again later.", null);
        v = new w3(3, "Ad request failed with timeout error", "Ad request failed with network error. Please try again later.", null);
        w = new w3(3, "Ad request failed with auth failure", "Ad request failed with network error. Please try again later.", null);
        x = new w3(3, "Ad request failed with client error", "Ad request failed with network error. Please try again later.", null);
        y = new w3(3, "Ad request failed with parse error", "Ad request failed with network error. Please try again later.", null);
        z = new w3(1, "Ad request failed with content preloading error", "Ad request failed with content preloading error. Please try again later", null);
    }

    public static w3 a() {
        return w;
    }

    public static w3 a(int i2, int i3, int i4, int i5, int i6, int i7) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "Ad was loaded successfully, but there is not enough space to display it. Requested size: [%dx%d], Received size : [%dx%d], device screen size: [%dx%d].", Arrays.copyOf(new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}, 6));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return new w3(1, "Ad was loaded successfully, but there is not enough space to display it", str, null);
    }

    private static w3 a(int i2, String str, String str2) {
        return new w3(i2, str, str2, null);
    }
}
