package sg.bigo.ads.ad.banner;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.R;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.AdOptionsView;
import sg.bigo.ads.api.AdSize;
import sg.bigo.ads.api.BannerAdRequest;
import sg.bigo.ads.api.core.i;
import sg.bigo.ads.common.utils.q;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.core.mraid.n;

/* JADX INFO: loaded from: classes6.dex */
public final class c<T extends Ad> implements sg.bigo.ads.ad.banner.b.InterfaceC0816b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    WebView f12529a;
    b c;
    Runnable g;
    sg.bigo.ads.core.c.b h;
    g i;
    final T j;
    final i k;
    final boolean l;
    public WeakReference<Activity> n;
    public a o;
    AdOptionsView p;
    View q;
    boolean r;
    private sg.bigo.ads.core.mraid.e s;
    private View t;
    private final n u;
    private final Context w;
    private BannerAdRequest x;
    private AdSize y;
    public int b = 1;
    boolean d = false;
    boolean e = false;
    boolean f = false;
    private boolean v = false;
    private final View.OnAttachStateChangeListener z = new View.OnAttachStateChangeListener() { // from class: sg.bigo.ads.ad.banner.c.1
        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
            sg.bigo.ads.ad.banner.b.e(c.this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
            sg.bigo.ads.ad.banner.b.f(c.this);
            view.removeOnAttachStateChangeListener(this);
        }
    };
    final AtomicBoolean m = new AtomicBoolean(false);

    public interface a {
        void a(int i, int i2);
    }

    static class b implements sg.bigo.ads.api.b.a.InterfaceC0855a {
        private sg.bigo.ads.api.b.a.InterfaceC0855a c;
        private boolean b = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Handler f12539a = new Handler();

        b(sg.bigo.ads.api.b.a.InterfaceC0855a interfaceC0855a) {
            this.c = interfaceC0855a;
        }

        private boolean c() {
            if (this.b) {
                return true;
            }
            this.f12539a.removeCallbacks(null);
            this.b = true;
            return false;
        }

        final void a() {
            a(new sg.bigo.ads.api.core.d(3001, 10102, "Adx media load error because of destroying before loaded"));
        }

        @Override // sg.bigo.ads.api.b.a.InterfaceC0855a
        public final void a(sg.bigo.ads.api.core.d dVar) {
            sg.bigo.ads.api.b.a.InterfaceC0855a interfaceC0855a;
            if (c() || (interfaceC0855a = this.c) == null) {
                return;
            }
            interfaceC0855a.a(dVar);
        }

        @Override // sg.bigo.ads.api.b.a.InterfaceC0855a
        public final void b() {
            sg.bigo.ads.api.b.a.InterfaceC0855a interfaceC0855a;
            if (c() || (interfaceC0855a = this.c) == null) {
                return;
            }
            interfaceC0855a.b();
        }
    }

    public c(Context context, sg.bigo.ads.api.core.g gVar, T t, i iVar, n nVar, g gVar2, boolean z) {
        this.w = context;
        this.j = t;
        this.k = iVar;
        this.u = nVar;
        this.i = gVar2;
        this.l = z;
        if (gVar == null || !(gVar.c instanceof BannerAdRequest)) {
            return;
        }
        this.x = (BannerAdRequest) gVar.c;
    }

    static /* synthetic */ View a(c cVar, View view) {
        LinearLayout linearLayout = new LinearLayout(cVar.w);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        if (view != null) {
            linearLayout.addView(view);
        }
        if (!q.a((CharSequence) cVar.k.l())) {
            if (cVar.p == null) {
                cVar.p = new AdOptionsView(cVar.w);
            }
            AdOptionsView adOptionsView = cVar.p;
            i iVar = cVar.k;
            adOptionsView.a(iVar, iVar.l());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(sg.bigo.ads.common.utils.e.a(cVar.w, 16), sg.bigo.ads.common.utils.e.a(cVar.w, 16), 8388659);
            layoutParams.leftMargin = sg.bigo.ads.common.utils.e.a(cVar.w, 10);
            cVar.p.setLayoutParams(layoutParams);
            linearLayout.addView(cVar.p);
        }
        return linearLayout;
    }

    static TextView a(Context context, boolean z) {
        if (!z) {
            return null;
        }
        TextView textView = new TextView(context);
        textView.setText(sg.bigo.ads.common.utils.a.a(context, R.string.bigo_ad_tag, new Object[0]));
        textView.setBackgroundResource(R.drawable.bigo_ad_bg_ad_tag_white_border);
        textView.setTextColor(q.b("#B2FFFFFF", -1));
        textView.setTextSize(9.0f);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setPadding(sg.bigo.ads.common.utils.e.a(context, 3), sg.bigo.ads.common.utils.e.a(context, 1), sg.bigo.ads.common.utils.e.a(context, 3), sg.bigo.ads.common.utils.e.a(context, 1));
        return textView;
    }

    static TextView a(Context context, boolean z, String str) {
        if (!z || q.a((CharSequence) str)) {
            return null;
        }
        TextView textView = new TextView(context);
        textView.setText(str);
        textView.setBackgroundResource(R.drawable.bigo_ad_banner_advertiser_background);
        textView.setTextColor(-1);
        textView.setTextSize(9.0f);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setMaxWidth(sg.bigo.ads.common.utils.e.a(context, 240));
        textView.setBackgroundColor(q.b("#FFD6D9DB", -7829368));
        textView.setPadding(sg.bigo.ads.common.utils.e.a(context, 4), sg.bigo.ads.common.utils.e.a(context, 1), sg.bigo.ads.common.utils.e.a(context, 4), sg.bigo.ads.common.utils.e.a(context, 1));
        return textView;
    }

    private void a(FrameLayout.LayoutParams layoutParams, int i, int i2) {
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.gravity = 17;
        this.t.setMinimumHeight(i2);
    }

    /* JADX WARN: Code duplicated, block: B:115:0x0236  */
    /* JADX WARN: Code duplicated, block: B:118:0x0246 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:119:0x0248  */
    /* JADX WARN: Code duplicated, block: B:120:0x024d  */
    /* JADX WARN: Code duplicated, block: B:122:0x0250  */
    /* JADX WARN: Code duplicated, block: B:123:0x0255  */
    /* JADX WARN: Code duplicated, block: B:126:0x0266  */
    /* JADX WARN: Code duplicated, block: B:131:0x02af  */
    /* JADX WARN: Code duplicated, block: B:134:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:139:0x02be  */
    /* JADX WARN: Code duplicated, block: B:140:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:144:0x02e8  */
    /* JADX WARN: Code duplicated, block: B:146:0x02ee  */
    /* JADX WARN: Code duplicated, block: B:147:0x02f4  */
    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: sg.bigo.ads.core.h.a.1.<init>(sg.bigo.ads.core.h.a, android.content.Context):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:224)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:93)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    private boolean c(final sg.bigo.ads.api.b.a.InterfaceC0855a r13) {
        /*
            Method dump skipped, instruction units count: 800
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.ad.banner.c.c(sg.bigo.ads.api.b.a$a):boolean");
    }

    public final void a() {
        if (sg.bigo.ads.common.n.d.b()) {
            b();
        } else {
            sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.ad.banner.c.4
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.b();
                }
            });
        }
    }

    public final void a(final sg.bigo.ads.api.b.a.InterfaceC0855a interfaceC0855a) {
        sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.ad.banner.c.3
            @Override // java.lang.Runnable
            public final void run() {
                if (c.this.b != 0) {
                    if (c.this.b(interfaceC0855a)) {
                        return;
                    }
                    interfaceC0855a.a(new sg.bigo.ads.api.core.d(3001, 10102, "Adx media load error when preload"));
                    return;
                }
                if (c.this.c != null) {
                    c.this.c.a();
                }
                c.this.c = new b(interfaceC0855a);
                final b bVar = c.this.c;
                bVar.f12539a.postDelayed(new Runnable() { // from class: sg.bigo.ads.ad.banner.c.b.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.this.b();
                    }
                }, 15000L);
                c cVar = c.this;
                if (cVar.b(cVar.c)) {
                    return;
                }
                c.this.c.a(new sg.bigo.ads.api.core.d(3001, 10102, "Adx media load error when preload"));
            }
        });
    }

    final void b() {
        try {
            sg.bigo.ads.ad.banner.b.h(this);
            sg.bigo.ads.core.c.b bVar = this.h;
            if (bVar != null) {
                bVar.b();
            }
            b bVar2 = this.c;
            if (bVar2 != null) {
                bVar2.a();
            }
            if (this.g != null) {
                this.g = null;
            }
            sg.bigo.ads.core.mraid.e eVar = this.s;
            if (eVar != null) {
                eVar.e();
                this.s = null;
            }
            View view = this.t;
            if (view != null) {
                view.removeOnAttachStateChangeListener(this.z);
                this.t = null;
            }
            WebView webView = this.f12529a;
            if (webView != null) {
                u.b(webView);
                this.f12529a = null;
            }
        } catch (Throwable unused) {
        }
    }

    public final boolean b(sg.bigo.ads.api.b.a.InterfaceC0855a interfaceC0855a) {
        if (this.r) {
            return true;
        }
        boolean zC = c(interfaceC0855a);
        this.r = zC;
        return zC;
    }

    public final View c() {
        if (this.t == null) {
            sg.bigo.ads.common.t.a.a(2, "BannerAd", "The banner ad is not ready, an empty view will be retrieved.");
            this.t = new FrameLayout(this.w);
        }
        sg.bigo.ads.ad.banner.b.d(this);
        this.t.addOnAttachStateChangeListener(this.z);
        return this.t;
    }

    public final String d() {
        i iVar = this.k;
        return iVar != null ? iVar.z() : "";
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0053 A[PHI: r0 r1
  0x0053: PHI (r0v11 android.app.Activity) = (r0v6 android.app.Activity), (r0v13 android.app.Activity) binds: [B:37:0x0094, B:21:0x0051] A[DONT_GENERATE, DONT_INLINE]
  0x0053: PHI (r1v3 T extends sg.bigo.ads.api.Ad) = (r1v1 T extends sg.bigo.ads.api.Ad), (r1v6 T extends sg.bigo.ads.api.Ad) binds: [B:37:0x0094, B:21:0x0051] A[DONT_GENERATE, DONT_INLINE]] */
    final Context e() {
        Activity activityB;
        T t;
        String str;
        WeakReference<Activity> weakReference = this.n;
        if (weakReference == null || (activityB = weakReference.get()) == null) {
            activityB = null;
        } else {
            sg.bigo.ads.common.t.a.a(0, 3, "BannerAd", "Interstitial/Reward Video banner ad get activity context from show(Activity activity).");
            T t2 = this.j;
            if (t2 instanceof sg.bigo.ads.ad.c) {
                ((sg.bigo.ads.ad.c) t2).b(1);
            }
        }
        if (activityB == null) {
            sg.bigo.ads.api.a.h hVar = sg.bigo.ads.api.a.i.f13093a;
            if (this.u == n.INTERSTITIAL) {
                if (hVar != null && hVar.n().a(16)) {
                    activityB = sg.bigo.ads.common.f.b.b();
                    if (activityB == null) {
                        str = "Interstitial/Reward Video banner ad failed to get activity context.";
                        sg.bigo.ads.common.t.a.a(0, "BannerAd", str);
                    } else {
                        sg.bigo.ads.common.t.a.a(0, 3, "BannerAd", "Interstitial/Reward Video banner ad get activity context from current activity.");
                        t = this.j;
                        if (t instanceof sg.bigo.ads.ad.c) {
                            ((sg.bigo.ads.ad.c) t).b(2);
                        }
                    }
                }
            } else if (hVar != null && hVar.n().a(17)) {
                try {
                    Activity activityA = sg.bigo.ads.common.utils.c.a(this.t);
                    if (activityA != null) {
                        try {
                            sg.bigo.ads.common.t.a.a(0, 3, "BannerAd", "Banner ad get activity context from view.");
                            T t3 = this.j;
                            if (t3 instanceof sg.bigo.ads.ad.c) {
                                ((sg.bigo.ads.ad.c) t3).b(3);
                            }
                        } catch (Exception unused) {
                        }
                        activityB = activityA;
                    }
                } catch (Exception unused2) {
                }
                if (activityB == null) {
                    activityB = sg.bigo.ads.common.f.b.b();
                    if (activityB == null) {
                        str = "Banner ad failed to get activity context.";
                        sg.bigo.ads.common.t.a.a(0, "BannerAd", str);
                    } else {
                        sg.bigo.ads.common.t.a.a(0, 3, "BannerAd", "Banner ad get activity context from current activity.");
                        t = this.j;
                        if (t instanceof sg.bigo.ads.ad.c) {
                            ((sg.bigo.ads.ad.c) t).b(2);
                        }
                    }
                }
            }
        }
        return activityB == null ? this.w : activityB;
    }

    public final void f() {
        sg.bigo.ads.common.t.a.a(0, 3, "BannerAd", "performImpression");
        sg.bigo.ads.ad.banner.b.g(this);
        T t = this.j;
        if (t instanceof e) {
            ((e) t).a(sg.bigo.ads.ad.banner.b.i(this));
        }
        if (this.d) {
            return;
        }
        this.d = true;
        if (this.e) {
            h();
            g();
            sg.bigo.ads.core.c.b bVar = this.h;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    final void g() {
        if (this.f12529a != null) {
            sg.bigo.ads.common.t.a.a(0, 3, "BannerAd", "javascript:onViewImpression()");
            this.f12529a.loadUrl("javascript:onViewImpression()");
        }
    }

    final void h() {
        final WebView webView = this.f12529a;
        if (this.v || !(webView instanceof sg.bigo.ads.core.h.b)) {
            return;
        }
        this.v = true;
        sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.ad.banner.c.2
            @Override // java.lang.Runnable
            public final void run() {
                sg.bigo.ads.core.h.b.C0896b c0896b;
                long j;
                long jA;
                long j2;
                long jA2;
                long j3;
                sg.bigo.ads.common.t.a.a(0, 3, "BannerAd", "Notify webView performance stat.");
                sg.bigo.ads.core.h.b bVar = (sg.bigo.ads.core.h.b) webView;
                if (sg.bigo.ads.api.a.i.f13093a.n().a(0) || sg.bigo.ads.api.a.i.f13093a.n().a(1)) {
                    sg.bigo.ads.core.h.b.C0896b c0896b2 = bVar.h;
                    sg.bigo.ads.core.h.b.a(c0896b2);
                    if (sg.bigo.ads.api.a.i.f13093a.n().a(1)) {
                        if (bVar.i == null) {
                            bVar.i = new sg.bigo.ads.core.h.b.c(bVar, (byte) 0);
                        }
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        c0896b2.d = bVar.i.a();
                        c0896b2.g = SystemClock.elapsedRealtime() - jElapsedRealtime;
                        c0896b2.f = SystemClock.elapsedRealtime();
                    }
                    c0896b = c0896b2;
                } else {
                    c0896b = null;
                }
                if (c0896b != null) {
                    if (c0896b.c == null && c0896b.d == null) {
                        return;
                    }
                    Boolean bool = c0896b.c;
                    Boolean bool2 = c0896b.d;
                    if (bool != null) {
                        long j4 = bool.booleanValue() ? 1L : 0L;
                        jA = sg.bigo.ads.ad.banner.b.a(c.this, c0896b.e);
                        j = j4;
                    } else {
                        j = -1;
                        jA = -1;
                    }
                    if (bool2 != null) {
                        long j5 = bool2.booleanValue() ? 1L : 0L;
                        long j6 = c0896b.g;
                        jA2 = sg.bigo.ads.ad.banner.b.a(c.this, c0896b.f);
                        j2 = j5;
                        j3 = j6;
                    } else {
                        j2 = -1;
                        jA2 = -1;
                        j3 = -1;
                    }
                    sg.bigo.ads.common.t.a.a(0, 3, "BannerAd", "Stat check blank resutl.");
                    sg.bigo.ads.core.d.b.a(c.this.k, j, jA, j2, jA2, j3);
                }
            }
        });
    }

    final AdSize i() {
        if (this.y == null) {
            BannerAdRequest bannerAdRequest = this.x;
            if (bannerAdRequest != null && bannerAdRequest.h != null) {
                for (AdSize adSize : this.x.h) {
                    if (!adSize.f13083a.equals(AdSize.ADAPTIVE)) {
                        this.y = adSize;
                        break;
                    }
                }
            }
            if (this.y == null) {
                Context context = this.w;
                this.y = sg.bigo.ads.common.utils.e.c(context, context.getResources().getDisplayMetrics().widthPixels) > 720 ? AdSize.LEADERBOARD : AdSize.BANNER;
            }
        }
        return this.y;
    }
}
