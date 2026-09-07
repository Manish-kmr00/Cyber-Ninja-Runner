package com.mbridge.msdk.mbsignalcommon.webEnvCheck;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.mbsignalcommon.base.b;
import com.mbridge.msdk.setting.g;
import com.mbridge.msdk.setting.h;

/* JADX INFO: compiled from: MBWebViewChecker.java */
/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Boolean f5255a;
    private static volatile Handler b;
    private static Boolean c;

    /* JADX INFO: renamed from: com.mbridge.msdk.mbsignalcommon.webEnvCheck.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MBWebViewChecker.java */
    class RunnableC0465a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f5256a;

        RunnableC0465a(Context context) {
            this.f5256a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.f5255a == null) {
                try {
                    Boolean unused = a.f5255a = Boolean.valueOf(a.a(this.f5256a));
                } catch (Exception unused2) {
                    Boolean unused3 = a.f5255a = Boolean.FALSE;
                }
            }
        }
    }

    public static boolean b(Context context) {
        g gVarB;
        try {
            gVarB = h.b().b(c.m().b());
        } catch (Exception unused) {
            gVarB = null;
        }
        if (gVarB != null) {
            c = Boolean.valueOf(gVarB.C0());
        } else {
            c = Boolean.FALSE;
        }
        Boolean bool = c;
        if (bool == null || !bool.booleanValue()) {
            return true;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            if (f5255a == null) {
                try {
                    f5255a = Boolean.valueOf(a(context));
                } catch (Exception unused2) {
                    f5255a = Boolean.FALSE;
                }
            }
            if (f5255a == null) {
                f5255a = new Boolean(false);
            }
            return f5255a.booleanValue();
        }
        if (f5255a == null && b == null) {
            b = new Handler(Looper.getMainLooper());
            b.post(new RunnableC0465a(context));
        }
        if (f5255a == null) {
            return true;
        }
        return f5255a.booleanValue();
    }

    public static boolean a(Context context) {
        WebView webView;
        try {
            webView = new WebView(context);
            webView.setWebViewClient(new b());
        } catch (Exception unused) {
            webView = null;
        }
        if (webView == null) {
            return false;
        }
        a(webView);
        return true;
    }

    private static void a(WebView webView) {
        try {
            webView.destroy();
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                o0.b("MBWebViewChecker", "destroy webview error", e);
            }
        }
    }
}
