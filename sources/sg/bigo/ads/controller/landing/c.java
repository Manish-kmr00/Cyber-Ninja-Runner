package sg.bigo.ads.controller.landing;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import android.text.TextUtils;
import android.transition.Fade;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import android.webkit.WebView;
import com.pubmatic.sdk.common.POBCommonConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import sg.bigo.ads.api.b.f;
import sg.bigo.ads.api.core.e;
import sg.bigo.ads.common.u.g;
import sg.bigo.ads.common.utils.q;
import sg.bigo.ads.common.utils.r;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.core.landing.WebViewActivityImpl;

/* JADX INFO: loaded from: classes8.dex */
public class c extends WebViewActivityImpl implements f {
    private final boolean A;
    private final boolean B;
    private final int C;
    private final ValueCallback<Boolean> D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f13482a;
    private String b;
    private long c;
    private int d;
    private int e;
    private boolean f;
    private sg.bigo.ads.ad.c<?, ?> g;
    private sg.bigo.ads.api.core.c h;
    private final int i;
    private final long j;
    private sg.bigo.ads.controller.landing.a k;
    private boolean l;
    private final int m;
    private final List<f.a> n;
    private int o;
    private int p;
    private int q;
    private final String y;
    private WebHistoryItem z;

    static class a implements f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f13485a;
        private final long b;

        private a(int i, long j) {
            this.f13485a = i;
            this.b = System.currentTimeMillis() - j;
        }

        /* synthetic */ a(int i, long j, byte b) {
            this(i, j);
        }

        @Override // sg.bigo.ads.api.b.f.a
        public final int a() {
            return this.f13485a;
        }

        @Override // sg.bigo.ads.api.b.f.a
        public final long b() {
            return this.b;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x008d. Please report as an issue. */
    public c(Activity activity) {
        int intExtra;
        int i;
        super(activity);
        this.f13482a = 300;
        this.c = -1L;
        this.d = 0;
        this.f = false;
        this.n = new ArrayList();
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.D = new ValueCallback<Boolean>() { // from class: sg.bigo.ads.controller.landing.c.1
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(Boolean bool) {
                Boolean bool2 = bool;
                if (c.this.t != null) {
                    if (bool2 == null || !bool2.booleanValue()) {
                        ViewParent parent = c.this.t.getParent();
                        if (parent instanceof ViewGroup) {
                            TransitionSet transitionSet = new TransitionSet();
                            transitionSet.addTransition(new Fade(1));
                            transitionSet.setDuration(300L);
                            TransitionManager.beginDelayedTransition((ViewGroup) parent, transitionSet);
                        }
                    }
                    c.this.t.setEnabled(true);
                    c.this.t.setVisibility(0);
                }
            }
        };
        Intent intent = this.I.getIntent();
        int i2 = -1;
        if (intent != null) {
            int intExtra2 = intent.getIntExtra("ad_identifier", -1);
            this.m = intent.getIntExtra("land_way", -1);
            intExtra = intent.getIntExtra("webview_force_time", -1);
            i2 = intExtra2;
        } else {
            this.m = -1;
            intExtra = -1;
        }
        sg.bigo.ads.ad.c<?, ?> cVarB = d.b(i2);
        this.g = cVarB;
        if (cVarB != null) {
            this.h = cVarB.f();
            this.i = this.g.q();
            this.j = this.g.r();
            this.k = this.g.l;
            this.b = this.h.N().e();
            this.e = this.h.d().f();
        } else {
            this.i = 0;
            this.j = System.currentTimeMillis();
        }
        switch (intExtra) {
            case -1:
                this.A = false;
                this.B = false;
                this.C = 0;
                break;
            case 0:
            default:
                this.A = true;
                this.B = false;
                this.C = 0;
                break;
            case 1:
            case 2:
            case 3:
            case 4:
                this.A = false;
                this.B = true;
                i = intExtra + 1;
                this.C = i;
                break;
            case 5:
            case 6:
            case 7:
            case 8:
                this.A = true;
                this.B = false;
                i = intExtra - 3;
                this.C = i;
                break;
        }
        this.y = a(activity);
    }

    private static String a(Activity activity) {
        try {
            String packageName = activity.getPackageName();
            String str = activity.getPackageManager().getActivityInfo(activity.getComponentName(), 0).taskAffinity;
            if (TextUtils.equals(packageName, str)) {
                return null;
            }
            return str;
        } catch (PackageManager.NameNotFoundException | Exception unused) {
        }
    }

    private void c(int i) {
        a aVar = new a(i, this.j, (byte) 0);
        this.n.add(0, aVar);
        sg.bigo.ads.api.core.c cVar = this.h;
        if (cVar != null) {
            sg.bigo.ads.core.d.b.a(this, aVar, cVar, this.g, this.y);
        }
    }

    private void g(int i) {
        if (i <= 0) {
            this.D.onReceiveValue(Boolean.TRUE);
        } else if (this.v != null) {
            this.v.postDelayed(new Runnable() { // from class: sg.bigo.ads.controller.landing.c.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (c.this.D != null) {
                        c.this.D.onReceiveValue(Boolean.FALSE);
                    }
                }
            }, r.f13300a.a(i));
        }
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl, sg.bigo.ads.api.core.BaseAdActivityImpl
    public final void D() {
        super.D();
        sg.bigo.ads.controller.landing.a aVar = this.k;
        if (aVar != null) {
            aVar.d = false;
            this.k = null;
        }
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl, sg.bigo.ads.api.core.BaseAdActivityImpl
    public final void N() {
        this.c = SystemClock.elapsedRealtime();
        c(1);
        super.N();
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl, sg.bigo.ads.api.core.BaseAdActivityImpl
    public void X() {
        super.X();
        if (this.g != null) {
            d.a();
            this.g = null;
        }
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl
    public void a() {
        super.a();
        if (this.A) {
            g(this.C);
        }
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl
    public final void a(int i, String str, String str2) {
        super.a(i, str, str2);
        if (this.f) {
            return;
        }
        c(6);
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl
    public void a(String str, boolean z) {
        super.a(str, z);
        if (z) {
            c(4);
        }
        if (this.d == 0) {
            this.w = str;
        }
        this.d++;
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl
    public final void a(e eVar) {
        sg.bigo.ads.api.core.c cVar = this.h;
        if (cVar != null) {
            sg.bigo.ads.core.d.b.a(cVar, 2, eVar, this.g);
        }
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl
    public void b(String str) {
        super.b(str);
        if (!this.f) {
            this.p = 100;
            c(5);
            if (this.B) {
                g(this.C);
            }
        }
        this.f = true;
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl
    public final void c(String str) {
        super.c(str);
        this.q++;
        this.o = !URLUtil.isNetworkUrl(str) ? 1 : 0;
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl
    public final String d(String str) {
        sg.bigo.ads.api.core.c cVar = this.h;
        return cVar != null ? sg.bigo.ads.core.landing.a.a(cVar.N().h(), this.h.N().i(), str) : super.d(str);
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl
    public void d() {
        super.d();
        if (this.t != null) {
            if (this.A || this.B) {
                this.t.setVisibility(4);
                this.t.setEnabled(false);
            }
        }
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl
    public final void d(int i) {
        if (r()) {
            return;
        }
        super.d(i);
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl
    public final void e(int i) {
        super.e(i);
        String str = this.b;
        if (!TextUtils.isEmpty(str)) {
            sg.bigo.ads.common.u.b.a aVar = new sg.bigo.ads.common.u.b.a(sg.bigo.ads.common.y.a.a(), new sg.bigo.ads.common.u.b.d(str), this.I);
            aVar.k = sg.bigo.ads.common.u.a.e.a();
            g.a(aVar, null);
        }
        if (this.h != null) {
            sg.bigo.ads.core.d.b.a(this, this.n.isEmpty() ? null : this.n.get(0), System.currentTimeMillis() - this.j, this.d, this.h, this.g, this.y);
        }
    }

    public int f() {
        return 0;
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl
    public final void f(int i) {
        super.f(i);
        this.p = Math.max(this.p, i);
    }

    @Override // sg.bigo.ads.api.b.f
    public final String g() {
        return this.w;
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl, sg.bigo.ads.api.core.BaseAdActivityImpl
    public final void g(boolean z) {
        if (z) {
            ao();
        }
    }

    @Override // sg.bigo.ads.api.b.f
    public final int h() {
        return this.o;
    }

    @Override // sg.bigo.ads.api.b.f
    public final int i() {
        return this.q;
    }

    @Override // sg.bigo.ads.api.b.f
    public final int j() {
        return this.p;
    }

    @Override // sg.bigo.ads.api.b.f
    public final boolean k() {
        sg.bigo.ads.controller.landing.a aVar = this.k;
        return aVar != null && aVar.d;
    }

    @Override // sg.bigo.ads.api.b.f
    public final int l() {
        return this.i;
    }

    @Override // sg.bigo.ads.api.b.f
    public final int m() {
        return this.m;
    }

    @Override // sg.bigo.ads.api.b.f
    public final Map<String, String> n() {
        return null;
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl
    public final WebView o() {
        sg.bigo.ads.controller.landing.a aVar = this.k;
        sg.bigo.ads.core.h.e eVar = null;
        if (aVar != null && aVar.b() && aVar.f != null) {
            u.b(aVar.f);
            sg.bigo.ads.core.h.e eVar2 = aVar.f;
            aVar.f = null;
            eVar = eVar2;
        }
        if (eVar == null) {
            return super.o();
        }
        this.l = true;
        return eVar;
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl
    public final void p() {
        c(2);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0077  */
    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl
    public final void q() {
        sg.bigo.ads.api.core.c cVar;
        if (this.v == null) {
            return;
        }
        sg.bigo.ads.controller.landing.a aVar = this.k;
        if (aVar == null) {
            cVar = this.h;
            if (cVar != null) {
                this.w = sg.bigo.ads.core.landing.a.a(cVar.N().h(), this.h.N().i(), this.w);
            }
            super.q();
        } else if (aVar.c == 2 && !q.a((CharSequence) this.k.e)) {
            this.v.loadDataWithBaseURL(this.w, this.k.e, POBCommonConstants.CONTENT_TYPE_HTML, "UTF-8", null);
        } else {
            if (this.k.c == 3 && this.l) {
                this.x = SystemClock.elapsedRealtime();
                a(this.v.getTitle());
                if (this.k.d) {
                    if (this.s != null) {
                        this.s.setAlpha(0.0f);
                    }
                    b(this.w);
                    return;
                }
                return;
            }
            if (this.k.c == 4 && this.l) {
                this.z = this.v.copyBackForwardList().getCurrentItem();
            }
            cVar = this.h;
            if (cVar != null) {
                this.w = sg.bigo.ads.core.landing.a.a(cVar.N().h(), this.h.N().i(), this.w);
            }
            super.q();
        }
        c(3);
    }

    public final boolean r() {
        int i;
        if (this.A || this.B) {
            return (this.t == null || this.t.isEnabled()) ? false : true;
        }
        if (!this.f && (i = this.e) > 0 && i <= 10000) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.c;
            if (jElapsedRealtime > 0 && jElapsedRealtime < i) {
                return true;
            }
        }
        return false;
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl
    public final boolean s() {
        if (this.v == null) {
            return false;
        }
        if (this.z != null) {
            WebBackForwardList webBackForwardListCopyBackForwardList = this.v.copyBackForwardList();
            int currentIndex = webBackForwardListCopyBackForwardList.getCurrentIndex();
            if (currentIndex <= 0) {
                return super.s();
            }
            WebHistoryItem itemAtIndex = webBackForwardListCopyBackForwardList.getItemAtIndex(currentIndex - 1);
            if (itemAtIndex != null) {
                return (TextUtils.equals(this.z.getOriginalUrl(), itemAtIndex.getOriginalUrl()) || TextUtils.equals(this.z.getUrl(), itemAtIndex.getUrl())) ? false : true;
            }
        }
        return super.s();
    }
}
