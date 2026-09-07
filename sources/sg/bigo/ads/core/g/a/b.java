package sg.bigo.ads.core.g.a;

import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.google.common.base.Ascii;
import com.pubmatic.sdk.common.POBCommonConstants;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import net.pubnative.lite.sdk.mraid.MRAIDNativeFeature;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.api.core.u;
import sg.bigo.ads.common.i;
import sg.bigo.ads.core.g.d;
import sg.bigo.ads.core.g.e;
import sg.bigo.ads.core.g.f;

/* JADX INFO: loaded from: classes7.dex */
public final class b extends sg.bigo.ads.core.h.b implements sg.bigo.ads.core.g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    e f13603a;
    a b;
    Runnable c;
    public u d;
    sg.bigo.ads.common.ac.a e;
    AtomicBoolean f;
    private final String k;
    private final f l;
    private final String m;
    private final int n;
    private final int o;
    private final int p;
    private final i q;
    private final AtomicBoolean r;
    private boolean s;

    public interface a {
        void a();
    }

    public b(Context context, String str, int i, int i2, f fVar, String str2, int i3, u uVar) {
        super(context);
        this.q = new i();
        this.f = new AtomicBoolean(false);
        this.s = true;
        this.k = str;
        this.o = i;
        this.p = i2;
        this.l = fVar;
        this.m = str2;
        this.n = i3;
        this.d = uVar;
        this.r = new AtomicBoolean(false);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setMediaPlaybackRequiresUserGesture(true);
        setScrollContainer(false);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setBackgroundColor(0);
        this.e = new sg.bigo.ads.common.ac.a(getContext());
        setOnTouchListener(new View.OnTouchListener() { // from class: sg.bigo.ads.core.g.a.b.1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                b.this.f.set(false);
                b.this.e.onTouchEvent(motionEvent);
                return false;
            }
        });
        setWebViewClient(new c(str) { // from class: sg.bigo.ads.core.g.a.b.2
            @Override // sg.bigo.ads.core.g.a.c, sg.bigo.ads.core.h.d
            public final void a(RenderProcessGoneDetail renderProcessGoneDetail) {
                b bVar = b.this;
                sg.bigo.ads.common.t.a.a(0, "VPAIDWebView", (renderProcessGoneDetail == null || !renderProcessGoneDetail.didCrash()) ? "Render process is gone" : "Render process has crashed");
                if (bVar.b != null) {
                    bVar.b.a();
                }
            }

            @Override // sg.bigo.ads.core.h.d, android.webkit.WebViewClient
            public final void onPageFinished(WebView webView, String str3) {
                super.onPageFinished(webView, str3);
                sg.bigo.ads.common.t.a.a(0, "VPAIDWebView", "onPageFinished: ".concat(String.valueOf(str3)));
                if (b.this.r.compareAndSet(false, true)) {
                    final b bVar = b.this;
                    final ValueCallback<String> valueCallback = new ValueCallback<String>() { // from class: sg.bigo.ads.core.g.a.b.2.1
                        @Override // android.webkit.ValueCallback
                        public final /* synthetic */ void onReceiveValue(String str4) {
                            String str5 = str4;
                            b.this.d.b(1);
                            b.this.d.f13118a = str5 != null ? str5 : "";
                            StringBuilder sb = new StringBuilder("handshakeVersion: ");
                            if (str5 == null) {
                                str5 = "";
                            }
                            sg.bigo.ads.common.t.a.a(0, 3, "VPAIDWebView", sb.append(str5).toString());
                        }
                    };
                    bVar.d.a(1);
                    bVar.evaluateJavascript("window.vpaidwrapper.handshakeVersion('2.0')", new ValueCallback<String>() { // from class: sg.bigo.ads.core.g.a.b.6
                        @Override // android.webkit.ValueCallback
                        public final /* bridge */ /* synthetic */ void onReceiveValue(String str4) {
                            valueCallback.onReceiveValue(str4);
                        }
                    });
                    b.this.b();
                }
            }

            @Override // android.webkit.WebViewClient
            public final void onReceivedError(WebView webView, int i4, String str3, String str4) {
                sg.bigo.ads.common.t.a.a(0, "VPAIDWebView", "Error: ".concat(String.valueOf(str3)));
                super.onReceivedError(webView, i4, str3, str4);
            }

            /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
            @Override // android.webkit.WebViewClient
            public final boolean shouldOverrideUrlLoading(WebView webView, String str3) {
                sg.bigo.ads.common.ac.a aVar;
                b bVar = b.this;
                try {
                    Uri uri = Uri.parse(str3);
                    if (uri != null) {
                        String scheme = uri.getScheme();
                        String host = uri.getHost();
                        if (host != null) {
                            if (MRAIDNativeFeature.VPAID.equals(scheme) || (aVar = bVar.e) == null || !aVar.f13128a.f13129a) {
                                HashMap map = new HashMap();
                                for (String str4 : uri.getQueryParameterNames()) {
                                    map.put(str4, TextUtils.join(StringUtils.COMMA, uri.getQueryParameters(str4)));
                                }
                                host.hashCode();
                                byte b = -1;
                                switch (host.hashCode()) {
                                    case -1657484168:
                                        if (host.equals("onAdSkippableStateChange")) {
                                            b = 0;
                                        }
                                        break;
                                    case -1633535831:
                                        if (host.equals("onAdVideoStart")) {
                                            b = 1;
                                        }
                                        break;
                                    case -1354015358:
                                        if (host.equals("onAdLog")) {
                                            b = 2;
                                        }
                                        break;
                                    case -1347047775:
                                        if (host.equals("onAdVideoMidpoint")) {
                                            b = 3;
                                        }
                                        break;
                                    case -1160015669:
                                        if (host.equals("onAdExpandedChange")) {
                                            b = 4;
                                        }
                                        break;
                                    case -742226534:
                                        if (host.equals("onAdVideoFirstQuartile")) {
                                            b = 5;
                                        }
                                        break;
                                    case -609164954:
                                        if (host.equals("onAdDurationChange")) {
                                            b = 6;
                                        }
                                        break;
                                    case -560906938:
                                        if (host.equals("onStartAd")) {
                                            b = 7;
                                        }
                                        break;
                                    case -307657838:
                                        if (host.equals("onAdVideoComplete")) {
                                            b = 8;
                                        }
                                        break;
                                    case -164095715:
                                        if (host.equals("onAdClickThru")) {
                                            b = 9;
                                        }
                                        break;
                                    case 98253676:
                                        if (host.equals("onAdPlaying")) {
                                            b = 10;
                                        }
                                        break;
                                    case 116028939:
                                        if (host.equals("onAdImpression")) {
                                            b = Ascii.VT;
                                        }
                                        break;
                                    case 159970502:
                                        if (host.equals("onAdError")) {
                                            b = Ascii.FF;
                                        }
                                        break;
                                    case 183427630:
                                        if (host.equals("onAdUserAcceptInvitation")) {
                                            b = Ascii.CR;
                                        }
                                        break;
                                    case 590531255:
                                        if (host.equals("onAdLinearChange")) {
                                            b = Ascii.SO;
                                        }
                                        break;
                                    case 652779159:
                                        if (host.equals("VPAIDCreativeError")) {
                                            b = Ascii.SI;
                                        }
                                        break;
                                    case 861234439:
                                        if (host.equals("onAdLoaded")) {
                                            b = Ascii.DLE;
                                        }
                                        break;
                                    case 963431984:
                                        if (host.equals("onAdPaused")) {
                                            b = 17;
                                        }
                                        break;
                                    case 1497850049:
                                        if (host.equals("onSkipAd")) {
                                            b = Ascii.DC2;
                                        }
                                        break;
                                    case 1506340484:
                                        if (host.equals("onStopAd")) {
                                            b = 19;
                                        }
                                        break;
                                    case 1648218545:
                                        if (host.equals("onAdRemainingTimeChange")) {
                                            b = Ascii.DC4;
                                        }
                                        break;
                                    case 1654690129:
                                        if (host.equals("onAdVideoThirdQuartile")) {
                                            b = Ascii.NAK;
                                        }
                                        break;
                                    case 1697251091:
                                        if (host.equals("onAdSizeChange")) {
                                            b = Ascii.SYN;
                                        }
                                        break;
                                    case 1701669456:
                                        if (host.equals("onAdInteraction")) {
                                            b = Ascii.ETB;
                                        }
                                        break;
                                    case 2014353132:
                                        if (host.equals("onAdVolumeChange")) {
                                            b = Ascii.CAN;
                                        }
                                        break;
                                    case 2047444747:
                                        if (host.equals("onAdUserMinimize")) {
                                            b = Ascii.EM;
                                        }
                                        break;
                                    case 2114403499:
                                        if (host.equals("onAdUserClose")) {
                                            b = Ascii.SUB;
                                        }
                                        break;
                                }
                                switch (b) {
                                    case 0:
                                        if (bVar.f13603a != null) {
                                            bVar.f13603a.g();
                                        }
                                        break;
                                    case 1:
                                        bVar.d.b(3);
                                        if (bVar.f13603a != null) {
                                            bVar.f13603a.b();
                                        }
                                        break;
                                    case 2:
                                        if (bVar.f13603a != null) {
                                            bVar.f13603a.b((String) map.get("message"));
                                        }
                                        break;
                                    case 3:
                                        if (bVar.f13603a != null) {
                                            bVar.f13603a.d();
                                        }
                                        break;
                                    case 4:
                                        if (bVar.f13603a != null) {
                                            bVar.f13603a.a(d.c((String) map.get("expanded")));
                                        }
                                        break;
                                    case 5:
                                        if (bVar.f13603a != null) {
                                            bVar.f13603a.c();
                                        }
                                        break;
                                    case 6:
                                        if (bVar.f13603a != null) {
                                            bVar.f13603a.a((int) d.b((String) map.get("duration")));
                                        }
                                        break;
                                    case 7:
                                        if (bVar.f13603a != null) {
                                            bVar.f13603a.j();
                                        }
                                        break;
                                    case 8:
                                        if (bVar.f13603a != null) {
                                            bVar.f13603a.f();
                                        }
                                        break;
                                    case 9:
                                        bVar.d.a((String) map.get("url"), (String) map.get("id"), d.c((String) map.get("playerHandles")));
                                        if (bVar.f13603a != null && bVar.f.compareAndSet(false, true)) {
                                            bVar.f13603a.a((String) map.get("url"), (String) map.get("id"), d.c((String) map.get("playerHandles")));
                                        }
                                        break;
                                    case 10:
                                        if (bVar.f13603a != null) {
                                            bVar.f13603a.i();
                                        }
                                        break;
                                    case 11:
                                        bVar.d.b(4);
                                        if (bVar.f13603a != null) {
                                            bVar.f13603a.a();
                                        }
                                        break;
                                    case 12:
                                        sg.bigo.ads.common.n.d.a(bVar.c);
                                        if (bVar.f13603a != null) {
                                            bVar.f13603a.a((String) map.get("message"));
                                        }
                                        break;
                                    case 13:
                                        if (bVar.f13603a != null) {
                                            bVar.f13603a.n();
                                        }
                                        break;
                                    case 14:
                                        if (bVar.f13603a != null) {
                                            bVar.f13603a.b(d.c((String) map.get("adLinear")));
                                        }
                                        break;
                                    case 15:
                                        sg.bigo.ads.common.t.a.a(0, "VPAIDWebView", "VPAID error, command=" + ((String) map.get(com.ironsource.sdk.controller.f.b.COMMAND)) + ", message=" + ((String) map.get("msg")) + ", try to rePrepareAd.");
                                        bVar.b();
                                        break;
                                    case 16:
                                        sg.bigo.ads.common.n.d.a(bVar.c);
                                        bVar.d.b(2);
                                        if (bVar.f13603a != null) {
                                            bVar.f13603a.h();
                                        }
                                        break;
                                    case 17:
                                        if (bVar.f13603a != null) {
                                            bVar.f13603a.m();
                                        }
                                        break;
                                    case 18:
                                        if (bVar.f13603a != null) {
                                            bVar.f13603a.l();
                                        }
                                        break;
                                    case 19:
                                        if (bVar.f13603a != null) {
                                            bVar.f13603a.k();
                                        }
                                        break;
                                    case 20:
                                        if (bVar.f13603a != null) {
                                            bVar.f13603a.b((int) d.b((String) map.get("remaining")));
                                        }
                                        break;
                                    case 21:
                                        if (bVar.f13603a != null) {
                                            bVar.f13603a.e();
                                        }
                                        break;
                                    case 22:
                                        if (bVar.f13603a != null) {
                                            bVar.f13603a.a(d.a((String) map.get("w")), d.a((String) map.get("h")));
                                        }
                                        break;
                                    case 23:
                                        if (bVar.f13603a != null) {
                                            bVar.f13603a.c((String) map.get("id"));
                                        }
                                        break;
                                    case 24:
                                        if (bVar.f13603a != null) {
                                            bVar.f13603a.a(d.a((String) map.get("volume")));
                                        }
                                        break;
                                    case 25:
                                        if (bVar.f13603a != null) {
                                            bVar.f13603a.o();
                                        }
                                        break;
                                    case 26:
                                        if (bVar.f13603a != null) {
                                            bVar.f13603a.p();
                                        }
                                        break;
                                }
                                bVar.a("window.vpaidwrapper.nativeCallComplete(" + JSONObject.quote(host) + ")");
                            } else if (bVar.f13603a != null && bVar.f.compareAndSet(false, true)) {
                                bVar.d.a(str3, "", false);
                                bVar.f13603a.a(str3, "", false);
                            }
                        }
                    }
                } catch (Exception unused) {
                }
                return true;
            }
        });
        setWebChromeClient(new sg.bigo.ads.core.h.c() { // from class: sg.bigo.ads.core.g.a.b.3
            @Override // android.webkit.WebChromeClient
            public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                return super.onConsoleMessage(consoleMessage);
            }
        });
        sg.bigo.ads.common.n.d.a(this.c);
        if (this.c == null) {
            this.c = new Runnable() { // from class: sg.bigo.ads.core.g.a.b.4
                @Override // java.lang.Runnable
                public final void run() {
                    if (b.this.f13603a != null) {
                        b.this.f13603a.a("vpaid prepare timeout");
                    }
                }
            };
        }
        sg.bigo.ads.common.n.d.a(3, this.c, 15000L);
        loadDataWithBaseURL("http://127.0.0.1/", "<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n    <meta charset=\"UTF-8\">\n    <title>VPAID AD</title>\n    <script>\n        window.onload = function() {\n            tryToPrepareAd();\n        }\n\n        document.onreadystatechange = function() {\n            tryToPrepareAd();\n        }\n\n        function tryToPrepareAd() {\n            if (document.readyState != \"complete\") {\n                return;\n            }\n\n            if (window.vpaidwrapper && window.vpaidwrapper.isVPAIDCreativeReady()) {\n                return;\n            }\n\n            window.vpaidframe = document.getElementById(\"vpaid-iframe\");\n            if (window.vpaidframe) {\n                var fn = window.vpaidframe.contentWindow['getVPAIDAd'];\n                var vpaidDiv = document.getElementById(\"vpaid-container\");\n                var vpaidframeDoc = window.vpaidframe.contentDocument || window.vpaidframe.contentWindow.document;\n                var slot = vpaidframeDoc.getElementById(\"slot\");\n                var videoSlot = document.getElementById(\"video-slot\");\n                var vpaidwrapper;\n                if (fn && typeof fn == 'function') {\n                    vpaidwrapper = new VPAIDWrapper(fn(), vpaidDiv, slot, videoSlot)\n                } else {\n                    vpaidwrapper = new VPAIDWrapper();\n                }\n                window.vpaidwrapper = vpaidwrapper;\n            }\n        }\n    </script>\n    <script src=\"vpaid.js\" type=\"text/javascript\"></script>\n</head>\n\n<body style=\"display: flex; justify-content: center; align-items: center;\">\n<div id=\"ad-container\">\n    <video height=\"100%\" id=\"video-slot\" muted playsinline width=\"100%\"></video>\n</div>\n<div id=\"vpaid-container\"\n     style=\"position: absolute; width: 100%; height: 100%; margin: 0px; padding: 0px; border: none;\">\n    <iframe frameborder=\"0\" height=\"100%\" id=\"vpaid-iframe\" marginheight=\"0\" marginwidth=\"0\"\n            scrolling=\"no\"\n            src=\"vpaid_iframe.html\"\n            style=\"margin: 0px; padding: 0px; border: none;\"\n            width=\"100%\"></iframe>\n</div>\n</body>\n</html>", POBCommonConstants.CONTENT_TYPE_HTML, "UTF-8", null);
        setLayoutParams((i3 == 1 || i3 == 4) ? new FrameLayout.LayoutParams(-1, -1, 17) : new FrameLayout.LayoutParams(-1, -2, 17));
    }

    private void a(int i, int i2) {
        u uVar = this.d;
        if (uVar == null || !uVar.j) {
            return;
        }
        a("window.vpaidwrapper.resizeAd(" + sg.bigo.ads.common.utils.e.c(getContext(), i) + ", " + sg.bigo.ads.common.utils.e.c(getContext(), i2) + ", " + JSONObject.quote(this.l.d) + ")");
    }

    private String b(String str) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final String[] strArr = new String[1];
        evaluateJavascript(str, new ValueCallback<String>() { // from class: sg.bigo.ads.core.g.a.b.5
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(String str2) {
                countDownLatch.countDown();
                strArr[0] = str2;
            }
        });
        try {
            countDownLatch.await(1L, TimeUnit.SECONDS);
        } catch (Exception unused) {
        }
        return strArr[0];
    }

    private void b(int i, int i2) {
        setMeasuredDimension(i, i2);
        a(i, i2);
    }

    @Override // sg.bigo.ads.api.c.a
    public final void a() {
        a("window.vpaidwrapper.pauseAd()");
    }

    public final void a(String str) {
        if (!this.r.get()) {
            sg.bigo.ads.common.t.a.a(0, "VPAIDWebView", "Injecting Javascript into VPAID WebView error, creative no ready:\n\t".concat(String.valueOf(str)));
        } else {
            sg.bigo.ads.common.t.a.a(0, 3, "VPAIDWebView", "Injecting Javascript into VPAID WebView:\n\t".concat(String.valueOf(str)));
            loadUrl("javascript:".concat(String.valueOf(str)));
        }
    }

    public final void b() {
        a("tryToPrepareAd()");
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        JSONObject jSONObject = new JSONObject();
        try {
            String str = this.m;
            if (str == null) {
                str = "";
            }
            jSONObject.putOpt("AdParameters", str);
        } catch (JSONException unused) {
        }
        this.d.a(2);
        a("window.vpaidwrapper.initAd(" + sg.bigo.ads.common.utils.e.c(getContext(), measuredWidth) + ", " + sg.bigo.ads.common.utils.e.c(getContext(), measuredHeight) + ", " + JSONObject.quote(this.l.d) + ", -1, " + jSONObject + ")");
    }

    @Override // sg.bigo.ads.core.h.e, android.webkit.WebView
    public final void destroy() {
        super.destroy();
        setWebChromeClient(null);
        setWebViewClient(null);
    }

    @Override // sg.bigo.ads.core.h.e, android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 1) {
            this.q.b = new Point((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (motionEvent.getActionMasked() == 0) {
            this.q.f13209a = new Point((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        return this.s && super.dispatchTouchEvent(motionEvent);
    }

    public final String getAdCompanions() {
        return b("window.vpaidwrapper.getAdCompanions()");
    }

    public final int getAdDuration() {
        return (int) d.b(b("window.vpaidwrapper.getAdDuration()"));
    }

    public final boolean getAdExpanded() {
        return d.c(b("window.vpaidwrapper.getAdExpanded()"));
    }

    public final int getAdHeight() {
        return d.a(b("window.vpaidwrapper.getAdHeight()"));
    }

    public final boolean getAdIcons() {
        return d.c(b("window.vpaidwrapper.getAdIcons()"));
    }

    public final boolean getAdLinear() {
        return d.c(b("window.vpaidwrapper.getAdLinear()"));
    }

    public final int getAdRemainingTime() {
        return (int) d.b(b("window.vpaidwrapper.getAdRemainingTime()"));
    }

    public final boolean getAdSkippableState() {
        return d.c(b("window.vpaidwrapper.getAdSkippableState()"));
    }

    public final float getAdVolume() {
        return d.b(b("window.vpaidwrapper.getAdVolume()"));
    }

    public final int getAdWidth() {
        return d.a(b("window.vpaidwrapper.getAdWidth()"));
    }

    public final i getClickPoints() {
        return this.q;
    }

    public final e getVPAIDEvenListener() {
        return this.f13603a;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00af A[PHI: r0 r3
  0x00af: PHI (r0v13 int) = (r0v12 int), (r0v14 int) binds: [B:36:0x00ad, B:33:0x00a0] A[DONT_GENERATE, DONT_INLINE]
  0x00af: PHI (r3v6 int) = (r3v5 int), (r3v8 int) binds: [B:36:0x00ad, B:33:0x00a0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:38:0x00b5  */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0093, code lost:
    
        if (r0 != 4) goto L39;
     */
    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void onMeasure(int r13, int r14) {
        /*
            Method dump skipped, instruction units count: 205
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.core.g.a.b.onMeasure(int, int):void");
    }

    public final void setAdVolume(float f) {
        a("window.vpaidwrapper.setAdVolume(" + f + ")");
    }

    public final void setOnRenderProcessGoneListener(a aVar) {
        this.b = aVar;
    }

    public final void setVPAIDClickable(boolean z) {
        this.s = z;
    }

    public final void setVPAIDEvenListener(e eVar) {
        this.f13603a = eVar;
    }
}
