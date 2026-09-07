package com.mbridge.msdk.splash.manager;

import android.net.http.SslError;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.splash.view.MBSplashView;
import com.mbridge.msdk.splash.view.MBSplashWebview;
import com.safedk.android.internal.partials.MintegralNetworkBridge;
import java.util.ArrayList;

/* JADX INFO: compiled from: WebViewRenderManager.java */
/* JADX INFO: loaded from: classes5.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5440a;
    private boolean b;

    /* JADX INFO: compiled from: WebViewRenderManager.java */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final g f5442a = new g(null);
    }

    /* JADX INFO: compiled from: WebViewRenderManager.java */
    public interface c {
        void a();

        void a(int i);

        void onError(String str);
    }

    /* JADX INFO: compiled from: WebViewRenderManager.java */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f5443a;
        private String b;
        private CampaignEx c;
        private String d;
        private boolean e;
        private int f;

        public void a(String str) {
            this.d = str;
        }

        public void b(String str) {
            this.f5443a = str;
        }

        public String c() {
            return this.d;
        }

        public String d() {
            return this.f5443a;
        }

        public String e() {
            return this.b;
        }

        public boolean f() {
            return this.e;
        }

        public CampaignEx a() {
            return this.c;
        }

        public int b() {
            return this.f;
        }

        public void c(String str) {
            this.b = str;
        }

        public void a(CampaignEx campaignEx) {
            this.c = campaignEx;
        }

        public void a(boolean z) {
            this.e = z;
        }

        public void a(int i) {
            this.f = i;
        }
    }

    /* synthetic */ g(a aVar) {
        this();
    }

    private g() {
        this.f5440a = false;
        this.b = false;
    }

    public static g a() {
        return b.f5442a;
    }

    public void b() {
        this.f5440a = false;
        this.b = false;
    }

    public void a(MBSplashView mBSplashView, d dVar, c cVar) {
        String requestId;
        if (mBSplashView == null || dVar == null) {
            return;
        }
        String strE = dVar.e();
        String strD = dVar.d();
        CampaignEx campaignExA = dVar.a();
        String strC = dVar.c();
        boolean zF = dVar.f();
        int iB = dVar.b();
        MBSplashWebview splashWebview = mBSplashView.getSplashWebview();
        if (splashWebview == null) {
            return;
        }
        com.mbridge.msdk.splash.signal.b bVar = new com.mbridge.msdk.splash.signal.b(mBSplashView.getContext(), strD, strE);
        ArrayList arrayList = new ArrayList();
        arrayList.add(campaignExA);
        bVar.a(arrayList);
        bVar.a(zF ? 1 : 0);
        bVar.b(iB);
        mBSplashView.setSplashSignalCommunicationImpl(bVar);
        if (TextUtils.isEmpty(campaignExA.getRequestId())) {
            requestId = campaignExA.getRequestIdNotice();
        } else {
            requestId = campaignExA.getRequestId();
        }
        String requestId2 = splashWebview.getRequestId();
        o0.b("WebViewRenderManager", "CampaignEx RequestId = " + requestId + " WebView RequestId = " + requestId2);
        if (!TextUtils.isEmpty(requestId2) && requestId2.equals(requestId) && (this.f5440a || this.b)) {
            mBSplashView.setH5Ready(true);
            if (cVar != null) {
                cVar.a(1);
                return;
            }
            return;
        }
        b();
        splashWebview.setRequestId(requestId);
        com.mbridge.msdk.splash.report.a.b(strE, campaignExA);
        long jCurrentTimeMillis = System.currentTimeMillis();
        splashWebview.setWebViewListener(new a(cVar, mBSplashView, campaignExA, strE, jCurrentTimeMillis));
        if (!splashWebview.isDestoryed()) {
            MintegralNetworkBridge.webviewLoadUrl(splashWebview, strC);
        } else {
            mBSplashView.setH5Ready(false);
            com.mbridge.msdk.splash.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), campaignExA, strE, "webview had destory", jCurrentTimeMillis, 3);
        }
    }

    /* JADX INFO: compiled from: WebViewRenderManager.java */
    class a extends com.mbridge.msdk.mbsignalcommon.listener.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f5441a;
        final /* synthetic */ MBSplashView b;
        final /* synthetic */ CampaignEx c;
        final /* synthetic */ String d;
        final /* synthetic */ long e;

        a(c cVar, MBSplashView mBSplashView, CampaignEx campaignEx, String str, long j) {
            this.f5441a = cVar;
            this.b = mBSplashView;
            this.c = campaignEx;
            this.d = str;
            this.e = j;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, int i) {
            super.a(webView, i);
            c cVar = this.f5441a;
            if (cVar != null) {
                cVar.a(i);
            }
            if (i == 1) {
                g.this.f5440a = true;
                this.b.setH5Ready(true);
                com.mbridge.msdk.splash.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.c, this.d, "", this.e, 1);
                com.mbridge.msdk.splash.report.a.a(1, "", this.d, this.c);
                return;
            }
            g.this.f5440a = false;
            this.b.setH5Ready(false);
            com.mbridge.msdk.splash.report.a.a(2, "readyState 2", this.d, this.c);
            com.mbridge.msdk.splash.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.c, this.d, "readyState 2", this.e, 3);
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, int i, String str, String str2) {
            super.a(webView, i, str, str2);
            c cVar = this.f5441a;
            if (cVar != null) {
                cVar.onError(str);
            }
            g.this.b();
            this.b.setH5Ready(false);
            com.mbridge.msdk.splash.report.a.a(2, "error code:" + i + str, this.d, this.c);
            com.mbridge.msdk.splash.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.c, this.d, "error code:" + i + str, this.e, 3);
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.a(webView, sslErrorHandler, sslError);
            c cVar = this.f5441a;
            if (cVar != null) {
                cVar.onError(sslError.toString());
            }
            g.this.b();
            this.b.setH5Ready(false);
            com.mbridge.msdk.splash.report.a.a(2, "error url:" + sslError.getUrl(), this.d, this.c);
            com.mbridge.msdk.splash.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.c, this.d, "error url:" + sslError.getUrl(), this.e, 3);
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, String str) {
            super.a(webView, str);
            c cVar = this.f5441a;
            if (cVar != null) {
                cVar.a();
            }
            g.this.b = true;
            if (!this.c.isHasMBTplMark()) {
                this.b.setH5Ready(true);
                com.mbridge.msdk.splash.report.a.a(1, "", this.d, this.c);
                com.mbridge.msdk.splash.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.c, this.d, "", this.e, 1);
            }
            com.mbridge.msdk.splash.signal.c.a(webView);
        }
    }
}
