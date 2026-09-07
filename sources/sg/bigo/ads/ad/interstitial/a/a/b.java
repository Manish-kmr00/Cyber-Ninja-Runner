package sg.bigo.ads.ad.interstitial.a.a;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.FrameLayout;
import java.lang.ref.WeakReference;
import sg.bigo.ads.ad.banner.g;
import sg.bigo.ads.ad.interstitial.s;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.common.i;
import sg.bigo.ads.common.utils.t;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.controller.landing.d;
import sg.bigo.ads.core.f.a.p;
import sg.bigo.ads.core.mraid.e;
import sg.bigo.ads.core.mraid.n;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements sg.bigo.ads.ad.banner.b.InterfaceC0816b, sg.bigo.ads.ad.interstitial.a.b.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final sg.bigo.ads.api.core.c f12633a;
    long e;
    sg.bigo.ads.core.c.b f;
    public g g;
    WebView h;
    public View i;
    boolean j;
    boolean k;
    final sg.bigo.ads.ad.interstitial.a.b.b.a n;
    private final boolean o;
    private final String p;
    private final sg.bigo.ads.core.f.a.a.C0894a q;
    private final sg.bigo.ads.core.player.c r;
    private final p s;
    private final Ad t;
    private e u;
    boolean b = false;
    boolean c = false;
    boolean d = false;
    boolean l = false;
    final C0824b m = new C0824b(0);

    final class a {
        private a() {
        }

        /* synthetic */ a(b bVar, byte b) {
            this();
        }

        @JavascriptInterface
        public final void gameEnd(String str) {
            if (b.this.n != null) {
                b.this.n.b();
            }
        }

        @JavascriptInterface
        public final void onBGNDomContentLoaded() {
            b.this.k = true;
            if (b.this.n != null) {
                b.this.n.c(b.this.f12633a, SystemClock.elapsedRealtime() - b.this.e);
            }
        }

        @JavascriptInterface
        public final void onBGNLoaded() {
            b.this.j = true;
            if (b.this.n != null) {
                b.this.n.b(b.this.f12633a, SystemClock.elapsedRealtime() - b.this.e);
            }
        }
    }

    /* JADX INFO: renamed from: sg.bigo.ads.ad.interstitial.a.a.b$b, reason: collision with other inner class name */
    static final class C0824b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f12637a;
        private int b;
        private WeakReference<Activity> c;

        private C0824b() {
            this.f12637a = false;
            this.b = -1;
        }

        /* synthetic */ C0824b(byte b) {
            this();
        }

        private void b() {
            if (this.f12637a) {
                int i = this.b;
                this.b = -1;
                if (i == 0 || i == 1) {
                    WeakReference<Activity> weakReference = this.c;
                    Activity activity = weakReference == null ? null : weakReference.get();
                    if (activity == null) {
                        return;
                    }
                    activity.setRequestedOrientation(i);
                }
            }
        }

        final void a() {
            this.f12637a = true;
            b();
        }

        public final void a(Activity activity, int i) {
            this.b = i;
            this.c = new WeakReference<>(activity);
            b();
        }
    }

    public b(Ad ad, sg.bigo.ads.api.core.c cVar, sg.bigo.ads.core.player.c cVar2, p pVar, sg.bigo.ads.core.f.a.a.C0894a c0894a, sg.bigo.ads.ad.interstitial.a.b.b.a aVar) {
        this.q = c0894a;
        String str = c0894a == null ? null : c0894a.b;
        this.p = str;
        this.r = cVar2;
        this.s = pVar;
        this.t = ad;
        this.f12633a = cVar;
        this.n = aVar;
        this.o = !TextUtils.isEmpty(str);
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final View a() {
        return this.i;
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final void a(int i) {
        if (i == 1) {
            this.m.a();
            sg.bigo.ads.core.player.c cVar = this.r;
            if (cVar != null) {
                cVar.b();
            }
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final void a(int i, int i2) {
        int i3;
        int i4;
        WebView webView = this.h;
        if (webView == null) {
            return;
        }
        Context context = webView.getContext();
        sg.bigo.ads.core.f.a.a.C0894a c0894a = this.q;
        int i5 = 0;
        if (c0894a != null) {
            i3 = c0894a.c;
            i4 = this.q.d;
        } else {
            i3 = 0;
            i4 = 0;
        }
        if (sg.bigo.ads.common.utils.e.a(context, i3) <= i && sg.bigo.ads.common.utils.e.a(context, i4) <= i2) {
            i5 = i3;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.h.getLayoutParams();
        if (i5 <= 0 || i4 <= 0) {
            layoutParams.width = i;
            layoutParams.height = i2;
        } else {
            layoutParams.gravity = 17;
            layoutParams.width = sg.bigo.ads.common.utils.e.a(context, i5);
            layoutParams.height = sg.bigo.ads.common.utils.e.a(context, i4);
        }
    }

    public final void a(Context context, String str, i iVar) {
        sg.bigo.ads.api.core.e eVarA;
        sg.bigo.ads.common.t.a.a(0, 3, "HtmlVastCompanion", "handle ad click.");
        sg.bigo.ads.ad.interstitial.a.b.b.a aVar = this.n;
        if (aVar == null || !aVar.c()) {
            str = null;
        }
        String str2 = str;
        if (this.f12633a.f().c() == 0 || !(this.t instanceof sg.bigo.ads.ad.c)) {
            eVarA = sg.bigo.ads.ad.interstitial.a.a.a.a(context, this.t, this.f12633a, str2, this.s, this.q);
            eVarA.g = 0;
        } else {
            Context context2 = this.i.getContext();
            Ad ad = this.t;
            d.a(context2, (sg.bigo.ads.ad.c<?, ?>) (ad instanceof s ? ((s) ad).w : (sg.bigo.ads.ad.c) ad));
            eVarA = new sg.bigo.ads.api.core.e();
            eVarA.g = 1;
        }
        sg.bigo.ads.core.player.c cVar = this.r;
        if (cVar != null && !cVar.c()) {
            this.r.a();
        }
        g gVar = this.g;
        if (gVar != null) {
            gVar.a(iVar, eVarA);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final boolean a(final Context context) {
        int i;
        int i2;
        byte b = 0;
        if (!this.o) {
            return false;
        }
        if (this.u == null) {
            try {
                this.u = new e(context, n.INTERSTITIAL);
            } catch (NoClassDefFoundError unused) {
                sg.bigo.ads.common.t.a.a(0, "HtmlVastCompanion", "Banner webview is not support");
            }
            e eVar = this.u;
            if (eVar == null) {
                return false;
            }
            eVar.g = new e.b() { // from class: sg.bigo.ads.ad.interstitial.a.a.b.1
                @Override // sg.bigo.ads.core.mraid.e.b
                public final void a() {
                    b.this.c = true;
                    b.this.d = false;
                    b.this.f = sg.bigo.ads.core.c.c.a.f13533a.a(b.this.h, new View[0]);
                    if (b.this.b) {
                        b bVar = b.this;
                        if (bVar.h != null) {
                            sg.bigo.ads.common.t.a.a(0, 3, "HtmlVastCompanion", "javascript:onViewImpression()");
                            bVar.h.loadUrl("javascript:onViewImpression()");
                        }
                        if (b.this.f != null) {
                            b.this.f.a();
                        }
                    }
                    sg.bigo.ads.ad.banner.b.b(b.this);
                    if (b.this.n != null) {
                        b.this.n.a();
                    }
                }

                @Override // sg.bigo.ads.core.mraid.e.b
                public final void a(String str, i iVar) {
                    b.this.a(context, str, iVar);
                }

                @Override // sg.bigo.ads.core.mraid.e.b
                public final boolean a(Activity activity, int i3) {
                    b.this.m.a(activity, i3);
                    return true;
                }

                @Override // sg.bigo.ads.core.mraid.e.b
                public final void b() {
                    b.this.d = false;
                    b.this.l = true;
                    sg.bigo.ads.ad.banner.b.c(b.this);
                    if (b.this.n != null) {
                        b.this.n.a(b.this.f12633a, SystemClock.elapsedRealtime() - b.this.e);
                    }
                }

                @Override // sg.bigo.ads.core.mraid.e.b
                public final boolean b(Activity activity, int i3) {
                    b.this.m.a(activity, i3);
                    return true;
                }

                @Override // sg.bigo.ads.core.mraid.e.b
                public final void c() {
                    sg.bigo.ads.common.t.a.a(0, "HtmlVastCompanion", "onRenderProcessGone");
                }

                @Override // sg.bigo.ads.core.mraid.e.b
                public final void d() {
                    sg.bigo.ads.common.t.a.a(0, 3, "HtmlVastCompanion", "onExpand");
                }

                @Override // sg.bigo.ads.core.mraid.e.b
                public final void e() {
                    sg.bigo.ads.common.t.a.a(0, 3, "HtmlVastCompanion", "onResize");
                }

                @Override // sg.bigo.ads.core.mraid.e.b
                public final void f() {
                    if (b.this.g != null) {
                        b.this.g.a();
                    }
                }

                @Override // sg.bigo.ads.core.mraid.e.b
                public final void g() {
                    if (b.this.g != null) {
                        b.this.g.a();
                    }
                }
            };
            String str = (sg.bigo.ads.core.c.c.a.f13533a.c(this.p) + "\n<script>document.addEventListener('DOMContentLoaded',function(){BGN_PLAYABLE.onBGNDomContentLoaded()});\nwindow.addEventListener('load',function(){BGN_PLAYABLE.onBGNLoaded()});</script>") + "\n<script type=\"text/javascript\">\n    document.body.style.margin = '0px';\n</script>";
            this.e = SystemClock.elapsedRealtime();
            sg.bigo.ads.ad.interstitial.a.b.b.a aVar = this.n;
            if (aVar != null) {
                aVar.a(this.f12633a);
            }
            this.u.a(str, new e.d() { // from class: sg.bigo.ads.ad.interstitial.a.a.b.2
                @Override // sg.bigo.ads.core.mraid.e.d
                public final void a() {
                    sg.bigo.ads.common.t.a.a(0, 3, "HtmlVastCompanion", "onReady");
                }
            });
            this.d = true;
            t.a();
        }
        sg.bigo.ads.core.mraid.c.C0899c c0899cB = this.u.b();
        this.h = c0899cB;
        if (c0899cB != null) {
            c0899cB.setOverScrollMode(2);
            this.h.setHorizontalScrollBarEnabled(false);
            this.h.setHorizontalScrollbarOverlay(false);
            this.h.setVerticalScrollBarEnabled(false);
            this.h.setVerticalScrollbarOverlay(false);
            this.h.getSettings().setSupportZoom(false);
            this.h.setBackgroundColor(-1);
            sg.bigo.ads.core.f.a.a.C0894a c0894a = this.q;
            if (c0894a != null) {
                i = c0894a.c;
                i2 = this.q.d;
            } else {
                i = 0;
                i2 = 0;
            }
            WebView webView = this.h;
            if (webView != null) {
                Object parent = webView.getParent();
                if (parent instanceof FrameLayout) {
                    this.i = (View) parent;
                    sg.bigo.ads.ad.banner.b.a(this);
                    Context context2 = webView.getContext();
                    int i3 = context2.getResources().getDisplayMetrics().widthPixels;
                    int iC = sg.bigo.ads.common.utils.e.c(context2);
                    if (sg.bigo.ads.common.utils.e.a(context2, i) > i3 || sg.bigo.ads.common.utils.e.a(context2, i2) > iC) {
                        i = 0;
                    }
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) webView.getLayoutParams();
                    if (i <= 0 || i2 <= 0) {
                        layoutParams.width = -1;
                        layoutParams.height = -1;
                    } else {
                        layoutParams.gravity = 17;
                        layoutParams.width = sg.bigo.ads.common.utils.e.a(context2, i);
                        layoutParams.height = sg.bigo.ads.common.utils.e.a(context2, i2);
                    }
                }
            }
            this.h.addJavascriptInterface(new a(this, b), "BGN_PLAYABLE");
        }
        return true;
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final boolean b() {
        if (this.o) {
            return this.c;
        }
        return false;
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final void c() {
        sg.bigo.ads.common.t.a.a(0, 3, "HtmlVastCompanion", "resume");
        e eVar = this.u;
        if (eVar != null) {
            eVar.d();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final void d() {
        sg.bigo.ads.common.t.a.a(0, 3, "HtmlVastCompanion", "pause");
        e eVar = this.u;
        if (eVar != null) {
            eVar.a(false);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final void e() {
        sg.bigo.ads.common.t.a.a(0, 3, "HtmlVastCompanion", "release");
        sg.bigo.ads.ad.banner.b.h(this);
        sg.bigo.ads.core.c.b bVar = this.f;
        if (bVar != null) {
            bVar.b();
        }
        e eVar = this.u;
        if (eVar != null) {
            eVar.e();
            this.u = null;
        }
        WebView webView = this.h;
        if (webView != null) {
            u.b(webView);
            this.h = null;
        }
        this.g = null;
    }

    @Override // sg.bigo.ads.ad.interstitial.a.b.a
    public final void f() {
        sg.bigo.ads.ad.interstitial.a.b.b.a aVar;
        if (this.j || this.k || this.l || (aVar = this.n) == null || this.e <= 0) {
            return;
        }
        aVar.d(this.f12633a, SystemClock.elapsedRealtime() - this.e);
    }
}
