package sg.bigo.ads.ad;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import net.pubnative.lite.sdk.analytics.Reporting;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.AdActivity;
import sg.bigo.ads.api.AdBid;
import sg.bigo.ads.api.AdError;
import sg.bigo.ads.api.AdInteractionListener;
import sg.bigo.ads.api.core.c;
import sg.bigo.ads.api.core.e;
import sg.bigo.ads.api.core.g;
import sg.bigo.ads.api.core.r;
import sg.bigo.ads.common.i;
import sg.bigo.ads.common.utils.q;
import sg.bigo.ads.controller.landing.LandingPageStyleConfig;

/* JADX INFO: loaded from: classes4.dex */
public abstract class c<T extends Ad, U extends sg.bigo.ads.api.core.c> extends sg.bigo.ads.api.b.a<T, U> implements sg.bigo.ads.common.f.b.a {
    private final Set<String> A;
    private final Set<String> B;
    private final Map<String, Object> C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected AdInteractionListener f12554a;
    public g b;
    protected View c;
    public sg.bigo.ads.core.e.a.a d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    protected long j;
    public long k;
    public sg.bigo.ads.controller.landing.a l;
    protected int m;
    protected int n;
    public int o;
    protected boolean p;
    public int q;
    public long r;
    public long s;
    public WeakReference<a> t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private long y;
    private AdBid z;

    public interface a {
        LandingPageStyleConfig a(Context context, String str, int i, boolean z);

        boolean a();
    }

    public c(g gVar) {
        super(gVar.c);
        this.e = false;
        this.u = false;
        this.f = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.g = false;
        this.h = false;
        this.i = false;
        this.A = new HashSet();
        this.B = new HashSet();
        this.p = false;
        this.q = -1;
        this.r = 0L;
        this.s = 0L;
        this.C = new HashMap();
        this.b = gVar;
        x();
        y();
        this.Q = new sg.bigo.ads.common.v.a();
    }

    private long A() {
        sg.bigo.ads.api.core.c.a aVarO = this.b.f13106a.O();
        if (aVarO != null) {
            return aVarO.b();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        try {
            sg.bigo.ads.controller.landing.a aVar = this.l;
            if (aVar != null) {
                aVar.a();
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean a(c cVar) {
        return cVar == null || cVar.h;
    }

    private void b(i iVar, int i, int i2, e eVar) {
        this.o = i;
        if (!this.w && !this.h) {
            this.w = true;
            a(iVar != null ? iVar.b : null, i, i2, eVar);
        }
        c(iVar, i, i2, eVar);
        AdInteractionListener adInteractionListener = this.f12554a;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
    }

    private void c(i iVar, int i, int i2, e eVar) {
        long jElapsedRealtime = this.j > 0 ? SystemClock.elapsedRealtime() - this.j : 0L;
        String strB = iVar != null ? iVar.b() : "";
        String strA = iVar != null ? iVar.a() : "";
        if (a("06002011")) {
            Context context = this.b.e;
            sg.bigo.ads.api.core.c cVar = this.b.f13106a;
            String strI = i();
            int i3 = eVar.f13102a;
            int i4 = eVar.g;
            int i5 = this.m + 1;
            this.m = i5;
            int i6 = this.n + 1;
            this.n = i6;
            sg.bigo.ads.core.d.b.a(context, cVar, strI, strB, strA, i, i2, i3, i4, jElapsedRealtime, i5, i6, this);
        }
    }

    private void d(String str) {
        if (this.A.contains(str)) {
            sg.bigo.ads.common.t.a.a(0, 3, "Ad", "ignore callback action, action = ".concat(String.valueOf(str)));
            return;
        }
        sg.bigo.ads.api.core.c cVarF = f();
        Map<String, Object> mapA = sg.bigo.ads.core.b.a.a(str, this.b.b, this.P, cVarF, Integer.valueOf(cVarF.aj()), null, null, this);
        str.hashCode();
        if (str.equals("impression") || str.equals(Reporting.EventType.VIDEO_AD_CLICKED)) {
            mapA.put(Reporting.Key.AD_SIZE, i());
            mapA.put("show_proportion", b("show_proportion", ""));
            mapA.put("render_style", b("render_style", 0));
        }
        sg.bigo.ads.core.b.b.a().a(str, mapA);
    }

    private void x() {
        sg.bigo.ads.api.core.c cVar = this.b.f13106a;
        r rVarM = sg.bigo.ads.api.a.i.f13093a.m();
        sg.bigo.ads.api.core.c.f[] fVarArrC = cVar.C();
        sg.bigo.ads.core.e.a.d[] dVarArr = new sg.bigo.ads.core.e.a.d[0];
        if (fVarArrC != null && fVarArrC.length > 0) {
            dVarArr = new sg.bigo.ads.core.e.a.d[fVarArrC.length];
            for (int i = 0; i < fVarArrC.length; i++) {
                dVarArr[i] = new sg.bigo.ads.core.e.a.d(fVarArrC[i].a(), this.b.d);
            }
        }
        sg.bigo.ads.api.core.c.f[] fVarArrD = cVar.D();
        sg.bigo.ads.core.e.a.d[] dVarArr2 = new sg.bigo.ads.core.e.a.d[0];
        if (fVarArrD != null && fVarArrD.length > 0) {
            dVarArr2 = new sg.bigo.ads.core.e.a.d[fVarArrD.length];
            for (int i2 = 0; i2 < fVarArrD.length; i2++) {
                dVarArr2[i2] = new sg.bigo.ads.core.e.a.d(fVarArrD[i2].a(), this.b.d);
            }
        }
        sg.bigo.ads.api.core.c.f[] fVarArrE = cVar.E();
        sg.bigo.ads.core.e.a.d[] dVarArr3 = new sg.bigo.ads.core.e.a.d[0];
        if (fVarArrE != null && fVarArrE.length > 0) {
            dVarArr3 = new sg.bigo.ads.core.e.a.d[fVarArrE.length];
            for (int i3 = 0; i3 < fVarArrE.length; i3++) {
                dVarArr3[i3] = new sg.bigo.ads.core.e.a.d(fVarArrE[i3].a(), this.b.d);
            }
        }
        sg.bigo.ads.api.core.c.f[] fVarArrF = cVar.F();
        sg.bigo.ads.core.e.a.d[] dVarArr4 = new sg.bigo.ads.core.e.a.d[0];
        if (fVarArrF != null && fVarArrF.length > 0) {
            dVarArr4 = new sg.bigo.ads.core.e.a.d[fVarArrF.length];
            for (int i4 = 0; i4 < fVarArrF.length; i4++) {
                dVarArr4[i4] = new sg.bigo.ads.core.e.a.d(fVarArrF[i4].a(), this.b.d);
            }
        }
        sg.bigo.ads.core.e.a.a aVar = new sg.bigo.ads.core.e.a.a(rVarM, dVarArr, dVarArr2, dVarArr3, dVarArr4, sg.bigo.ads.core.d.b.c(this.b.f13106a, this));
        this.d = aVar;
        aVar.b("express_id", cVar.ab());
    }

    private void y() {
        this.e = false;
        this.u = false;
        this.f = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.g = false;
        this.h = false;
        this.j = 0L;
        this.k = 0L;
        this.z = null;
        this.i = false;
        this.T = 0;
    }

    private int z() {
        sg.bigo.ads.api.core.c.a aVarO = this.b.f13106a.O();
        if (aVarO != null) {
            return aVarO.a();
        }
        return 0;
    }

    public void a() {
        x();
        y();
    }

    @Override // sg.bigo.ads.api.b.a
    public final void a(int i, int i2, String str) {
        if (this.f) {
            return;
        }
        this.f = true;
        this.b.c.g.b();
        if (!this.b.f13106a.ah() && a("06002008")) {
            sg.bigo.ads.core.d.b.a(this, i, i2, str);
        }
    }

    public final void a(int i, String str) {
        sg.bigo.ads.common.t.a.a(2, 5, "", "onAdError: (" + i + ") " + str);
        AdError adError = new AdError(i, str);
        sg.bigo.ads.core.d.b.a(this.b.f13106a, adError, n());
        AdInteractionListener adInteractionListener = this.f12554a;
        if (adInteractionListener != null) {
            adInteractionListener.onAdError(adError);
        }
    }

    @Override // sg.bigo.ads.common.f.b.a
    public final void a(Activity activity) {
        Intent intent;
        if (activity != null && (activity instanceof AdActivity) && (intent = activity.getIntent()) != null && intent.getIntExtra("ad_identifier", -1) == hashCode() && intent.getBooleanExtra("create_error_flag", false)) {
            String stringExtra = intent.getStringExtra("create_error_msg");
            a(2005, "Activity create error");
            sg.bigo.ads.core.d.b.a(f(), 3000, 10117, stringExtra);
        }
    }

    protected void a(Point point, int i, int i2, e eVar) {
        int i3;
        int i4;
        int width;
        int height;
        String str;
        m();
        this.d.b(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE, String.valueOf(eVar.f13102a));
        sg.bigo.ads.core.e.a.a aVar = this.d;
        final boolean zA = false;
        if (point != null) {
            i4 = point.x;
            i3 = point.y;
        } else {
            i3 = 0;
            i4 = 0;
        }
        View view = this.c;
        if (view != null) {
            width = view.getWidth();
            height = this.c.getHeight();
        } else {
            width = 0;
            height = 0;
        }
        float fFloatValue = width > 0 ? new BigDecimal(i4 / width).setScale(3, 4).floatValue() : 0.0f;
        float fFloatValue2 = height > 0 ? new BigDecimal(i3 / height).setScale(3, 4).floatValue() : 0.0f;
        if (i2 == 1 || i2 == 2) {
            str = DevicePublicKeyStringDef.DIRECT;
        } else {
            str = i2 == 3 ? "confirm" : "unknown";
        }
        aVar.b("click_prop", q.e(q.a("{'x':%d,'y':%d,'ad_w':%d,'ad_h':%d,'x_r':%s,'y_r':%s,'mode':'%s'}", Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(width), Integer.valueOf(height), Float.valueOf(fFloatValue), Float.valueOf(fFloatValue2), str)));
        this.d.b("click_source", String.valueOf(i2));
        this.d.b("click_module", String.valueOf(i));
        int i5 = eVar.f13102a;
        if (i5 == 1) {
            zA = this.b.f13106a.a(4);
        } else if (i5 == 4) {
            zA = this.b.f13106a.a(8);
        }
        final sg.bigo.ads.core.e.a.a aVar2 = this.d;
        final Context context = this.b.e;
        sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.core.e.a.a.1

            /* JADX INFO: renamed from: a */
            final /* synthetic */ Context f13554a;
            final /* synthetic */ boolean b;

            public AnonymousClass1() {
                context = context;
                z = zA;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a.this.b(context, z);
            }
        });
        sg.bigo.ads.core.d.b.a(this.b.f13106a, 1, eVar, this);
    }

    public final synchronized void a(String str, Object obj) {
        this.C.put(str, obj);
    }

    public void a(sg.bigo.ads.api.b.a aVar) {
        this.S = aVar;
        if (this.S != null) {
            HashMap map = new HashMap();
            sg.bigo.ads.core.d.b.a((Map<String, String>) map, (sg.bigo.ads.api.b.a) this, false);
            this.d.a(map);
        }
    }

    public void a(sg.bigo.ads.api.b.d.a<T> aVar) {
    }

    public final void a(i iVar, int i, int i2, e eVar) {
        if (isExpired() || this.h) {
            return;
        }
        if (z() != 2 || (n() && SystemClock.elapsedRealtime() - this.j >= A())) {
            b(iVar, i, i2, eVar);
        }
    }

    public final void a(i iVar, e eVar) {
        a(iVar, 0, 1, eVar);
    }

    protected final boolean a(String str) {
        return !this.B.contains(str);
    }

    public void a_() {
        if (isExpired() || this.h || this.x) {
            return;
        }
        this.x = true;
        this.j = SystemClock.elapsedRealtime();
        h();
        AdInteractionListener adInteractionListener = this.f12554a;
        if (adInteractionListener != null) {
            adInteractionListener.onAdImpression();
        }
    }

    public <ValueType> ValueType b(String str, ValueType valuetype) {
        ValueType valuetype2 = (ValueType) this.C.get(str);
        return valuetype2 != null ? valuetype2 : valuetype;
    }

    @Override // sg.bigo.ads.api.b.a
    public final void b() {
        if (this.u) {
            return;
        }
        this.u = true;
        this.b.c.g.b();
        if (a("06002008")) {
            sg.bigo.ads.core.d.b.a(this, ((Boolean) b("is_cache", Boolean.FALSE)).booleanValue());
        }
    }

    public final void b(String str) {
        if (q.a((CharSequence) str)) {
            return;
        }
        this.A.add(str);
    }

    @Override // sg.bigo.ads.api.b.a
    public final void c() {
        if (this.e) {
            return;
        }
        this.e = true;
        this.k = SystemClock.elapsedRealtime();
        if (this.S instanceof c) {
            ((c) this.S).k = this.k;
        }
        if (this.b.f13106a.ah()) {
            return;
        }
        d("filled");
        if (this.b.f13106a.N().k() == 1) {
            s();
        }
        if (this.b.f13106a.N().c() == 2) {
            sg.bigo.ads.a.c.a(this.b.e);
        }
        sg.bigo.ads.common.f.b.a(this);
    }

    public final void c(String str) {
        if (q.a((CharSequence) str)) {
            return;
        }
        this.B.add(str);
    }

    @Override // sg.bigo.ads.api.b.a
    public final String d() {
        return f().H();
    }

    @Override // sg.bigo.ads.api.Ad
    public final void destroy() {
        this.h = true;
        if (sg.bigo.ads.common.n.d.b()) {
            C();
            destroyInMainThread();
        } else {
            sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.ad.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.C();
                    c.this.destroyInMainThread();
                }
            });
        }
        if (this.i) {
            sg.bigo.ads.common.form.a.a(f().hashCode(), 4);
        }
        sg.bigo.ads.common.form.a.b(f().hashCode());
        setAdInteractionListener(null);
        sg.bigo.ads.common.f.b.b(this);
    }

    protected void destroyInMainThread() {
    }

    @Override // sg.bigo.ads.api.b.a
    public final long e() {
        return f().a();
    }

    @Override // sg.bigo.ads.api.b.a
    public U f() {
        return (U) this.b.f13106a;
    }

    @Override // sg.bigo.ads.api.Ad
    public AdBid getBid() {
        if (this.z == null) {
            g gVar = this.b;
            sg.bigo.ads.api.core.c cVar = gVar.f13106a;
            this.z = cVar.ak() ? new sg.bigo.ads.ad.a.C0807a(gVar, cVar, this.d) : null;
        }
        return this.z;
    }

    @Override // sg.bigo.ads.api.Ad
    public String getExtraInfo(String str) {
        g gVar = this.b;
        sg.bigo.ads.api.core.c cVar = gVar != null ? gVar.f13106a : null;
        return cVar != null ? cVar.b(str) : "";
    }

    protected void h() {
        int i;
        l();
        if (this.R != sg.bigo.ads.common.v.a.e) {
            sg.bigo.ads.common.v.a aVar = this.Q;
            View view = this.c;
            if (aVar.g == sg.bigo.ads.common.v.a.e) {
                sg.bigo.ads.common.t.a.a(0, 4, "OutAppChecker", "Out app status: 4 - start activity from background");
                i = sg.bigo.ads.common.v.a.e;
            } else if (sg.bigo.ads.common.v.a.a(view)) {
                sg.bigo.ads.common.t.a.a(0, 4, "OutAppChecker", "Out app status: 5 - Lock screen");
                i = sg.bigo.ads.common.v.a.f;
            } else if (sg.bigo.ads.common.v.a.b(view)) {
                sg.bigo.ads.common.t.a.a(0, 4, "OutAppChecker", "Out app status: 3 - Float window");
                i = sg.bigo.ads.common.v.a.d;
            } else {
                sg.bigo.ads.common.t.a.a(0, 4, "OutAppChecker", "Out app status: 1 - not outside app");
                i = sg.bigo.ads.common.v.a.b;
            }
            this.R = i;
        }
        this.d.a(this.R);
        final sg.bigo.ads.core.e.a.a aVar2 = this.d;
        final Context context = this.b.e;
        sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.core.e.a.a.2

            /* JADX INFO: renamed from: a */
            final /* synthetic */ Context f13555a;
            final /* synthetic */ boolean b = false;

            public AnonymousClass2() {
                context = context;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a.this.a(context, this.b);
            }
        });
        if (a("06002010")) {
            sg.bigo.ads.core.d.b.a(this.b.e, this, (String) b("show_proportion", ""), i(), ((Integer) b("render_style", 0)).intValue(), u(), ((Long) b("attach_render_cost", -1L)).longValue(), SystemClock.elapsedRealtime() - this.k, ((Integer) b("icon_sta", -1)).intValue(), ((Integer) b("img_sta", -1)).intValue(), ((Integer) b("vid_sta", -1)).intValue());
        }
        if (this.b.f13106a.N().k() == 0) {
            s();
        }
    }

    public String i() {
        return this.c == null ? "" : this.c.getWidth() + VastAttributes.HORIZONTAL_POSITION + this.c.getHeight();
    }

    @Override // sg.bigo.ads.api.Ad
    public boolean isExpired() {
        return this.b.f13106a.J();
    }

    protected final void j() {
        AdInteractionListener adInteractionListener = this.f12554a;
        if (adInteractionListener != null) {
            adInteractionListener.onAdOpened();
        }
    }

    protected void k() {
        AdInteractionListener adInteractionListener = this.f12554a;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClosed();
        }
        this.g = true;
    }

    protected void l() {
        d("impression");
    }

    protected void m() {
        d(Reporting.EventType.VIDEO_AD_CLICKED);
    }

    public boolean n() {
        return this.x;
    }

    protected final int o() {
        return this.b.b.b();
    }

    protected final int p() {
        return this.b.f13106a.w();
    }

    public final int q() {
        if (this.s != f().y()) {
            return -1;
        }
        return this.q;
    }

    public final long r() {
        if (this.s != f().y()) {
            return 0L;
        }
        return this.r;
    }

    public void s() {
        if (this.b.f13106a.N().f() > 0) {
            final sg.bigo.ads.controller.landing.a aVar = new sg.bigo.ads.controller.landing.a(this.b.f13106a);
            this.l = aVar;
            final Context context = this.b.e;
            final String strA = aVar.b.a();
            final String strJ = aVar.b.j();
            final int iC = aVar.b.c();
            if (((aVar.c == 4 || aVar.c == 5) && TextUtils.isEmpty(strJ)) || sg.bigo.ads.core.landing.a.a(strA) || TextUtils.isEmpty(strA) || !strA.startsWith("http")) {
                return;
            }
            if (iC == 0 || iC == 2) {
                final sg.bigo.ads.controller.landing.a.InterfaceC0888a interfaceC0888a = new sg.bigo.ads.controller.landing.a.InterfaceC0888a() { // from class: sg.bigo.ads.controller.landing.a.3
                    @Override // sg.bigo.ads.controller.landing.a.InterfaceC0888a
                    public final void a(String str) {
                        sg.bigo.ads.common.t.a.a(0, 3, "Preload", "preloadWebView onStart preloadType = " + a.this.c + ", url = " + str);
                    }

                    @Override // sg.bigo.ads.controller.landing.a.InterfaceC0888a
                    public final void a(String str, long j, boolean z, int i) {
                        a.this.d = z;
                        HashMap map = new HashMap();
                        map.put("land_way", String.valueOf(i));
                        sg.bigo.ads.core.d.b.a(a.this.f13474a, "preload_cost", j, z ? 1 : 0, map);
                        sg.bigo.ads.common.t.a.a(0, 3, "Preload", "preload landing page onComplete preloadType=" + a.this.c + ", success = " + z + ", cost = " + j + ", url = " + str);
                        if (z) {
                            return;
                        }
                        a.this.a();
                    }
                };
                sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.controller.landing.a.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        int i = a.this.c;
                        if (i == 1) {
                            Uri uri = Uri.parse(strA);
                            a.a(a.this, context, uri.getScheme() + "://" + uri.getHost(), iC, interfaceC0888a);
                        } else if (i == 4 || i == 5) {
                            a.a(a.this, context, strJ, iC, interfaceC0888a);
                        }
                    }
                });
            }
        }
    }

    @Override // sg.bigo.ads.api.Ad, sg.bigo.ads.api.IconAds
    public void setAdInteractionListener(AdInteractionListener adInteractionListener) {
        this.f12554a = adInteractionListener;
    }

    protected final void t() {
        if (this.v) {
            return;
        }
        this.v = true;
        this.y = SystemClock.elapsedRealtime();
    }

    public final long u() {
        if (this.y == 0) {
            return 0L;
        }
        return SystemClock.elapsedRealtime() - this.y;
    }

    protected final boolean v() {
        WeakReference<a> weakReference = this.t;
        return (weakReference == null || weakReference.get() == null || !this.t.get().a()) ? false : true;
    }
}
