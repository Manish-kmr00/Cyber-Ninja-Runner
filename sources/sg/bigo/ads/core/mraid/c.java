package sg.bigo.ads.core.mraid;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.applovin.sdk.AppLovinMediationProvider;
import com.json.b9;
import com.pubmatic.sdk.common.POBCommonConstants;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    b f13633a;
    sg.bigo.ads.common.ac.a b;
    boolean c;
    public boolean d;
    private final n e;
    private final h f;
    private C0899c g;
    private final WebViewClient h;

    /* JADX INFO: renamed from: sg.bigo.ads.core.mraid.c$6, reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13639a;

        static {
            int[] iArr = new int[g.values().length];
            f13639a = iArr;
            try {
                iArr[g.CLOSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13639a[g.RESIZE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13639a[g.UNLOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13639a[g.EXPAND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13639a[g.USE_CUSTOM_CLOSE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f13639a[g.OPEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f13639a[g.SET_ORIENTATION_PROPERTIES.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f13639a[g.PLAY_VIDEO.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f13639a[g.STORE_PICTURE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f13639a[g.CREATE_CALENDAR_EVENT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f13639a[g.UNSPECIFIED.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public interface a extends b {
        void a(String str, String str2);
    }

    public interface b {
        void a();

        void a(int i, int i2, int i3, int i4, sg.bigo.ads.core.mraid.a.a.EnumC0898a enumC0898a, boolean z);

        void a(String str);

        void a(String str, sg.bigo.ads.common.i iVar);

        void a(String str, boolean z);

        void a(sg.bigo.ads.core.mraid.b bVar);

        void a(boolean z);

        void a(boolean z, i iVar);

        boolean a(JsResult jsResult);

        void b();

        void b(boolean z);

        void c();

        boolean d();

        void e();

        void f();
    }

    /* JADX INFO: renamed from: sg.bigo.ads.core.mraid.c$c, reason: collision with other inner class name */
    public static class C0899c extends sg.bigo.ads.core.h.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f13640a;
        private a b;
        private p c;
        private sg.bigo.ads.common.i d;

        /* JADX INFO: renamed from: sg.bigo.ads.core.mraid.c$c$a */
        public interface a {
            void a(sg.bigo.ads.core.mraid.b bVar);

            void a(boolean z);
        }

        private C0899c(Context context) {
            super(context);
            this.d = new sg.bigo.ads.common.i();
            this.c = new p(this);
            this.c.d = new p.b() { // from class: sg.bigo.ads.core.mraid.c.c.1
                @Override // sg.bigo.ads.core.mraid.p.b
                public final void a(boolean z, sg.bigo.ads.core.mraid.b bVar) {
                    C0899c.this.setMraidViewable(z);
                    C0899c.a(C0899c.this, bVar);
                }
            };
        }

        /* synthetic */ C0899c(Context context, byte b) {
            this(context);
        }

        static /* synthetic */ void a(C0899c c0899c, sg.bigo.ads.core.mraid.b bVar) {
            a aVar = c0899c.b;
            if (aVar != null) {
                aVar.a(bVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMraidViewable(boolean z) {
            if (this.f13640a == z) {
                return;
            }
            this.f13640a = z;
            a aVar = this.b;
            if (aVar != null) {
                aVar.a(z);
            }
        }

        @Override // sg.bigo.ads.core.h.e, android.webkit.WebView
        public final void destroy() {
            super.destroy();
            setWebChromeClient(null);
            setWebViewClient(null);
            this.c = null;
            this.b = null;
        }

        public final sg.bigo.ads.common.i getClickPoints() {
            return this.d;
        }

        @Override // android.webkit.WebView, android.view.View
        public final boolean onTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getActionMasked() == 1) {
                this.d.b = new Point((int) motionEvent.getX(), (int) motionEvent.getY());
            }
            if (motionEvent.getActionMasked() == 0) {
                this.d.f13209a = new Point((int) motionEvent.getX(), (int) motionEvent.getY());
            }
            return super.onTouchEvent(motionEvent);
        }

        @Override // android.webkit.WebView, android.view.View
        protected final void onVisibilityChanged(View view, int i) {
            super.onVisibilityChanged(view, i);
            if (this.c == null) {
                setMraidViewable(i == 0);
            } else if (i != 0) {
                setMraidViewable(false);
            }
        }

        final void setVisibilityChangedListener(a aVar) {
            this.b = aVar;
        }
    }

    c(n nVar) {
        this(nVar, new h());
    }

    private c(n nVar, h hVar) {
        this.d = false;
        this.h = new k() { // from class: sg.bigo.ads.core.mraid.c.4
            @Override // sg.bigo.ads.core.mraid.k, sg.bigo.ads.core.h.d
            public final void a(RenderProcessGoneDetail renderProcessGoneDetail) {
                c cVar = c.this;
                sg.bigo.ads.common.t.a.a(0, "MraidBridge", (renderProcessGoneDetail == null || !renderProcessGoneDetail.didCrash()) ? "Render process is gone" : "Render process has crashed");
                cVar.a();
                if (cVar.f13633a != null) {
                    cVar.f13633a.c();
                }
            }

            @Override // sg.bigo.ads.core.h.d, android.webkit.WebViewClient
            public final void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                c cVar = c.this;
                if (cVar.c) {
                    return;
                }
                cVar.c = true;
                if (cVar.f13633a != null) {
                    cVar.f13633a.a();
                }
            }

            @Override // android.webkit.WebViewClient
            public final void onReceivedError(WebView webView, int i, String str, String str2) {
                sg.bigo.ads.common.t.a.a(0, "MraidBridge", "Error: ".concat(String.valueOf(str)));
                super.onReceivedError(webView, i, str, str2);
            }

            @Override // android.webkit.WebViewClient
            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return c.this.d(str);
            }
        };
        this.e = nVar;
        this.f = hVar;
    }

    private static int a(int i, int i2) throws d {
        if (i < i2 || i > 100000) {
            throw new d("Integer parameter out of range: ".concat(String.valueOf(i)));
        }
        return i;
    }

    private static String a(Rect rect) {
        return rect.left + StringUtils.COMMA + rect.top + StringUtils.COMMA + rect.width() + StringUtils.COMMA + rect.height();
    }

    private static Map<String, String> a(Uri uri) {
        HashMap map = new HashMap();
        for (String str : uri.getQueryParameterNames()) {
            map.put(str, TextUtils.join(StringUtils.COMMA, uri.getQueryParameters(str)));
        }
        return map;
    }

    static C0899c a(Context context) {
        try {
            return new C0899c(context, (byte) 0);
        } catch (Exception e) {
            sg.bigo.ads.core.d.b.a(3000, 10100, Log.getStackTraceString(e));
            return null;
        }
    }

    private static boolean a(String str, boolean z) {
        return str == null ? z : g(str);
    }

    private static boolean a(Map<String, String> map) {
        return a(map.get("shouldUseCustomClose"), false);
    }

    private static String b(Rect rect) {
        return rect.width() + StringUtils.COMMA + rect.height();
    }

    private boolean d() {
        sg.bigo.ads.common.ac.a aVar = this.b;
        if (aVar == null) {
            return false;
        }
        if (this.d) {
            return aVar.f13128a.f13129a;
        }
        return aVar.a();
    }

    private static String e(String str) throws d {
        if (str != null) {
            return str;
        }
        throw new d("Parameter cannot be null");
    }

    private static int f(String str) throws d {
        try {
            return Integer.parseInt(str, 10);
        } catch (NumberFormatException unused) {
            throw new d("Invalid numeric parameter: ".concat(String.valueOf(str)));
        }
    }

    private static boolean g(String str) throws d {
        if ("true".equals(str)) {
            return true;
        }
        if ("false".equals(str)) {
            return false;
        }
        throw new d("Invalid boolean parameter: ".concat(String.valueOf(str)));
    }

    final void a() {
        C0899c c0899c = this.g;
        if (c0899c != null) {
            c0899c.setOnTouchListener(null);
            this.g.setVisibilityChangedListener(null);
            this.g.destroy();
            this.g = null;
        }
    }

    public final void a(String str) {
        if (this.g == null) {
            sg.bigo.ads.common.t.a.a(0, "MraidBridge", "MRAID bridge called setContentHtml before WebView was attached");
            return;
        }
        this.c = false;
        sg.bigo.ads.common.t.a.a(0, 3, "MraidBridge", "MraidBridge setContentHtml");
        this.g.loadDataWithBaseURL("https://mraid.bigo.sg", str, POBCommonConstants.CONTENT_TYPE_HTML, null, null);
    }

    final void a(sg.bigo.ads.core.mraid.b bVar) {
        c("mraidbridge.notifyExposureChangeEvent(" + (String.valueOf(bVar.f13632a) + ", " + sg.bigo.ads.core.mraid.b.a(bVar.b) + ", " + sg.bigo.ads.core.mraid.b.a(bVar.c)) + ");");
    }

    final void a(C0899c c0899c) {
        this.g = c0899c;
        c0899c.getSettings().setJavaScriptEnabled(true);
        if (this.e == n.INTERSTITIAL) {
            c0899c.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        this.g.setScrollContainer(false);
        this.g.setVerticalScrollBarEnabled(false);
        this.g.setHorizontalScrollBarEnabled(false);
        this.g.setBackgroundColor(0);
        this.g.setWebViewClient(this.h);
        this.g.setWebChromeClient(new sg.bigo.ads.core.h.c() { // from class: sg.bigo.ads.core.mraid.c.1
            @Override // sg.bigo.ads.core.h.c
            public final void a(WebView webView, String str, String str2) {
                super.a(webView, str, str2);
                if (c.this.f13633a == null || !(c.this.f13633a instanceof a)) {
                    return;
                }
                ((a) c.this.f13633a).a(str, str2);
            }

            @Override // android.webkit.WebChromeClient
            public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                return c.this.f13633a != null ? c.this.f13633a.d() : super.onConsoleMessage(consoleMessage);
            }

            @Override // sg.bigo.ads.core.h.c, android.webkit.WebChromeClient
            public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                return c.this.f13633a != null ? c.this.f13633a.a(jsResult) : super.onJsAlert(webView, str, str2, jsResult);
            }

            @Override // android.webkit.WebChromeClient
            public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                super.onShowCustomView(view, customViewCallback);
            }
        });
        this.b = new sg.bigo.ads.common.ac.a(this.g.getContext());
        this.g.setOnTouchListener(new View.OnTouchListener() { // from class: sg.bigo.ads.core.mraid.c.2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.b.onTouchEvent(motionEvent);
                int action = motionEvent.getAction();
                if ((action != 0 && action != 1) || view.hasFocus()) {
                    return false;
                }
                view.requestFocus();
                return false;
            }
        });
        this.g.setVisibilityChangedListener(new C0899c.a() { // from class: sg.bigo.ads.core.mraid.c.3
            @Override // sg.bigo.ads.core.mraid.c.C0899c.a
            public final void a(sg.bigo.ads.core.mraid.b bVar) {
                if (c.this.f13633a != null) {
                    c.this.f13633a.a(bVar);
                }
            }

            @Override // sg.bigo.ads.core.mraid.c.C0899c.a
            public final void a(boolean z) {
                if (c.this.f13633a != null) {
                    c.this.f13633a.a(z);
                }
            }
        });
    }

    final void a(g gVar, String str) {
        c("window.mraidbridge.notifyErrorEvent(" + JSONObject.quote(gVar.l) + ", " + JSONObject.quote(str) + ")");
    }

    public final void a(j jVar) {
        String str;
        StringBuilder sbAppend = new StringBuilder("mraidbridge.setScreenSize(").append(b(jVar.b)).append(");mraidbridge.setMaxSize(").append(b(jVar.d)).append(");mraidbridge.setCurrentPosition(").append(a(jVar.f)).append(");mraidbridge.setDefaultPosition(").append(a(jVar.h)).append(");mraidbridge.setCurrentAppOrientation(");
        C0899c c0899c = this.g;
        if (c0899c == null) {
            str = "";
        } else {
            Context context = c0899c.getContext();
            Activity activity = context instanceof Activity ? (Activity) context : null;
            String str2 = context.getResources().getConfiguration().orientation == 2 ? "landscape" : "portrait";
            boolean z = false;
            if (activity == null) {
                sg.bigo.ads.common.t.a.a(0, 3, "MraidBridge", "Context is not an Activity, set locked to false");
            } else if (activity.getRequestedOrientation() != -1) {
                z = true;
            }
            str = "'" + str2 + "', " + z;
        }
        c(sbAppend.append(str).append(")").toString());
        c("mraidbridge.notifySizeChangeEvent(" + b(jVar.f) + ")");
    }

    final void a(n nVar) {
        c("mraidbridge.setPlacementType(" + JSONObject.quote(nVar.toString().toLowerCase(Locale.US)) + ")");
    }

    final void a(o oVar) {
        c("mraidbridge.setState(" + JSONObject.quote(oVar.toString().toLowerCase(Locale.US)) + ")");
    }

    final void a(boolean z) {
        c("mraidbridge.setIsViewable(" + z + ")");
    }

    final void a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        c("mraidbridge.setSupports(" + z + StringUtils.COMMA + z2 + StringUtils.COMMA + z3 + StringUtils.COMMA + z4 + StringUtils.COMMA + z5 + ")");
    }

    public final void b(String str) {
        C0899c c0899c = this.g;
        if (c0899c == null) {
            sg.bigo.ads.common.t.a.a(0, "MraidBridge", "MRAID bridge called setContentHtml while WebView was not attached");
        } else {
            this.c = false;
            c0899c.loadUrl(str);
        }
    }

    final boolean b() {
        C0899c c0899c = this.g;
        return c0899c != null && c0899c.f13640a;
    }

    final void c(String str) {
        if (this.g == null) {
            sg.bigo.ads.common.t.a.a(0, "MraidBridge", "Attempted to inject Javascript into MRAID WebView while was not attached:\n\t".concat(String.valueOf(str)));
        } else {
            sg.bigo.ads.common.t.a.a(0, 3, "MraidBridge", "Injecting Javascript into MRAID WebView:\n\t".concat(String.valueOf(str)));
            this.g.loadUrl("javascript:".concat(String.valueOf(str)));
        }
    }

    final boolean c() {
        return this.g != null;
    }

    final boolean d(String str) {
        sg.bigo.ads.core.mraid.a.a.EnumC0898a enumC0898a;
        sg.bigo.ads.core.mraid.a.a.EnumC0898a enumC0898a2;
        i iVar;
        b bVar;
        try {
            Uri uri = Uri.parse(str);
            if (uri == null) {
                return true;
            }
            String scheme = uri.getScheme();
            String host = uri.getHost();
            if (AppLovinMediationProvider.MOPUB.equals(scheme)) {
                if ("failLoad".equals(host) && this.e == n.INLINE && (bVar = this.f13633a) != null) {
                    bVar.b();
                }
                return true;
            }
            if (d() && !"mraid".equals(scheme)) {
                try {
                    try {
                        uri = Uri.parse("mraid://open?url=" + URLEncoder.encode(str, "UTF-8"));
                        host = uri.getHost();
                        scheme = uri.getScheme();
                    } catch (UnsupportedEncodingException unused) {
                        sg.bigo.ads.common.t.a.a(0, "MraidBridge", "Invalid MRAID URL encoding: ".concat(String.valueOf(str)));
                        a(g.OPEN, "Non-mraid URL is invalid");
                        return false;
                    }
                } catch (UnsupportedEncodingException unused2) {
                }
            }
            if (!"mraid".equals(scheme)) {
                sg.bigo.ads.common.ac.a aVar = this.b;
                return aVar != null && aVar.a();
            }
            final g gVarA = g.a(host);
            try {
                Map<String, String> mapA = a(uri);
                if (gVarA.a(this.e) && !d()) {
                    throw new d("Cannot execute this command unless the user clicks");
                }
                if (this.f13633a == null) {
                    throw new d("Invalid state to execute this command");
                }
                if (this.g == null) {
                    throw new d("The current WebView is being destroyed");
                }
                switch (AnonymousClass6.f13639a[gVarA.ordinal()]) {
                    case 1:
                        this.f13633a.f();
                        break;
                    case 2:
                        int iA = a(f(mapA.get("width")), 0);
                        int iA2 = a(f(mapA.get("height")), 0);
                        int iA3 = a(f(mapA.get("offsetX")), -100000);
                        int iA4 = a(f(mapA.get("offsetY")), -100000);
                        String str2 = mapA.get("customClosePosition");
                        sg.bigo.ads.core.mraid.a.a.EnumC0898a enumC0898a3 = sg.bigo.ads.core.mraid.a.a.EnumC0898a.TOP_RIGHT;
                        if (TextUtils.isEmpty(str2)) {
                            enumC0898a2 = enumC0898a3;
                        } else {
                            if (str2.equals(b9.e.c)) {
                                enumC0898a = sg.bigo.ads.core.mraid.a.a.EnumC0898a.TOP_LEFT;
                            } else if (str2.equals("top-right")) {
                                enumC0898a = sg.bigo.ads.core.mraid.a.a.EnumC0898a.TOP_RIGHT;
                            } else if (str2.equals("center")) {
                                enumC0898a = sg.bigo.ads.core.mraid.a.a.EnumC0898a.CENTER;
                            } else if (str2.equals(b9.e.e)) {
                                enumC0898a = sg.bigo.ads.core.mraid.a.a.EnumC0898a.BOTTOM_LEFT;
                            } else if (str2.equals(b9.e.d)) {
                                enumC0898a = sg.bigo.ads.core.mraid.a.a.EnumC0898a.BOTTOM_RIGHT;
                            } else if (str2.equals("top-center")) {
                                enumC0898a = sg.bigo.ads.core.mraid.a.a.EnumC0898a.TOP_CENTER;
                            } else {
                                if (!str2.equals("bottom-center")) {
                                    throw new d("Invalid close position: ".concat(String.valueOf(str2)));
                                }
                                enumC0898a = sg.bigo.ads.core.mraid.a.a.EnumC0898a.BOTTOM_CENTER;
                            }
                            enumC0898a2 = enumC0898a;
                        }
                        this.f13633a.a(iA, iA2, iA3, iA4, enumC0898a2, a(mapA.get("allowOffscreen"), true));
                        this.f13633a.b(false);
                        break;
                    case 3:
                        this.f13633a.e();
                        break;
                    case 4:
                        this.f13633a.a(mapA.get("url"), a(mapA));
                        break;
                    case 5:
                        this.f13633a.b(a(mapA));
                        break;
                    case 6:
                        this.f13633a.a(e(mapA.get("url")), this.g.getClickPoints());
                        break;
                    case 7:
                        boolean zG = g(mapA.get("allowOrientationChange"));
                        String str3 = mapA.get("forceOrientation");
                        if ("portrait".equals(str3)) {
                            iVar = i.PORTRAIT;
                        } else if ("landscape".equals(str3)) {
                            iVar = i.LANDSCAPE;
                        } else {
                            if (!"none".equals(str3)) {
                                throw new d("Invalid orientation: ".concat(String.valueOf(str3)));
                            }
                            iVar = i.NONE;
                        }
                        this.f13633a.a(zG, iVar);
                        break;
                    case 8:
                        this.f13633a.a(e(mapA.get("uri")));
                        break;
                    case 9:
                        String strE = e(mapA.get("uri"));
                        h hVar = this.f;
                        Context context = this.g.getContext();
                        h.c cVar = new h.c() { // from class: sg.bigo.ads.core.mraid.c.5
                            @Override // sg.bigo.ads.core.mraid.h.c
                            public final void a(d dVar) {
                                c.this.a(gVarA, dVar.getMessage());
                            }
                        };
                        if (!h.c(context)) {
                            sg.bigo.ads.common.t.a.a(0, "MraidBridge", "Error downloading file - the device does not have an SD card mounted, or the Android permission is not granted.");
                            throw new d("Error downloading file  - the device does not have an SD card mounted, or the Android permission is not granted.");
                        }
                        if (!(context instanceof Activity)) {
                            Toast.makeText(context, "Downloading image", 0).show();
                            hVar.a(context, strE, cVar);
                        } else {
                            new AlertDialog.Builder(context).setTitle("Save Image").setMessage("Download image to Picture gallery?").setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).setPositiveButton("Okay", new DialogInterface.OnClickListener() { // from class: sg.bigo.ads.core.mraid.h.3

                                /* JADX INFO: renamed from: a */
                                final /* synthetic */ Context f13660a;
                                final /* synthetic */ String b;
                                final /* synthetic */ c c;

                                AnonymousClass3() {
                                    context = context;
                                    str = strE;
                                    cVar = cVar;
                                }

                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    h.this.a(context, str, cVar);
                                }
                            }).setCancelable(true).show();
                        }
                        break;
                        break;
                    case 10:
                        h.a(this.g.getContext(), mapA);
                        break;
                    case 11:
                        throw new d("Unspecified MRAID Javascript command");
                }
                c("window.mraidbridge.nativeCallComplete(" + JSONObject.quote(gVarA.l) + ")");
                return true;
            } catch (IllegalArgumentException | d e) {
                a(gVarA, e.getMessage());
            }
        } catch (Exception unused3) {
            return true;
        }
    }
}
